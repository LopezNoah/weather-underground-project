/*
 * Name:       Noah Lopez
 *
 * Course:     CSCI 13, Spring 2017
 *
 * Date:       4/24/18
 *
 * Filename:   WxModel.java
 *
 * Purpose:   Model for Weather Underground
 */

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.net.URL;
import javafx.scene.image.Image;
import com.google.gson.*;

public class WxModel{

    private JsonElement jse = null;
    private String weatherReport = null;
    private final String apiKey = "ebfc9191d14c892b";
    
    public boolean getWx(String zipcode)
    {
        try
        {
            //Construct WUnderground zipcode url
            URL wuURL = new URL("http://api.wunderground.com/api/"
                    + apiKey
                    + "/conditions/q/"
                    + zipcode
                    + ".json");
            //http://api.wunderground.com/api/ebfc9191d14c892b/conditions/q/zipCode.json
            //http://api.wunderground.com/api/Your_Key/geolookup/q/94107.json
            
            //Open the URL
            InputStream is = wuURL.openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            
            jse = new JsonParser().parse(br);
            is.close();
            br.close();      
        }
        catch (java.io.UnsupportedEncodingException uee)
		{
			uee.printStackTrace();
		}
		catch (java.net.MalformedURLException mue)
		{
			mue.printStackTrace();
		}
		catch (java.io.IOException ioe)
		{
			ioe.printStackTrace();
		}
        
        //Check to see if zip code was valid
        return isValid();
    }
    
    public boolean isValid()
    {
        try
        {
            jse.getAsJsonObject().get("response").getAsJsonObject().has("error");
            return false;
        }
        catch (java.lang.NullPointerException npe)
        {
            //zip code was valid because there was no error
            return true;
        }
    }
    
    /*full - city and state
    observation_time
    weather
    temp_f
    wind_string
    pressure_in
    visibility_mi
    icon - icon that depicts the current weather*/
    public String getLocation()
    {
        return jse.getAsJsonObject().get("current_observation")
                               .getAsJsonObject().get("display_location")
                               .getAsJsonObject().get("full").getAsString();
    }
    
    public String getObservedTime()
    {
        return jse.getAsJsonObject().get("current_observation")
                                .getAsJsonObject().get("observation_time").getAsString();
    }
    
    public String getWeather()
    {
        return jse.getAsJsonObject().get("current_observation")
                            .getAsJsonObject().get("weather").getAsString();
    }
    
    public double getTempF()
    {
        return jse.getAsJsonObject().get("current_observation")
                            .getAsJsonObject().get("temp_f").getAsDouble();
    }
    
    public String getWindStr()
    {
        return jse.getAsJsonObject().get("current_observation")
                            .getAsJsonObject().get("wind_string").getAsString();
    }
    
    public String getPressure()
    {
        return jse.getAsJsonObject().get("current_observation")
                            .getAsJsonObject().get("pressure_in").getAsString();
    }
    
    public String getVisibility()
    {
        return jse.getAsJsonObject().get("current_observation")
                            .getAsJsonObject().get("visibility_mi").getAsString();
    }
    
    public Image getIcon()
    {
        String iconURL = jse.getAsJsonObject().get("current_observation")
                            .getAsJsonObject().get("icon_url").getAsString();
        return new Image(iconURL);
    }
    
}//end class