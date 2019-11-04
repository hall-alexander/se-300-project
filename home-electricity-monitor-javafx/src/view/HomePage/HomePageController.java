package view.HomePage;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import viewmodel.HomePageViewModel;

public class HomePageController {

	@FXML
	Button homeLayout;
	@FXML
	Button newHomeLayout;
	@FXML
	Button appliances;
	@FXML
	Button test;
	
	
	private HomePageViewModel viewModel;
	
	
	public HomePageController() {
	
	}
	
	//init method is mainly used to bind properties between
	//view (HomePageController) and the viewmodel (HomePageViewModel)
	
	//NO object creation in init method, only bindings
	public void init(HomePageViewModel homePageViewModel) {
		this.viewModel = homePageViewModel;
		
		test.textProperty().bindBidirectional(viewModel.buttonTextProperty());
	}
	
	
	//This is what a lot of button methods will look like. Whenever user
	//clicks button in view. The viewModel will handle that event with
	//some sort of functionality. In this case, when the test button was
	//clicked, the viewModel will call the changeText() method.
	public void onTestClick(ActionEvent actionEvent) {
		viewModel.changeText();		
		test.setText(test.getText());
	}
	
	
	public void changeScene(ActionEvent actionEvent) throws IOException {
		Parent parent = null;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/temp/temp.fxml"));
		
		parent = loader.load();
		Scene mapperView = new Scene(parent);
		
		Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
		
		window.setScene(mapperView);
		window.show();
	}
	
	
}
