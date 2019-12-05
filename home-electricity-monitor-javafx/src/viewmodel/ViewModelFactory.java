package viewmodel;

import model.ModelFactory;

public class ViewModelFactory {

	private HomePageViewModel homePageViewModel;
	private SchedulerViewModel schedulerViewModel;
	private MappingViewModel mappingViewModel;

	
	public ViewModelFactory(ModelFactory mf) {
		homePageViewModel = new HomePageViewModel(mf.getApplicanceModel());
		schedulerViewModel = new SchedulerViewModel(mf.getApplicanceModel());
		mappingViewModel = new MappingViewModel(mf.getApplicanceModel());
	}

	public HomePageViewModel getHomePageViewModel() {
		return homePageViewModel;
	}
	
	public void setHomePageViewModel(HomePageViewModel homePageViewModel) {
		this.homePageViewModel = homePageViewModel;
	}
	
	public SchedulerViewModel getSchedulerViewModel() {
		return schedulerViewModel;
	}

	public void setSchedulerViewModel(SchedulerViewModel loginViewModel) {
		this.schedulerViewModel = loginViewModel;
	}

	public MappingViewModel getMappingViewModel() {
		return mappingViewModel;
	}

	public void setMappingViewModel(MappingViewModel mappingViewModel) {
		this.mappingViewModel = mappingViewModel;
	}
	
}
