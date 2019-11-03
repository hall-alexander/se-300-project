package view;

import view.HomePage.HomePageController;
import view.Mapper.MapperController;
import viewmodel.ViewModelFactory;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
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
		
		//issues https://intellij-support.jetbrains.com/hc/en-us/community/posts/115000640524-fx-controller-classNotFoundException-plugin-development
		
		loader.setClassLoader(getClass().getClassLoader());
		loader.setLocation(getClass().getResource(viewToOpen.toLowerCase()+"/"+ viewToOpen + ".fxml")); //should be HomePage/HomePage.fxml

		root = loader.load();
		if("HomePage".equals(viewToOpen)) {
			HomePageController view = loader.getController();
			view.init(mvViewModel.getHomePageViewModel()); //make homepage viewmodel
			stage.setTitle("HomePage");
		}
		
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
}
