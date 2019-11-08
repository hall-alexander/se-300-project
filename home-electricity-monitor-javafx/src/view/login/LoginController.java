package view.login;

import java.net.URL;
import java.text.*;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
//import javafx.scene.control.Button;
//import javafx.scene.control.TextField;
//import javafx.scene.control.ChoiceBox;
//import javafx.scene.control.Spinner;
//import javafx.scene.control.DatePicker;
import javafx.scene.control.*;
import javafx.stage.Window;
import view.chart.ChartController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import javafx.application.Platform;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;


public class LoginController implements Initializable {
	
	
	
 /*
   @FXML
   private Button submitButton;
   @FXML
   private Button helpButton;
*/  
   @FXML
   private ChoiceBox<String> applianceChoiceBox;
   @FXML
   private ChoiceBox<String> priorityChoiceBox;

   @FXML
   private DatePicker startDatePicker;
   @FXML
   private Spinner<Integer> startHourSpinner;
   @FXML
   private Spinner<Integer> startMinuteSpinner;
   @FXML
   private Spinner<Integer> startSecondSpinner;
   
   @FXML
   private DatePicker stopDatePicker;
   @FXML
   private Spinner<Integer> stopHourSpinner;
   @FXML
   private Spinner<Integer> stopMinuteSpinner;
   @FXML
   private Spinner<Integer> stopSecondSpinner;
  
   // Initialize the scene controls
   @Override
   public void initialize(URL location, ResourceBundle resources) {
       
	   // initialize and add all the appliances you want to include in the drop down
	   applianceChoiceBox.setValue("Alexa");
	   applianceChoiceBox.getItems().addAll("Alexa", "TV", "HVAC", "Radio", "Refrigerator", "Dishwasher");
	   
	   // initialize and add all available priorities to the drop down
	   priorityChoiceBox.setValue("1");
	   priorityChoiceBox.getItems().addAll("1", "2", "3");
	   
	   // initialize all the spinner values and set appropriate ranges for hours, minutes, seconds
       SpinnerValueFactory<Integer>startHourValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,24,0);
       this.startHourSpinner.setValueFactory(startHourValueFactory);
       // let the user enter their own number if they wish
       //startHourSpinner.setEditable(true);
       
