package viewmodel;

import javafx.animation.AnimationTimer;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import model.ApplianceModel;
import view.ViewHandler;

public class SimulationViewModel {

	private DoubleProperty opacity;
	private ViewHandler viewHandler;
	private AnimationTimer timer;
	
	private ApplianceModel model;
	
	public SimulationViewModel(ApplianceModel model) {
		this.model = model;
		
		this.setTimer(new MyTimer());
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

	public AnimationTimer getTimer() {
		return timer;
	}

	public void setTimer(AnimationTimer timer) {
		this.timer = timer;
	}

	public ViewHandler getViewHandler() {
		return viewHandler;
	}

	public void setViewHandler(ViewHandler viewHandler) {
		this.viewHandler = viewHandler;
	}
	
}
