/*
 * Name:       Noah Lopez
 *
 * Course:     CSCI 13, Spring 2017
 *
 * Date:       4/24/18
 *
 * Filename:   WxMain.java
 *
 * Purpose:   Main for Weather Underground
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class WxMain extends Application{

    @Override
    public void start(Stage stage) throws Exception
    {
        //Parent root = FXMLLoader.load(getClass().getResource("./WxView.fxml"));
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("./WxView.fxml"));
        //AnchorPane root = (AnchorPane) FXMLLoader.load(WxMain.class.getResource("./WxView.fxml"));
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setTitle("Wx - Noah Lopez");
        stage.show();
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }
    
    /*- You must use a zipcode to get the weather information
    - You must ensure that the zipcode entered is valid. If it is not valid, display a message.
    - Your model must handle all data access and manipulation
    - Your view must be an fxml file created using SceneBuilder.
    The view cannot contain a FlowPane.
    - The Title of the view must be "Wx - First Last".
     Replace First with your first name and Last with your last name.
    */

}//end class