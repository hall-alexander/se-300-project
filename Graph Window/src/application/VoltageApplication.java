package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
 
public class VoltageApplication  extends Application {
    
  
    @Override
    public void start(Stage primaryStage) {
        try {
            // Read FXML file for the login scene and draw interface.
            String fxmlPath = "application/LoginScene.fxml";
        	//Parent root = FXMLLoader.load(getClass().getClassLoader().getResource(fxmlPath));
        	FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(fxmlPath));
        	Parent root = loader.load();

         	
            primaryStage.setTitle("Appliance Voltage App");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
            
            /*
            // Read FXML file for the chart and draw interface.
            String fxmlPath2 = "application/ChartScene.fxml";
        	Parent root2 = FXMLLoader.load(getClass().getClassLoader().getResource(fxmlPath2));
         	
        	Stage subStage = new Stage();
            //subStage.setTitle("Appliance Voltage");
            subStage.setScene(new Scene(root2));
            subStage.show();
            */
         
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}