package viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.ApplianceModel;

public class HomePageViewModel {

	private int id;
	private StringProperty buttonText;
	
	private ApplianceModel model;
	
	public HomePageViewModel(ApplianceModel model) {
		this.model = model;
		
		//since the string properties are bound, this will reflect in the GUI
		buttonText = new SimpleStringProperty("GERMAN SCIENCE IS THE BEST IN THE WORLD"); 
	}
	
	public final String getText() {
		return this.buttonText.get();
	}
	
	public final void setText(String text) {
		this.buttonText.set(text);
	}
	
	public StringProperty buttonTextProperty() {
		if (buttonText == null) {
			this.buttonText = new SimpleStringProperty("Default");
		}
		return this.buttonText;
	}

	
	public void changeText() {
		this.setText("change");
	}
	
}
