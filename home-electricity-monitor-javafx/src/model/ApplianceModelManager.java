package model;

public class ApplianceModelManager implements ApplianceModel{

	

	private double watt;
	private String name;
	private boolean on = true;

	public ApplianceModelManager() {
		watt = 0;
	}

	public void setBoolean(boolean on) {
		this.on = on;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setWatt(double watt) {
		this.watt = watt;
	}

	public double getWatt() {
		if (on == true) {
			return watt;
		}
		else {
			watt = 0;
			return watt;
		}
	}

	

	
	
	
}
