package view.temp;

import java.io.FileInputStream;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import jfxtras.labs.util.event.MouseControlUtil;
import jfxtras.labs.scene.layout.ScalableContentPane;

public class tempController {

	@FXML
	ScalableContentPane root;
	
	@FXML
	Button icon;
	
	
	public tempController() {
		
	}
	
	public void onIconClick(ActionEvent actionEvent) throws IOException {
		FileInputStream input = new FileInputStream("images/oven.png");
		Image imagefile = new Image(input);
		ImageView image = new ImageView(imagefile);
		MouseControlUtil.makeDraggable(image);
		root.getChildren().add(image);
	}
	
	
}

