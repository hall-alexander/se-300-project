package view.simulation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import view.ViewHandler;
import viewmodel.SimulationViewModel;

public class SimulationController {

	@FXML
	ImageView image;
	
	
	private SimulationViewModel viewModel;
	
	
	public void init(SimulationViewModel simulationViewModel) {
		this.viewModel = simulationViewModel;
		
		image.opacityProperty().bind(viewModel.opacityProperty());
	}
	
	
	
	public void imageClick(ActionEvent event) {
		
		viewModel.getTimer().start();
		
	}



	public void setViewHandler(ViewHandler viewHandler) {
		viewModel.setViewHandler(viewHandler);
		
	}
	
}
