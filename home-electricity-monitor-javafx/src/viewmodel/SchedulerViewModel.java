package viewmodel;

import java.io.IOException;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.stage.Stage;
import model.ApplianceModel;
import view.ViewHandler;
import viewmodel.MappingViewModel.Appliance;

public class SchedulerViewModel {

	private Appliance appliance;
	
	private StringProperty applianceLabel = new SimpleStringProperty("appliance");
	private StringProperty wattageLabel = new SimpleStringProperty("wattage");
	private IntegerProperty startHour = new SimpleIntegerProperty(0);
	private IntegerProperty startMinute = new SimpleIntegerProperty(0);
	private IntegerProperty endHour = new SimpleIntegerProperty(0);
	private IntegerProperty endMinute = new SimpleIntegerProperty(0);
	
	private ViewHandler viewHandler;
	private ApplianceModel model;
	
	public SchedulerViewModel(ApplianceModel model) {
		this.model = model;
		
	}
	
	public class ApplianceSchedule {
		private String applianceName;
		private double wattage;
		private int startH;
		private int startM;
		private int stopH;
		private int stopM;
		
		ApplianceSchedule(){};
		
		ApplianceSchedule(String applianceName, double wattage, int startH, int startM, int stopH, int stopM) {
			this.setApplianceName(applianceName);
			this.setWattage(wattage);
			this.setStartH(startH);
			this.setStartM(startM);
			this.setStopH(stopH);
			this.setStopM(stopM);
		}

		public String getApplianceName() {
			return applianceName;
		}

		public void setApplianceName(String applianceName) {
			this.applianceName = applianceName;
		}

		public double getWattage() {
			return wattage;
		}

		public void setWattage(double wattage) {
			this.wattage = wattage;
		}

		public int getStartH() {
			return startH;
		}

		public void setStartH(int startH) {
			this.startH = startH;
		}

		public int getStartM() {
			return startM;
		}

		public void setStartM(int startM) {
			this.startM = startM;
		}

		public int getStopH() {
			return stopH;
		}

		public void setStopH(int stopH) {
			this.stopH = stopH;
		}

		public int getStopM() {
			return stopM;
		}

		public void setStopM(int stopM) {
			this.stopM = stopM;
		}
	}
	
