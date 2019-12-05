package view.scheduler;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import view.ViewHandler;
import viewmodel.MappingViewModel.Appliance;
import viewmodel.SchedulerViewModel;


public class SchedulerController {
	
	
	
 /*
   @FXML
   private Button submitButton;
   @FXML
   private Button helpButton;
*/  
	
	@FXML
	private AnchorPane ap;
	
	@FXML
	private Label applianceLabel;

	@FXML
	private Label wattageLabel;

	@FXML
	private Spinner<Integer> startHourSpinner;
	@FXML
	private Spinner<Integer> startMinuteSpinner;

	@FXML
	private Spinner<Integer> stopHourSpinner;
	@FXML
	private Spinner<Integer> stopMinuteSpinner;

	private SchedulerViewModel viewModel;

	public void init(SchedulerViewModel loginViewModel) {
		this.viewModel = loginViewModel;

		// initialize all the spinner values and set appropriate ranges for hours, minutes, seconds
		SpinnerValueFactory<Integer>startHourValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,24,0);
		this.startHourSpinner.setValueFactory(startHourValueFactory);

		SpinnerValueFactory<Integer>startMinuteValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,55,0, 5);
		this.startMinuteSpinner.setValueFactory(startMinuteValueFactory);

		SpinnerValueFactory<Integer>stopHourValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,24,0);
		this.stopHourSpinner.setValueFactory(stopHourValueFactory);

		SpinnerValueFactory<Integer>stopMinuteValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,55,0,5);
		this.stopMinuteSpinner.setValueFactory(stopMinuteValueFactory);

		applianceLabel.textProperty().bind(viewModel.applianceLabelProperty());
		wattageLabel.textProperty().bind(viewModel.wattageLabelProperty());
		startHourSpinner.getValueFactory().valueProperty().bindBidirectional(viewModel.startHourProperty().asObject());
		startMinuteSpinner.getValueFactory().valueProperty().bindBidirectional(viewModel.startMinuteProperty().asObject());
		stopHourSpinner.getValueFactory().valueProperty().bindBidirectional(viewModel.endHourProperty().asObject());
		stopMinuteSpinner.getValueFactory().valueProperty().bindBidirectional(viewModel.endMinuteProperty().asObject());
	}
	
	public void setApplianceLabels(Appliance appliance) {
		viewModel.setApplianceLabel(appliance.getName());
		viewModel.setWattageLabel(Double.toString(appliance.getWatt()));
	}

	public void submitButtonAction(ActionEvent event) {
		Stage window = (Stage) ap.getScene().getWindow();
		viewModel.submitFunctionality(window);

	}

	public void setViewHandler(ViewHandler viewHandler) {
		viewModel.setViewHandler(viewHandler);
	}  

   
}