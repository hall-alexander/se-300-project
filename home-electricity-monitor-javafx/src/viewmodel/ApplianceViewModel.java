package viewmodel;

import java.util.Date;

import javafx.beans.property.SimpleStringProperty;
import model.ApplianceModel;


public class ApplianceViewModel {
	
	private ApplianceModel model;
	
	private Date timeDuration;
	private double wattage;
	private double cost;
	private String name;
	private int id;
	
	
	public ApplianceViewModel(ApplianceModel model) {
		this.model = model;
	}
	
}