	public void submitFunctionality(Stage window) {
		System.out.println("Submit Button Clicked!");
	      
		ApplianceSchedule applianceSchedule = new ApplianceSchedule(getApplianceLabel(), Double.parseDouble(getWattageLabel()), 
				getStartHour(), getStartMinute(), getEndHour(), getEndMinute());
		
		System.out.println("Appliance name: " + getApplianceLabel());
		System.out.println("Wattage: " + getWattageLabel());
		
		try {
			getViewHandler().sendSchedule("Mapper", window, applianceSchedule);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		/*
		String applianceName;
		Integer appliancePriority;
		String startDate, stopDate;
		//String buffer;

		applianceName = applianceChoiceBox.getValue().toString();
		System.out.println("Appliance "+applianceName);
		appliancePriority = Integer.valueOf(priorityChoiceBox.getValue());
		System.out.println("Priority "+appliancePriority);


		// date format is ISO_LOCAL_DATE  or  2019-1-05
		startDate = startDatePicker.getValue().toString();
		System.out.println("Start Date "+startDate);

		// make time format ISO_LOCAL_TIME or HH:mm:ss
		LocalTime startTime = formatStartTime();
		System.out.println("Start Time "+startTime);


		// date format is ISO_LOCAL_DATE  or  2019-1-05
		stopDate = stopDatePicker.getValue().toString();
		System.out.println("Stop Date "+stopDate);

		// make time format ISO_LOCAL_TIME or HH:mm:ss
		LocalTime stopTime = formatStopTime();
		System.out.println("Start Time "+stopTime);

		// see if stop time comes after start time
		boolean isbefore = startTime.isBefore(stopTime);
		if (isbefore) {
			System.out.println("Start is before Stop");

			// SHOW CHART
			showChart(applianceName, startTime, stopTime, appliancePriority);

		}
		else {
			//TODO  error processing here because start must be before stop
			//That means checking the date and time
		}
		*/
	}

	/*
	public void showChart(String applianceName, LocalTime startTime, LocalTime stopTime, Integer appliancePriority) {
		   
		final int WINDOW_SIZE = 10;


		String fxmlPath2 = "application/ChartScene.fxml";
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(fxmlPath2));
			Parent root2 = loader.load();

			System.out.println("showChart - after Loader");


			ChartController chartController = loader.getController();
			chartController.printmsg("Hello from LoginController");

			// Line Chart stuff:
			XYChart.Series<String, Number> series = new XYChart.Series<>();
			series.setName(applianceName);
			chartController.voltageChart.getData().add(series);
			System.out.println("showChart - after XYChart");

			Stage subStage = new Stage();

			subStage.setScene(new Scene(root2));
			subStage.show();
		}catch (Exception e) {
			e.printStackTrace();
		}


		Executors.newSingleThreadScheduledExecutor();

		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1); 

		// Run scheduler until the stop time entered by the user is reached
		scheduler.scheduleAtFixedRate(() -> {


			Integer randomVolts = ThreadLocalRandom.current().nextInt(10);
			System.out.println("Random Volts:  " + randomVolts);


			startTime.plusSeconds(1);
			System.out.println("Time + 1:  "+startTime);

			Platform.runLater(() -> {
				if(startTime.compareTo(stopTime) < 0) {
				}
				else {
					scheduler.shutdown();
				}
			});

		},  0,  1, TimeUnit.SECONDS);


	}
	*/

	/*
	public LocalTime formatStartTime() {
	       String hours, minutes, seconds;
	       String buffer;

	       // we retrieve start time pieces as strings, then create our HH:mm:ss format
	       hours = startHourSpinner.getValue().toString();
	       System.out.println("Hours "+hours);

	       minutes = startMinuteSpinner.getValue().toString();
	       System.out.println("Minutes "+minutes);
	       
	       seconds = startSecondSpinner.getValue().toString();
	       System.out.println("Seconds "+seconds);
	       
	       // time format needs to be HH:mm:ss  so if we get a one digit input, put a "0" in front of it
	       if (hours.length()==1) {
	    	  String saveHours = hours;
	    	  hours = "0"+saveHours;
	       }
	       if (minutes.length()==1) {
	    	  String saveMinutes = minutes;
	    	  minutes = "0"+saveMinutes;
	       }
	       if (seconds.length()==1) {
	    	  String saveSeconds = seconds;
	    	  seconds = "0"+saveSeconds;
	       }
	       
	       buffer = hours+":"+minutes+":"+seconds;
	       System.out.println("Time "+buffer);
	       
	       LocalTime startTime = LocalTime.parse(buffer);
	       System.out.println("Start Time "+startTime);
		   
		   return startTime;
	   }*/
	
	
	//Getters and setters
	
	public StringProperty applianceLabelProperty() {return this.applianceLabel;}
	public final String getApplianceLabel() {return this.applianceLabel.get();}
	public final void setApplianceLabel(String value) {this.applianceLabel.set(value);}
	
	public StringProperty wattageLabelProperty() {return this.wattageLabel;}
	public final String getWattageLabel() {return this.wattageLabel.get();}
	public final void setWattageLabel(String value) {this.wattageLabel.set(value);}
	
	public IntegerProperty startHourProperty() {return this.startHour;}
	public final Integer getStartHour() {return this.startHour.get();}
	public final void setStartHour(Integer value) {this.startHour.set(value);}
	
	public IntegerProperty startMinuteProperty() {return this.startMinute;}
	public final Integer getStartMinute() {return this.startMinute.get();}
	public final void setStartMinute(Integer value) {this.startMinute.set(value);}
	
	
	public IntegerProperty endHourProperty() {return this.endHour;}
	public final Integer getEndHour() {return this.endHour.get();}
	public final void setEndHour(Integer value) {this.endHour.set(value);}
	
	public IntegerProperty endMinuteProperty() {return this.endMinute;}
	public final Integer getEndMinute() {return this.endMinute.get();}
	public final void setEndMinute(Integer value) {this.endMinute.set(value);}

	public Appliance getAppliance() {
		return appliance;
	}

	public void setAppliance(Appliance appliance) {
		this.appliance = appliance;
	}

	public ViewHandler getViewHandler() {
		return viewHandler;
	}

	public void setViewHandler(ViewHandler viewHandler) {
		this.viewHandler = viewHandler;
	}
	
}
