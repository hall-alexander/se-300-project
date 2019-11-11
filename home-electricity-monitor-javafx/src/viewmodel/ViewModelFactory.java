package viewmodel;

import model.ModelFactory;

public class ViewModelFactory {

	private ApplianceViewModel applianceViewModel;
	private HomePageViewModel homePageViewModel;
	private LoginViewModel loginViewModel;
	private MappingViewModel mappingViewModel;
	
	public ViewModelFactory(ModelFactory mf) {
		homePageViewModel = new HomePageViewModel(mf.getApplicanceModel());
		applianceViewModel = new ApplianceViewModel(mf.getApplicanceModel());

		setLoginViewModel(new LoginViewModel(mf.getApplicanceModel()));
		mappingViewModel = new MappingViewModel(mf.getApplicanceModel());
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

	public LoginViewModel getLoginViewModel() {
		return loginViewModel;
	}

	public void setLoginViewModel(LoginViewModel loginViewModel) {
		this.loginViewModel = loginViewModel;
	}

	public MappingViewModel getMappingViewModel() {
		return mappingViewModel;
	}

	public void setMappingViewModel(MappingViewModel mappingViewModel) {
		this.mappingViewModel = mappingViewModel;
	}
	
}