       SpinnerValueFactory<Integer>startMinuteValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,59,0);
       this.startMinuteSpinner.setValueFactory(startMinuteValueFactory);
       //startMinuteSpinner.setEditable(true);

       SpinnerValueFactory<Integer>startSecondValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,59,0);
       this.startSecondSpinner.setValueFactory(startSecondValueFactory);
       //startSecondSpinner.setEditable(true);
       
       SpinnerValueFactory<Integer>stopHourValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,24,0);
       this.stopHourSpinner.setValueFactory(stopHourValueFactory);
       //stopHourSpinner.setEditable(true);
       
       SpinnerValueFactory<Integer>stopMinuteValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,59,0);
       this.stopMinuteSpinner.setValueFactory(stopMinuteValueFactory);
       //stopMinuteSpinner.setEditable(true);

       SpinnerValueFactory<Integer>stopSecondValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,59,0);
       this.stopSecondSpinner.setValueFactory(stopSecondValueFactory);
       //stopSecondSpinner.setEditable(true);

        
   }
 
   // When user clicks on submitButton
   // this method will be called.
   public void submitButtonAction(ActionEvent event) {
       System.out.println("Submit Button Clicked!");
      
       String applianceName;
       Integer appliancePriority;
       String startDate, stopDate;
       //String buffer;
       
       applianceName = applianceChoiceBox.getValue().toString();
       System.out.println("Appliance "+applianceName);
       appliancePriority = Integer.valueOf(priorityChoiceBox.getValue());
       System.out.println("Priority "+appliancePriority);
       
       
       // date format is ISO_LOCAL_DATE  or  2019-1-05
       startDate = startDatePicker.getValue().toString();
       System.out.println("Start Date "+startDate);
       
       // make time format ISO_LOCAL_TIME or HH:mm:ss
       LocalTime startTime = formatStartTime();
       System.out.println("Start Time "+startTime);
       
       
       // date format is ISO_LOCAL_DATE  or  2019-1-05
       stopDate = stopDatePicker.getValue().toString();
       System.out.println("Stop Date "+stopDate);

       // make time format ISO_LOCAL_TIME or HH:mm:ss
       LocalTime stopTime = formatStopTime();
       System.out.println("Start Time "+stopTime);
       
       // see if stop time comes after start time
       boolean isbefore = startTime.isBefore(stopTime);
       if (isbefore) {
          System.out.println("Start is before Stop");
          
          // SHOW CHART
          showChart(applianceName, startTime, stopTime, appliancePriority);
         
       }
       else {
    	   //TODO  error processing here because start must be before stop
    	   //That means checking the date and time
       }
       
       
   }  
   
   // When user clicks on helpButton
   // this method will be called.
   public void helpButtonAction(ActionEvent event) {
       System.out.println("Help Button Clicked!");
   
   }

   public void showChart(String applianceName, LocalTime startTime, LocalTime stopTime, Integer appliancePriority) {
	   
		final int WINDOW_SIZE = 10;

	   
       // Read FXML file for the chart and draw interface.
       String fxmlPath2 = "application/ChartScene.fxml";
       try {
    	   
     	//Parent root2 = FXMLLoader.load(getClass().getClassLoader().getResource(fxmlPath2));
    	FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(fxmlPath2));
    	Parent root2 = loader.load();
    	
        System.out.println("showChart - after Loader");
        
        // get an instance of the linechart Controller so we can access it from here
    	ChartController chartController = loader.getController();
        chartController.printmsg("Hello from LoginController");
        
        // Line Chart stuff:
 	   XYChart.Series<String, Number> series = new XYChart.Series<>();
 	   series.setName(applianceName);
 	   chartController.voltageChart.getData().add(series);
       System.out.println("showChart - after XYChart");
     	
     	Stage subStage = new Stage();
       //subStage.setTitle("Appliance Voltage");
       subStage.setScene(new Scene(root2));
       subStage.show();
       }catch (Exception e) {
       	e.printStackTrace();
       }
   
       // Now add the REAL chart logic here:
       //
       //
       // setup a scheduled executor to periodically put data into the chart
       Executors.newSingleThreadScheduledExecutor();
       
       ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1); 
     
       // Run scheduler until the stop time entered by the user is reached
		scheduler.scheduleAtFixedRate(() -> {
			
		    // get random integer for voltage
		    Integer randomVolts = ThreadLocalRandom.current().nextInt(10);
		    System.out.println("Random Volts:  " + randomVolts);
		    
    	    // Add one second to the time
	    	 startTime.plusSeconds(1);
             System.out.println("Time + 1:  "+startTime);
           // update the chart if stop time has not been reached
	        Platform.runLater(() -> {
             if(startTime.compareTo(stopTime) < 0) {
           	    //chartController.voltageChart.getData().add(series);
                 /*
	        	 series.getData().add(new XYChart.Data<>(startTime, randomVolts));
                if (series.getData().size() > WINDOW_SIZE) {
                  series.getData().remove(0);
                } 
                */
             }
             else {
           	 // update chart with last value
           	 // TODO figure out why the last value doesn't always get put on the chart with the above if()
            	 /*
           	 series.getData().add(new XYChart.Data<>(startTime, randomVolts));
                if (series.getData().size() > WINDOW_SIZE) {
                  series.getData().remove(0);
                }
                */
           	  // TODO You're done - figure out what to do next - stop scheduler for now
           	  scheduler.shutdown();
             }
 	        });
	        
		},  0,  1, TimeUnit.SECONDS); // run every second
      
       
   }
   
   
   
   
   
   public LocalTime formatStartTime() {
       String hours, minutes, seconds;
       String buffer;

       // we retrieve start time pieces as strings, then create our HH:mm:ss format
       hours = startHourSpinner.getValue().toString();
       System.out.println("Hours "+hours);

       minutes = startMinuteSpinner.getValue().toString();
       System.out.println("Minutes "+minutes);
       
       seconds = startSecondSpinner.getValue().toString();
       System.out.println("Seconds "+seconds);
       
       // time format needs to be HH:mm:ss  so if we get a one digit input, put a "0" in front of it
       if (hours.length()==1) {
    	  String saveHours = hours;
    	  hours = "0"+saveHours;
       }
       if (minutes.length()==1) {
    	  String saveMinutes = minutes;
    	  minutes = "0"+saveMinutes;
       }
       if (seconds.length()==1) {
    	  String saveSeconds = seconds;
    	  seconds = "0"+saveSeconds;
       }
       
       buffer = hours+":"+minutes+":"+seconds;
       System.out.println("Time "+buffer);
       
       LocalTime startTime = LocalTime.parse(buffer);
       System.out.println("Start Time "+startTime);
	   
	   return startTime;
   }
   
   public LocalTime formatStopTime() {

       String hours, minutes, seconds;
       String buffer;

       // we retrieve stop time pieces as strings, then create our HH:mm:ss format
       hours = stopHourSpinner.getValue().toString();
       System.out.println("Hours "+hours);

       minutes = stopMinuteSpinner.getValue().toString();
       System.out.println("Minutes "+minutes);
       
       seconds = stopSecondSpinner.getValue().toString();
       System.out.println("Seconds "+seconds);
       
       // time format needs to be HH:mm:ss  so if we get a one digit input, put a "0" in front of it
       if (hours.length()==1) {
    	  String saveHours = hours;
    	  hours = "0"+saveHours;
       }
       if (minutes.length()==1) {
    	  String saveMinutes = minutes;
    	  minutes = "0"+saveMinutes;
       }
       if (seconds.length()==1) {
    	  String saveSeconds = seconds;
    	  seconds = "0"+saveSeconds;
       }
       
       buffer = hours+":"+minutes+":"+seconds;
       System.out.println("Time "+buffer);
       
       LocalTime stopTime = LocalTime.parse(buffer);
       System.out.println("Stop Time "+stopTime);

       return stopTime;
   }
   
   
   
}