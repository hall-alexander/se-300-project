package model;

public class ModelFactory {

	private ApplianceModel applianceModel;
	
	public ApplianceModel getApplicanceModel() {
		if(applianceModel == null) {
			applianceModel = new ApplianceModel();
		}
	}
	
}
