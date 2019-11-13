package viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import model.ApplianceSelectionModel;
import view.ViewHandler;

public class ApplianceSelectionViewModel {
	
	private DoubleProperty numBigTV = new SimpleDoubleProperty();
	private ViewHandler viewHandler;
	
	private ApplianceSelectionModel model;
	
	public ApplianceSelectionViewModel(ApplianceSelectionModel model) {
		this.model = model;
		
		numBigTV = new SimpleDoubleProperty(0);
	}

	public final double getNumBigTV() {
		return numBigTV.get();
	}
	
	public final void setnumBigTV(double value) {
		numBigTV.set(value);
	}
	
	public DoubleProperty numBigTVProperty() {
		return numBigTV;
	}
	
	public void changeValue() {
		this.setnumBigTV(1);
	}
	
	public ViewHandler getViewHandler() {
		return viewHandler;
	}
	
	public void setViewHandler(ViewHandler viewHandler) {
		this.viewHandler = viewHandler;
	}
	
}
