package view.simulation;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import jfxtras.labs.util.event.MouseControlUtil;
import view.ViewHandler;
import viewmodel.SimulationViewModel;

public class SimulationController {

	@FXML
	ImageView image;
	@FXML
	ImageView imageb;
	@FXML
	Button simulation;
	@FXML
	Label timeLabel;
	
	long timestamp;
	long time=0;
	long fraction=0;
	
	public ObservableList<ImageView> images = FXCollections.observableArrayList();
	
	
	double val = 0;
	
	private SimulationViewModel viewModel;
	
	
	public void init(SimulationViewModel simulationViewModel) {
		this.viewModel = simulationViewModel;
		
		//image.opacityProperty().bind(viewModel.opacityProperty());
		//image.effectProperty().bind(viewModel.effectProperty());
		
	}
	
	
	
	public void imageClick(MouseEvent event) {
		Timer timer = new Timer();
		
		TimerTask on = new TimerTask() {
			int iterations = 10;
			public void run() {
				
				//DateFormat timeFormat = new SimpleDateFormat( "HH:mm:ss" );
				
				if (iterations > 0) {
					if(val == 1) {
						image.setOpacity(1);
						val = 0;
					}
					else {
						image.setOpacity(0);
						val = 1;
					}
					iterations--;
				}
				else {
					timer.cancel();
				}
				
			}
		};
		
		timer.scheduleAtFixedRate(on, 0000l, 1000l);
		
	}

	
	public void simulationRun(ActionEvent event) {
		Timer timer = new Timer();
		
		images.add(image);
		images.add(imageb);
		
		MouseControlUtil.makeDraggable(image);
		MouseControlUtil.makeDraggable(imageb);
		
		TimerTask gatherEvents = new TimerTask() {
			int iterations = 10;
			public void run() {
				
				//DateFormat timeFormat = new SimpleDateFormat( "HH:mm:ss" );
				
				if (iterations > 0) {
					if(val == 1) {
						for(int i=0; i<images.size(); i++) {
							images.get(i).setOpacity(1);
							val = 0;
						}
						
					}
					else {
						for(int i=0; i<images.size(); i++) {
							images.get(i).setOpacity(0);
							val = 1;
						}
						
					}
					iterations--;
				}
				else {
					timer.cancel();
				}
				
			}
		};
		
		timer.scheduleAtFixedRate(gatherEvents, 0000l, 1000l);
		
	}
	


	public void setViewHandler(ViewHandler viewHandler) {
		viewModel.setViewHandler(viewHandler);
		
	}
	
}
