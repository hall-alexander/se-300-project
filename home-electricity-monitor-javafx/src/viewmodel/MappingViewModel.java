package viewmodel;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;
import model.ApplianceModel;
import view.ViewHandler;
import viewmodel.SchedulerViewModel.ApplianceSchedule;


public class MappingViewModel {
	
	
	public class Appliance {
		String name;
		double watt;
		
		Appliance(String name, double watt) {
			this.name = name;
			this.watt = watt;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public double getWatt() {
			return watt;
		}

		public void setWatt(double watt) {
			this.watt = watt;
		};
		
	}
	
	private ApplianceModel model;
	
	public ObservableList<Line> lines = FXCollections.observableArrayList();
	
	public ArrayList<ApplianceSchedule> applianceSchedules = new ArrayList<ApplianceSchedule>();
	
	public ObservableList<ImageView> images = FXCollections.observableArrayList();
	
	public ObservableList<Double> imagesLayout = FXCollections.observableArrayList();
	
	public ObservableList<Double> lineLayouts = FXCollections.observableArrayList();
	
	private ViewHandler viewHandler;
	
	
	public MappingViewModel(ApplianceModel model) {
		this.setModel(model);
	}

	
	public Appliance createAppliance(String name) {
		
		Appliance app = new Appliance("", 0.0);
		
		if (name.equals("air-conditioner") ) {
			app.setName("Air Conditioner");
			app.setWatt(3500.0);
		}
		else if (name.equals("ceiling-fan") ) {			
			app.setName("Ceiling Fan");
			app.setWatt(65.0);
		}
		else if (name.equals("computer") ) {
			app.setName("Desktop PC");
			app.setWatt(300.0);
		}
		else if (name.equals("blow-dryer") ) {
			app.setName("Blow Dryer");
			app.setWatt(2000.0);
		}
		else if (name.equals("router") ) {
			app.setName("Router");
			app.setWatt(7.0);
		}
		else if (name.equals("ledbulb-100-w") ) {
			app.setName("100W LED Bulb");
			app.setWatt(23.0);
		}
		else if (name.equals("ledbulb-60-w") ) {
			app.setName("60W LED Bulb");
			app.setWatt(23.0);
		}
		else if (name.equals("ledbulb-40-w") ) {	
			app.setName("40W LED Bulb");
			app.setWatt(13.0);
		}
		else if (name.equals("water-heater") ) {
			app.setName("Water Heater");
			app.setWatt(4500.0);
		}
		else if (name.equals("television") ) {
			app.setName("50 inch TV");
			app.setWatt(150.0);
		}
		else if (name.equals("television-small") ) {
			app.setName("30 inch TV");
			app.setWatt(60.0);
		}
		else if (name.equals("dishwasher") ) {
			app.setName("Dishwasher");
			app.setWatt(1400.0);
		}
		else if (name.equals("oven") ) {
			app.setName("Oven");
			app.setWatt(1200.0);
		}
		else if (name.equals("microwave") ) {
			app.setName("Microwave");
			app.setWatt(1000.0);
		}
		else if (name.equals("refrigerator") ) {
			app.setName("Refrigerator");
			app.setWatt(300.0);
		}
		else if (name.equals("coffee-maker") ) {
			app.setName("Coffee Maker");
			app.setWatt(1000.0);
		}
		else if (name.equals("pressure-cooker") ) {
			app.setName("Pressure Cooker");
			app.setWatt(700.0);
		}
		else if (name.equals("phone-charger") ) {
			app.setName("Phone Charger");
			app.setWatt(5.0);
		}
		else if (name.equals("washing-machine") ) {
			app.setName("Washing Machine");
			app.setWatt(600.0);
		}
		else if (name.equals("dryer") ) {
			app.setName("Dryer");
			app.setWatt(1500.0);
		}
		else if (name.equals("toaster") ) {
			app.setName("Toaster");
			app.setWatt(1000.0);
		}
		else if (name.equals("water-pump") ) {
			app.setName("Water Pump");
			app.setWatt(500.0);
		}
		else if (name.equals("dvd-player") ) {
			app.setName("DVD Player");
			app.setWatt(15.0);
		}
		else if (name.equals("amazon-echo") ) {
			app.setName("Amazon Echo");
			app.setWatt(3.0);
		}
		else if (name.equals("game-console") ) {
			app.setName("Game Console");
			app.setWatt(150.0);
		}
		
		
		return app;
	}
	

	public ApplianceModel getModel() {
		return model;
	}


	public void setModel(ApplianceModel model) {
		this.model = model;
	}


	public ViewHandler getViewHandler() {
		return viewHandler;
	}


	public void setViewHandler(ViewHandler viewHandler) {
		this.viewHandler = viewHandler;
	}
	
}
