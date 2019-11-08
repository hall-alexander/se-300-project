package view.temp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import jfxtras.labs.util.event.MouseControlUtil;

public class tempController {

	@FXML
	BorderPane root;
	
	@FXML
	MenuButton applianceSelection;
	
	@FXML
	MenuItem airConditioner;
	@FXML
	MenuItem computer;
	@FXML
	MenuItem microwave;
	@FXML
	MenuItem oven;
	@FXML
	MenuItem television;
	@FXML
	MenuItem washingMachine;
	
	
	public tempController() {
		
	}
	
	public void addAppliance(String appliance) {
		FileInputStream input = null;
		try {
			input = new FileInputStream("images/" + appliance + ".png");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Image imagefile = new Image(input);
		ImageView image = new ImageView(imagefile);
		image.setFitHeight(100);
		image.setFitWidth(100);
		MouseControlUtil.makeDraggable(image);
		root.getChildren().add(image);
	}
	
	public void addAirConditioner(ActionEvent actionEvent) throws IOException {
		String appliance = "air-conditioner";
		addAppliance(appliance);
	}
	
	public void addComputer(ActionEvent actionEvent) throws IOException {
		String appliance = "computer";
		addAppliance(appliance);
	}
	
	public void addMicrowave(ActionEvent actionEvent) throws IOException {
		String appliance = "microwave";
		addAppliance(appliance);
	}
	
	public void addOven(ActionEvent actionEvent) throws IOException {
		String appliance = "oven";
		addAppliance(appliance);
	}
	
	public void addTelevision(ActionEvent actionEvent) throws IOException {
		String appliance = "television";
		addAppliance(appliance);
	}
	
	public void addWashingMachine(ActionEvent actionEvent) throws IOException {
		String appliance = "washing-machine";
		addAppliance(appliance);
	}
	
	
}

