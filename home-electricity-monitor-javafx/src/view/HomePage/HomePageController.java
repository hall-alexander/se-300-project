package view.HomePage;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import view.ViewHandler;
import viewmodel.HomePageViewModel;

public class HomePageController {

	@FXML
	Button homeLayout;
	@FXML
	Button temp;
	@FXML
	Button appliances;
	@FXML
	Button login;
	
	
	private HomePageViewModel viewModel;
	
	public HomePageController() {
	
	}
	
	public void init(HomePageViewModel homePageViewModel) {
		this.viewModel = homePageViewModel;
		
	}
	
	
	public void setViewHandler(ViewHandler viewHandler) {
		viewModel.setViewHandler(viewHandler);
	}
	
	/*
	public void changeScene_old(ActionEvent actionEvent) throws IOException {
		Parent parent = null;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/temp/Temp.fxml"));
		
		parent = loader.load();
		Scene mapperView = new Scene(parent);
		
		Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
		window.setScene(mapperView);
		window.show();
	}*/
	
	public void changeScene(ActionEvent actionEvent) throws IOException {
		String view = null;
		Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
		
		view = ((Button)actionEvent.getSource()).getText();
		viewModel.getViewHandler().changeScene(view, window);
		
	}
	
	
}
