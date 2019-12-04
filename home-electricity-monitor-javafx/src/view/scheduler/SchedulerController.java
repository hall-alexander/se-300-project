package view.scheduler;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import view.ViewHandler;
import viewmodel.SchedulerViewModel;


public class SchedulerController {
	
	
	
 /*
   @FXML
   private Button submitButton;
   @FXML
   private Button helpButton;
*/  
	
	@FXML
	private Label applianceLabel;

	@FXML
	private Label wattageLabel;

	@FXML
	private Spinner<Integer> startHourSpinner;
	@FXML
	private Spinner<Integer> startMinuteSpinner;
	@FXML
	private Spinner<Integer> startSecondSpinner;

	@FXML
	private Spinner<Integer> stopHourSpinner;
	@FXML
	private Spinner<Integer> stopMinuteSpinner;
	@FXML
	private Spinner<Integer> stopSecondSpinner;

	private SchedulerViewModel viewModel;

	public void init(SchedulerViewModel loginViewModel) {
		this.viewModel = loginViewModel;

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

		startHourSpinner.getValueFactory().valueProperty().bindBidirectional(viewModel.startHourProperty().asObject());
		startMinuteSpinner.getValueFactory().valueProperty().bindBidirectional(viewModel.startMinuteProperty().asObject());
		startSecondSpinner.getValueFactory().valueProperty().bindBidirectional(viewModel.startSecondProperty().asObject());
		stopHourSpinner.getValueFactory().valueProperty().bindBidirectional(viewModel.endHourProperty().asObject());
		stopMinuteSpinner.getValueFactory().valueProperty().bindBidirectional(viewModel.endMinuteProperty().asObject());
		stopSecondSpinner.getValueFactory().valueProperty().bindBidirectional(viewModel.endSecondProperty().asObject());
	}

	public void submitButtonAction(ActionEvent event) {
		viewModel.submitFunctionality();
	}

	public void setViewHandler(ViewHandler viewHandler) {
		viewModel.setViewHandler(viewHandler);
	}  

   
}