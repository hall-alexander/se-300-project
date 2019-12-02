package view.simulation;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import view.ViewHandler;
import viewmodel.SimulationViewModel;

public class SimulationController {

	@FXML
	ImageView image;
	
	
	private SimulationViewModel viewModel;
	
	
	public void init(SimulationViewModel simulationViewModel) {
		this.viewModel = simulationViewModel;
		
		image.opacityProperty().bind(viewModel.opacityProperty());
		image.effectProperty().bind(viewModel.effectProperty());
		
	}
	
	
	
	public void imageClick(MouseEvent event) {
		
		viewModel.getTimer().start();
		
	}



	public void setViewHandler(ViewHandler viewHandler) {
		viewModel.setViewHandler(viewHandler);
		
	}
	
}
