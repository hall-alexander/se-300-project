package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.ModelFactory;
import view.ViewHandler;
import viewmodel.ViewModelFactory;

public class HomeElectricityMonitorApp extends Application {

   

    @Override
    public void start(Stage primaryStage) throws Exception{
    	
    	ModelFactory mf = new ModelFactory();
    	ViewModelFactory vmf = new ViewModelFactory(mf);
    	ViewHandler vh = new ViewHandler(primaryStage, vmf);
    	vh.start();
    	
    	
    	/*
        Parent root = FXMLLoader.load(getClass().getResource("/view/HomePage/NewHomePage.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 1280, 750));
        primaryStage.show();*/
    }


}

