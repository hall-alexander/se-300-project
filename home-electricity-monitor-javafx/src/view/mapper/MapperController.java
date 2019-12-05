package view.mapper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import jfxtras.labs.util.event.MouseControlUtil;
import view.ViewHandler;
import viewmodel.MappingViewModel;
import viewmodel.SchedulerViewModel.ApplianceSchedule;

public class MapperController {
	
	@FXML
	Button verticalLineButton;
	@FXML
	Button horizontalLineButton;
	@FXML
	Button printObjectsButton;
	@FXML
	Button loadAppliances;
	
	@FXML
	Pane mapperPane;
	
	@FXML
	BorderPane root;
	
	@FXML
	MenuButton applianceSelection;
	
	@FXML
	MenuItem airConditioner;
	@FXML
	MenuItem computer;
	@FXML
	MenuItem microwave;
	@FXML
	MenuItem oven;
	@FXML
	MenuItem television;
	@FXML
	MenuItem washingMachine;
	
	
	
	private MappingViewModel viewModel;
	
	
	public void init(MappingViewModel mappingViewModel) {
		this.viewModel = mappingViewModel;
		
	}
	
	public void loadAppliancesButtonClicked(ActionEvent e) {
		for(int i=0; i<viewModel.images.size(); i++) {
			mapperPane.getChildren().add(viewModel.images.get(i));
		}
		
		for(int i=0; i<viewModel.lines.size(); i++) {
			mapperPane.getChildren().add(viewModel.lines.get(i));
			
			
		}
	}
	
	public void verticalButtonClicked(ActionEvent e) {
		Line line = new Line(100,100,100,200);
		line.setStrokeWidth(8);
		viewModel.lines.add(line);
		mapperPane.getChildren().add(line);
		MouseControlUtil.makeDraggable(line);
		
		line.addEventHandler(ScrollEvent.SCROLL, new EventHandler<ScrollEvent>() {

			@Override
			public void handle(ScrollEvent event) {
				if (event.isControlDown()) {
					line.setEndY(line.getEndY() + event.getDeltaY());
				}
				
			}
		});
		
	}
	
	public void horizontalButtonClicked(ActionEvent e) {
		Line line = new Line(100,100,200,100);
		line.setStrokeWidth(8);
		viewModel.lines.add(line);
		mapperPane.getChildren().add(line);
		MouseControlUtil.makeDraggable(line);
		
		line.addEventHandler(ScrollEvent.SCROLL, new EventHandler<ScrollEvent>() {

			@Override
			public void handle(ScrollEvent event) {
				if (event.isControlDown()) {
					line.setEndX(line.getEndX() + event.getDeltaY());
				}
				
			}
		});
		
	}

	
	public void printObjectButtonClicked(ActionEvent e) {
		
		
		Timer timer = new Timer();

		TimerTask gatherEvents = new TimerTask() {
			int iterations = 30;
			int minute = 0;
			int hour = 0;
			
			public void run() {

				if (iterations > 0) {
					
					System.out.println("Current time is: " + hour + ":" + minute);
					
					for(int i=0; i<viewModel.applianceSchedules.size(); i++) {

						if ((viewModel.applianceSchedules.get(i).getStartH() <= hour) && 
								(viewModel.applianceSchedules.get(i).getStartM() < minute) &&
								(viewModel.applianceSchedules.get(i).getStopH() >= hour) &&
								(viewModel.applianceSchedules.get(i).getStopM() > minute)) {

							
							System.out.println("The appliance is on.");
							viewModel.images.get(i).setOpacity(1);

						}

						else {
							System.out.println("The appliance is off");
							
							//viewModel.images.get(1).setOpacity(0);
							viewModel.images.get(i).setOpacity(0);

						}

					}
					
					if (minute == 55) {
						minute = 0;
						hour++;
						iterations--;
					}
					
					else {
						minute += 5;
						iterations--;
					}

				}
				else {
					timer.cancel();
				}

			}
		};

		timer.scheduleAtFixedRate(gatherEvents, 0000l, 1000l);

		
		
		
		
	}
	
	public void addAppliance(String appliance) {
		FileInputStream input = null;
		try {
			input = new FileInputStream("images/" + appliance + ".png");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Image imagefile = new Image(input);
		ImageView image = new ImageView(imagefile);
		image.setFitHeight(100);
		image.setFitWidth(100);
		MouseControlUtil.makeDraggable(image);
		
		//viewModel.createAppliance(appliance);
		
		Stage window = (Stage) root.getScene().getWindow();
		
		image.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
		     @Override
		     public void handle(MouseEvent event) {
		    	 if (event.isControlDown()) {
		    		 
		    		 //This is where we would allow users to set appliance information
		    		 try {
						viewModel.getViewHandler().openNewWindow("Scheduler", window, viewModel.createAppliance(appliance));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    		 
		    		 System.out.println("Appliance pressed ");
		    	 }
		         event.consume();
		     }
		});
		
		image.addEventHandler(ScrollEvent.SCROLL, new EventHandler<ScrollEvent>() {

			@Override
			public void handle(ScrollEvent event) {
				if (event.isControlDown()) {
					image.setFitHeight(image.getFitHeight() + event.getDeltaY());
					image.setFitWidth(image.getFitWidth() + event.getDeltaY());
				}
				
			}
		});
		
		root.getChildren().add(image);
		
		viewModel.images.add(image);
	}
	
	public void addApplianceSchedule(ApplianceSchedule applianceSchedule) {
		viewModel.applianceSchedules.add(applianceSchedule);
	}
	
	public void addAirConditioner(ActionEvent actionEvent) throws IOException {
		String appliance = "air-conditioner";
		
		addAppliance(appliance);
	}
	
	public void addComputer(ActionEvent actionEvent) throws IOException {
		String appliance = "computer";
		
		addAppliance(appliance);
	}
	
	public void addMicrowave(ActionEvent actionEvent) throws IOException {
		String appliance = "microwave";
		
		addAppliance(appliance);
	}
	
	public void addOven(ActionEvent actionEvent) throws IOException {
		String appliance = "oven";
		
		addAppliance(appliance);
	}
	
	public void addTelevision(ActionEvent actionEvent) throws IOException {
		String appliance = "television";
		
		addAppliance(appliance);
	}
	
	public void addWashingMachine(ActionEvent actionEvent) throws IOException {
		String appliance = "washing-machine";
		
		addAppliance(appliance);
	}

	public void setViewHandler(ViewHandler viewHandler) {
		viewModel.setViewHandler(viewHandler);
		
	}
}
