package model;

public class ModelFactory {

	private ApplianceModel applianceModel;
	
	//ApplianceModel is the interface
	
	public ApplianceModel getApplicanceModel() {
		if(applianceModel == null) {
			applianceModel = new ApplianceModelManager(); //ApplianceModelManager is the implementation
		}
		
		return applianceModel;
	}
	
	
}
