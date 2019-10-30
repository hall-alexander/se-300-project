package viewmodel;

import model.ModelFactory;

public class ViewModelFactory {

	private ApplianceViewModel applianceViewModel;
	
	public ViewModelFactory(ModelFactory mf) {
		applianceViewModel = new ApplianceViewModel(mf.getApplicanceModel());
	}

	public ApplianceViewModel getApplianceViewModel() {
		return applianceViewModel;
	}

	public void setApplianceViewModel(ApplianceViewModel applianceViewModel) {
		this.applianceViewModel = applianceViewModel;
	}
	
	
	
	
}
