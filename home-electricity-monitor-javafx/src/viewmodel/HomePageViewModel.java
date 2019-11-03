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
		buttonText = new SimpleStringProperty("Testing...");
	}
	
	public String getText() {
		return buttonText.get();
	}
	
	public void setText(String text) {
		buttonText.set(text);
	}
	
	public StringProperty buttonTextProperty() {
		return buttonText;
	}

	
	public void changeText() {
		buttonText.set("German science is the best in the world");
	}
	
}
