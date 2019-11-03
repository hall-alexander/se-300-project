package view.HomePage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import viewmodel.HomePageViewModel;

public class HomePageController {

	@FXML
	Button homeLayout;
	Button newHomeLayout;
	Button appliances;
	Button test;
	
	
	private HomePageViewModel viewModel;
	
	
	public HomePageController() {
	
	}
	
	//init method is mainly used to bind properties between
	//view (HomePageController) and the viewmodel (HomePageViewModel)
	public void init(HomePageViewModel homePageViewModel) {
		this.viewModel = homePageViewModel;
		this.test = new Button("Trial");
		test.textProperty().bind(viewModel.buttonTextProperty());
	}
	
	
	//This is what a lot of button methods will look like. Whenever user
	//clicks button in view. The viewModel will handle that event with
	//some sort of functionality. In this case, when the test button was
	//clicked, the viewModel will call the changeText() method.
	public void onTestClick(ActionEvent actionEvent) {
		viewModel.changeText();
	}
	
	
}
