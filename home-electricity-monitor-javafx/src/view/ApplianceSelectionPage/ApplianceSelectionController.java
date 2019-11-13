package view.ApplicationSelection;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;
import view.ViewHandler;
import viewmodel.ApplianceSelectionViewModel;

public class ApplianceSelectionController {

	@FXML CheckBox bigTV; @FXML CheckBox smallTV; @FXML CheckBox waterHeater; @FXML CheckBox dishWasher; @FXML CheckBox oven; @FXML CheckBox microwave;
	@FXML CheckBox refridgerator; @FXML CheckBox coffeeMaker; @FXML CheckBox pressureCooker; @FXML CheckBox washingMachine; @FXML CheckBox clothesDryer;
	@FXML CheckBox phoneCharger; @FXML CheckBox toaster; @FXML CheckBox waterPump; @FXML CheckBox dvdPlayer; @FXML CheckBox amazonEcho;
	@FXML CheckBox gameConsole; @FXML CheckBox centralACUnit; @FXML CheckBox ceilingFan; @FXML CheckBox desktopComputer; @FXML CheckBox blowDryer;
	@FXML CheckBox ledBulbMax; 	@FXML CheckBox ledBulbMed; @FXML CheckBox ledBulbMin;
	@FXML CheckBox bigTVNum; @FXML CheckBox smallTVNum; @FXML CheckBox waterHeaterNum; @FXML CheckBox dishWasherNum; @FXML CheckBox ovenNum; @FXML CheckBox microwaveNum;
	@FXML CheckBox refridgeratorNum; @FXML CheckBox coffeeMakerNum; @FXML CheckBox pressureCookerNum; @FXML CheckBox washingMachineNum; @FXML CheckBox clothesDryerNum;
	@FXML CheckBox phoneChargerNum; @FXML CheckBox toasterNum; @FXML CheckBox waterPumpNum; @FXML CheckBox dvdPlayerNum; @FXML CheckBox amazonEchoNum;
	@FXML CheckBox gameConsoleNum; @FXML CheckBox centralACUnitNum; @FXML CheckBox ceilingFanNum; @FXML CheckBox desktopComputerNum; @FXML CheckBox blowDryerNum;
	@FXML CheckBox ledBulbMaxNum; 	@FXML CheckBox ledBulbMedNum; @FXML CheckBox ledBulbMinNum;
	
	private ApplianceSelectionViewModel viewModel;
	
	public ApplianceSelectionController() {
		
	}
	
	public void init(ApplianceSelectionViewModel applianceSelectionViewModel) {
		this.viewModel = applianceSelectionViewModel;
	}
	
	public void setViewHandler(ViewHandler viewHandler) {
		viewModel.setViewHandler(viewHandler);
	}
	
	public void changeBigTVNum(ActionEvent e) {
		Double view = null;
		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
		
		view = ((CheckBox)e.getSource()).getNumBigTV();
		viewModel.getViewHandler().changeBigTVNum(view, window);
	}
	
}
