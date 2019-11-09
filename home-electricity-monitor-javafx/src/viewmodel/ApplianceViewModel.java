package viewmodel;

import java.util.Date;

import javafx.beans.property.SimpleStringProperty;
import model.ApplianceModel;
import view.ViewHandler;


public class ApplianceViewModel {
	
	private ApplianceModel model;
	
	private Date timeDuration;
	private double wattage;
	private double cost;
	private String name;
	private int id;
	
	private ViewHandler viewHandler;
	
	
	public ApplianceViewModel(ApplianceModel model) {
		this.model = model;
	}


	public ViewHandler getViewHandler() {
		return viewHandler;
	}


	public void setViewHandler(ViewHandler viewHandler) {
		this.viewHandler = viewHandler;
	}
	
}
