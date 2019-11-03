package viewmodel;

import model.ModelFactory;

public class ViewModelFactory {

	private ApplianceViewModel applianceViewModel;
	private HomePageViewModel homePageViewModel;
	
	public ViewModelFactory(ModelFactory mf) {
		homePageViewModel = new HomePageViewModel(mf.getApplicanceModel());
		applianceViewModel = new ApplianceViewModel(mf.getApplicanceModel());
	}

	public HomePageViewModel getHomePageViewModel() {
		return homePageViewModel;
	}
	
	public void setHomePageViewModel(HomePageViewModel homePageViewModel) {
		this.homePageViewModel = homePageViewModel;
	}
	
	public ApplianceViewModel getApplianceViewModel() {
		return applianceViewModel;
	}

	public void setApplianceViewModel(ApplianceViewModel applianceViewModel) {
		this.applianceViewModel = applianceViewModel;
	}
	
	
	
	
}
