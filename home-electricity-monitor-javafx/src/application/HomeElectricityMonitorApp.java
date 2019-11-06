package application;

import javafx.application.Application;
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
    	
    }

}

