package viewmodel;

import model.ApplianceModel;
import view.ViewHandler;

public class HomePageViewModel {

	private ViewHandler viewHandler;
	
	private ApplianceModel model;
	
	public HomePageViewModel(ApplianceModel model) {
		this.model = model;
		
	}
	
	public ViewHandler getViewHandler() {
		return viewHandler;
	}

	public void setViewHandler(ViewHandler viewHandler) {
		this.viewHandler = viewHandler;
	}
	
}
