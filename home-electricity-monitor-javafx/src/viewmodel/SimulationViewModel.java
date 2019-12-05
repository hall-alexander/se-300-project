package viewmodel;

import javafx.animation.AnimationTimer;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Glow;
import model.ApplianceModel;
import view.ViewHandler;

public class SimulationViewModel {

	private DoubleProperty opacity;
	private ObjectProperty<Glow> effect;
	private ViewHandler viewHandler;
	private AnimationTimer timer;
	private Timeline timeline;
	
	private ApplianceModel model;
	
	public SimulationViewModel(ApplianceModel model) {
		this.model = model;
		
	}
	
	
	
	private class MyTimer extends AnimationTimer {
		
		@Override
		public void handle(long now) {
			doHandle();
		}
		
		public void doHandle() {
			
			setOpacity(getOpacity() - 0.01);
			
			
			
			

			if (getOpacity() <= 0) {
				stop();
				System.out.println("Animation stopped");
			}
		}
		
	}
	
	
	public void simulationRun() {
		//getTimeline().setAutoReverse(false);
		//getTimeline().getKeyFrames().add
	}
	
	
	public final Double getOpacity() {
		return this.opacity.get();
	}
	
	public final void setOpacity(Double value) {
		this.opacity.set(value);
	}
	
	public DoubleProperty opacityProperty() {
		if (opacity == null) {
			this.opacity = new SimpleDoubleProperty(1);
		}
		return this.opacity;
	}
	

	public ViewHandler getViewHandler() {
		return viewHandler;
	}

	public void setViewHandler(ViewHandler viewHandler) {
		this.viewHandler = viewHandler;
	}
	
}
