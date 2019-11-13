package view.mapper;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import jfxtras.labs.util.event.MouseControlUtil;
import view.ViewHandler;
import viewmodel.MappingViewModel;

public class MapperController {
	
	@FXML
	Button verticalLineButton;
	@FXML
	Button horizontalLineButton;
	@FXML
	Pane mapperPane;
	
	private MappingViewModel viewModel;
	
	
	public void init(MappingViewModel mappingViewModel) {
		this.viewModel = mappingViewModel;
		
		//test.textProperty().bindBidirectional(viewModel.buttonTextProperty());
	}
	
	
	
	public void verticalButtonClicked(ActionEvent e) {
		Line line = new Line(100,100,100,200);
		line.setStrokeWidth(8);
		viewModel.lines.add(line);
		//System.out.println(lines);
		mapperPane.getChildren().add(line);
		MouseControlUtil.makeDraggable(line);
	}
	
	public void horizontalButtonClicked(ActionEvent e) {
		Line line = new Line(100,100,200,100);
		line.setStrokeWidth(8);
		viewModel.lines.add(line);
		//System.out.println(lines);
		mapperPane.getChildren().add(line);
		MouseControlUtil.makeDraggable(line);
	}



	public void setViewHandler(ViewHandler viewHandler) {
		viewModel.setViewHandler(viewHandler);
		
	}
}
