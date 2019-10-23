package application;

import javafx.application.Application;

import javafx.application.Platform;

import javafx.scene.Scene;

import javafx.scene.chart.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import javafx.event.*;
import javafx.geometry.*;

import javafx.stage.Stage;
import javafx.stage.Window;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
//import java.time.temporal.ChronoUnit;
import java.util.*;

import java.util.concurrent.*;


public class VoltageApp extends Application {
	Scene loginScene;
	
	String applianceName, applianceStartTime, applianceStopTime;
	
	
	Integer appliancePriority;
	
    //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
    
    
    @Override
    public void start(Stage primaryStage) throws Exception { 
    	
    	// First scene - login window
    	// Create labels:
    	Text applianceNameLabel = new Text("Appliance Name:");
    	Text applianceStartTimeLabel = new Text("Start Time (HH:mm:ss):");
    	Text applianceStopTimeLabel = new Text("Stop Time (HH:mm:ss):");
    	Text appliancePriorityLabel = new Text("Priority (1-3):");
    	
    	// Create text fields:
    	TextField applianceNameField = new TextField();
    	TextField applianceStartTimeField = new TextField();
    	TextField applianceStopTimeField = new TextField();
    	TextField appliancePriorityField = new TextField();
    	
    	// Buttons for Login Window:
    	Button submitButton = new Button("Submit");
    	Button clearButton = new Button("Clear");
    	Button helpButton = new Button("Help");
    	
    	// Creating the Pane
    	GridPane loginWindow = new GridPane();
    	
    	// Setting the size for the pane
    	loginWindow.setMinSize(400, 300);
    	
    	// Setting the padding
    	loginWindow.setPadding(new Insets(10,10,10,10));
    	
    	// Setting the vertical and horizontal gaps between the columns
    	loginWindow.setVgap(5);
    	loginWindow.setHgap(5);
    	
    	// Setting the Grid alignment
    	loginWindow.setAlignment(Pos.CENTER);
    	
    	// Arranging all the nodes in the grid for loginWindow
    	loginWindow.add(applianceNameLabel,  0,  0);
    	loginWindow.add(applianceNameField, 1, 0);
    	loginWindow.add(applianceStartTimeLabel, 0, 1);
    	loginWindow.add(applianceStartTimeField, 1, 1);
    	loginWindow.add(applianceStopTimeLabel, 0, 2);
    	loginWindow.add(applianceStopTimeField, 1, 2);
    	loginWindow.add(appliancePriorityLabel, 0, 3);
    	loginWindow.add(appliancePriorityField, 1, 3);
    	
    	loginWindow.add(submitButton, 0, 12);
    	loginWindow.add(clearButton,  1, 12);
    	loginWindow.add(helpButton,  2, 12);
    	
    	// Creating a scene object
    	loginScene = new Scene(loginWindow);
    	
    	// Setting the title to the stage
        primaryStage.setTitle("Appliance Voltage App");
    	
    	// Adding beginning scene to the stage
        primaryStage.setScene(loginScene);
        
        // Displaying the contents of the stage
        primaryStage.show();
    	
        
        //*****************************************************************************
        // BUTTON ACTIONS:
        //*****************************************************************************
        // Action for Submit Button
        submitButton.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent event) {
        		
        	// Retrieve and validate Appliance
        	if(applianceNameField.getText().isEmpty()) {
        		showAlert(Alert.AlertType.ERROR, primaryStage.getScene().getWindow(), "Input Error", "Please enter an Appliance");
        		return;
        	}
        	else {
            	applianceName = applianceNameField.getText();
        	}
        	
        	// Retrieve and validate Start Time
        	if(applianceStartTimeField.getText().isEmpty()) {
        		showAlert(Alert.AlertType.ERROR, primaryStage.getScene().getWindow(), "Input Error", "Please enter a Start Time: HH:mm:ss");
        		return;
        	}
        	else {
            	applianceStartTime = applianceStartTimeField.getText();
            	//System.out.println("Start Time: " + applianceStartTime);
        	}

        	// Retrieve and validate Stop Time
        	if(applianceStopTimeField.getText().isEmpty()) {
        		showAlert(Alert.AlertType.ERROR, primaryStage.getScene().getWindow(), "Input Error", "Please enter a Stop Time: HH:mm:ss");
        		return;
        	}
        	else {
            	applianceStopTime = applianceStopTimeField.getText();
            	//System.out.println("Start Time: " + applianceStopTime);
            	
            	// make sure stop time comes after start time
            	LocalTime startTime = LocalTime.parse(applianceStartTime);
            	LocalTime stopTime = LocalTime.parse(applianceStopTime);
            	
            	boolean isbefore = startTime.isBefore(stopTime);
            	
            	if (!isbefore) {
            		showAlert(Alert.AlertType.ERROR, primaryStage.getScene().getWindow(), "Input Error", "Stop Time must come after Start Time");
            		return;
            	}

        	}

        	// Retrieve and validate Priority level
        	if(appliancePriorityField.getText().isEmpty()) {
        		showAlert(Alert.AlertType.ERROR, primaryStage.getScene().getWindow(), "Input Error", "Please enter a Priority level");
        		return;
        	}
        	else {
        		appliancePriority = Integer.valueOf(appliancePriorityField.getText());
        		if (appliancePriority < 1 || appliancePriority >3) {
            		showAlert(Alert.AlertType.ERROR, primaryStage.getScene().getWindow(), "Input Error", "Please enter a valid Priority level");
            		return;
        		}
        	}
        	
        	// Create and display the voltage chart
        	try {
				showChart(applianceName, applianceStartTime, applianceStopTime, appliancePriority);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
          } // end handle()
        });

        // Action for Clear Button
        clearButton.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent event) {
        	applianceNameField.setText("");
        	applianceStartTimeField.setText("");
        	applianceStopTimeField.setText("");
        	appliancePriorityField.setText("");
        	}
        });

        // Action for Help Button
        helpButton.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent event) {
        		
        	String helpString = String.format("List of valid appliances:\n"
        			+ "Air Conditioning\n"
        			+ "Television\n"
        			+ "Refridgerator\n\n"
        			+ "Time entries must be in proper format\n"
        			+ "Examples:  04:10:13    22:50:01    10:00:00\n\n"
        			+ "Priority level 1 = low, 2 = norm, 3 = high\n");
        	
        	showAlert(Alert.AlertType.INFORMATION, primaryStage.getScene().getWindow(), "Valid Input:", helpString);
        	
         	}
        });
      
        
        
    } // end start()
    
    
    private void showChart(String applianceName, String applianceStartTime, String applianceStopTime, Integer appliancePriority) throws ParseException {
    	
    	final int WINDOW_SIZE = 10;
    	
       //***************** CHART Setup *********************
        Stage subStage = new Stage();
        subStage.setTitle("Appliance Voltage");

        //defining the axes
        final CategoryAxis xAxis = new CategoryAxis(); //  plot against time
        xAxis.setLabel("Time/s");

        final NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Volts");
 
        //creating the line chart with two axis created above
        final LineChart<String, Number> lineChart = new LineChart<>(xAxis, yAxis);

        lineChart.setTitle("Voltage Output");

        //defining a series to display data
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName(applianceName);
        lineChart.getData().add(series);
        
        Scene applianceScene = new Scene(lineChart, 600, 400);
        
	    subStage.setScene(applianceScene);
	    subStage.show();
        //****************************************************************
	    
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Date startTime = sdf.parse(applianceStartTime);
        Date stopTime = sdf.parse(applianceStopTime);
  	    Calendar calStart = Calendar.getInstance();
  	    Calendar calStop = Calendar.getInstance();
  	    calStart.setTime(startTime);
  	    calStop.setTime(stopTime);
    
        System.out.println("Start Time: " + sdf.format(startTime));
        System.out.println("Stop Time: " + sdf.format(stopTime));
        
        // setup a scheduled executor to periodically put data into the chart
        Executors.newSingleThreadScheduledExecutor();
        
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1); 
      
        // Run scheduler until the stop time entered by the user is reached
 		scheduler.scheduleAtFixedRate(() -> {
 			
 		    // get random integer for voltage
 		    Integer randomVolts = ThreadLocalRandom.current().nextInt(10);
 		    System.out.println("Random Volts:  " + randomVolts);
 		    
     	    // Add one second to the time
     	    calStart.add(Calendar.SECOND, 1);
	    	System.out.println("Time + 1:  " + sdf.format(calStart.getTime()));

            // update the chart if stop time has not been reached
 	        Platform.runLater(() -> {
              if(calStart.before(calStop)) {
 	        	 series.getData().add(new XYChart.Data<>(sdf.format(calStart.getTime()), randomVolts));
                 if (series.getData().size() > WINDOW_SIZE) {
                   series.getData().remove(0);
                 }
              }
              else {
            	 // update chart with last value
            	 // TODO figure out why the last value doesn't always get put on the chart with the above if()
            	 series.getData().add(new XYChart.Data<>(sdf.format(calStart.getTime()), randomVolts));
                 if (series.getData().size() > WINDOW_SIZE) {
                   series.getData().remove(0);
                 }
            	  // TODO You're done - figure out what to do next - stop scheduler for now
            	  scheduler.shutdown();
              }
  	        });
 	        
		},  0,  1, TimeUnit.SECONDS); // run every second
       
    }

    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

	public static void main(String[] args) {
	    launch(args);
	}
}