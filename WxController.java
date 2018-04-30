/*
 * Name:       Noah Lopez
 *
 * Course:     CSCI 13, Spring 2017
 *
 * Date:       4/24/18
 *
 * Filename:   WxController.java
 *
 * Purpose:   Controller for the FXML document, WxView
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class WxController implements Initializable
{

    @FXML
    private TextField txtZipcode;
    
    @FXML
    private Button btnGo;
    
    @FXML
    private Label lblLocation;
    
    @FXML
    private Label lblTempF;
    
    @FXML
    private Label lblObsTime;
    
    @FXML
    private Label lblPressure;
    
    @FXML
    private Label lblWind;
    
    @FXML
    private Label lblVisibility;
    
    @FXML
    private Label lblWeather;
    
    @FXML
    private ImageView iconwx;
    
    @FXML
    private void handleButtonAction(ActionEvent e)
    {
        //Create object to access the Model
        WxModel weather = new WxModel();
        
        if (e.getSource() == btnGo)
        {
            String zipcode = txtZipcode.getText();
            if (weather.getWx(zipcode))
            {
                lblLocation.setText(weather.getLocation());
                lblObsTime.setText(weather.getObservedTime());
                lblWeather.setText(weather.getWeather());
                lblTempF.setText(String.valueOf(weather.getTempF()));
                lblWind.setText(weather.getWindStr());
                lblPressure.setText(weather.getPressure());
                lblVisibility.setText(weather.getVisibility());
                iconwx.setImage(weather.getIcon());
            }
            else
            {
                lblLocation.setText("Invalid Zipcode");
                lblObsTime.setText("");
                lblWeather.setText("");
                lblTempF.setText("");
                lblWind.setText("");
                lblPressure.setText("");
                lblVisibility.setText("");
                iconwx.setImage(new Image("badzipcode.png"));
            }
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
    }
   
}//end class