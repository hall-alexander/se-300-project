package view.simulation;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
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
	
	
	double val = 0;
	
	private SimulationViewModel viewModel;
	
	
	public void init(SimulationViewModel simulationViewModel) {
		this.viewModel = simulationViewModel;
		
		//image.opacityProperty().bind(viewModel.opacityProperty());
		//image.effectProperty().bind(viewModel.effectProperty());
		
	}
	
	
	
	public void imageClick(MouseEvent event) {
		

		Timer timer = new Timer();
		timestamp= System.currentTimeMillis() - fraction;
		
		TimerTask on = new TimerTask() {
			int iterations = 10;
			public void run() {
				
				//DateFormat timeFormat = new SimpleDateFormat( "HH:mm:ss" );
				
				
				timer.
				
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



	public void setViewHandler(ViewHandler viewHandler) {
		viewModel.setViewHandler(viewHandler);
		
	}
	
}
