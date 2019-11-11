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
import view.ViewHandler;
import view.chart.ChartController;
import viewmodel.HomePageViewModel;
import viewmodel.LoginViewModel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import javafx.application.Platform;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;


public class LoginController {
	
	
	
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
  
   private LoginViewModel viewModel;
   
   public void init(LoginViewModel loginViewModel) {
		this.viewModel = loginViewModel;
		
		applianceChoiceBox.setValue("Alexa");
		applianceChoiceBox.getItems().addAll("Alexa", "TV", "HVAC", "Radio", "Refrigerator", "Dishwasher");
		   
		// initialize and add all available priorities to the drop down
		priorityChoiceBox.setValue("1");
		priorityChoiceBox.getItems().addAll("1", "2", "3");
		   
		// initialize all the spinner values and set appropriate ranges for hours, minutes, seconds
		SpinnerValueFactory<Integer>startHourValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,24,0);
		this.startHourSpinner.setValueFactory(startHourValueFactory);
	       
		SpinnerValueFactory<Integer>startMinuteValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,59,0);
		this.startMinuteSpinner.setValueFactory(startMinuteValueFactory);

		SpinnerValueFactory<Integer>startSecondValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,59,0);
		this.startSecondSpinner.setValueFactory(startSecondValueFactory);

		SpinnerValueFactory<Integer>stopHourValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,24,0);
		this.stopHourSpinner.setValueFactory(stopHourValueFactory);

		SpinnerValueFactory<Integer>stopMinuteValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,59,0);
		this.stopMinuteSpinner.setValueFactory(stopMinuteValueFactory);

		SpinnerValueFactory<Integer>stopSecondValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,59,0);
		this.stopSecondSpinner.setValueFactory(stopSecondValueFactory);

		applianceChoiceBox.valueProperty().bindBidirectional(viewModel.applianceNameProperty());
		startDatePicker.valueProperty().bindBidirectional(viewModel.startDateProperty());
		startHourSpinner.getValueFactory().valueProperty().bindBidirectional(viewModel.startHourProperty().asObject());
		startMinuteSpinner.getValueFactory().valueProperty().bindBidirectional(viewModel.startMinuteProperty().asObject());
		startSecondSpinner.getValueFactory().valueProperty().bindBidirectional(viewModel.startSecondProperty().asObject());
		stopDatePicker.valueProperty().bindBidirectional(viewModel.endDateProperty());
		stopHourSpinner.getValueFactory().valueProperty().bindBidirectional(viewModel.endHourProperty().asObject());
		stopMinuteSpinner.getValueFactory().valueProperty().bindBidirectional(viewModel.endMinuteProperty().asObject());
		stopSecondSpinner.getValueFactory().valueProperty().bindBidirectional(viewModel.endSecondProperty().asObject());
		priorityChoiceBox.valueProperty().bindBidirectional(viewModel.priorityProperty());
	}
 
   public void submitButtonAction(ActionEvent event) {
       viewModel.submitFunctionality();
   }

   public void setViewHandler(ViewHandler viewHandler) {
	   viewModel.setViewHandler(viewHandler);
   }  
   
   
}