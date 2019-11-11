package view;

import view.HomePage.HomePageController;
import view.login.LoginController;
import view.mapper.MapperController;
import viewmodel.ViewModelFactory;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewHandler {
	
	private Stage stage;
	private ViewModelFactory mvViewModel;
	
	public ViewHandler(Stage stage, ViewModelFactory mvViewModel) {
		this.stage = stage;
		this.mvViewModel = mvViewModel;
	}
	
	public void start() throws Exception {
		openView("HomePage");
	}
	
	public void openView(String viewToOpen) throws IOException {
		Scene scene = null;
		FXMLLoader loader = new FXMLLoader();
		Parent root = null;
		
		loader.setClassLoader(getClass().getClassLoader());
		loader.setLocation(getClass().getResource(viewToOpen.toLowerCase()+"/"+ viewToOpen + ".fxml")); //should be HomePage/HomePage.fxml

		root = loader.load();
		if("HomePage".equals(viewToOpen)) {
			HomePageController view = loader.getController();
			view.init(mvViewModel.getHomePageViewModel()); //make homepage viewmodel
			view.setViewHandler(this); //galaxy brain right here
			stage.setTitle("HomePage");
		}
		
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void changeScene(String view, Stage window) throws IOException {
		Parent parent = null;
		FXMLLoader loader = new FXMLLoader();

		loader.setClassLoader(getClass().getClassLoader());
		loader.setLocation(getClass().getResource("/view/" + view.toLowerCase() + "/" + view + ".fxml"));
		
		parent = loader.load();
		
		if("HomePage".equals(view)) {
			HomePageController viewController = loader.getController();
			viewController.init(mvViewModel.getHomePageViewModel()); //make homepage viewmodel
			viewController.setViewHandler(this); //galaxy brain right here
		}
		
		else if("Login".equals(view)) {
			LoginController viewController = loader.getController();
			viewController.init(mvViewModel.getLoginViewModel()); 
			viewController.setViewHandler(this);
		}
		
		else if("Mapper".equals(view)) {
			MapperController viewController = loader.getController();
			viewController.init(mvViewModel.getMappingViewModel()); //make homepage viewmodel
			viewController.setViewHandler(this); //galaxy brain right here
		}
		
		Scene scene = new Scene(parent);
		window.setScene(scene);
		window.setTitle(view);
		window.show();
	}
	
}
