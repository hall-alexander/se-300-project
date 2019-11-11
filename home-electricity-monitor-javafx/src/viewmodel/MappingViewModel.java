package viewmodel;

import java.util.ArrayList;
import java.util.Date;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.shape.Line;
import model.ApplianceModel;
import view.ViewHandler;


public class MappingViewModel {
	
	private ApplianceModel model;
	
	public ArrayList<Line> lines = new ArrayList<Line>();
	
	private ViewHandler viewHandler;
	
	
	public MappingViewModel(ApplianceModel model) {
		this.model = model;
	}


	public ViewHandler getViewHandler() {
		return viewHandler;
	}


	public void setViewHandler(ViewHandler viewHandler) {
		this.viewHandler = viewHandler;
	}
	
}
