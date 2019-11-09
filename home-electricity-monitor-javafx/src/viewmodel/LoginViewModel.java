package viewmodel;

import java.sql.Date;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.ApplianceModel;
import view.ViewHandler;

public class LoginViewModel {

	private StringProperty applianceName = new SimpleStringProperty("Default");
	private ObjectProperty<Date> startDate = new SimpleObjectProperty<>(this, "startDate");
	private DoubleProperty startHour = new SimpleDoubleProperty(0);
	private DoubleProperty startMinute = new SimpleDoubleProperty(0);
	private DoubleProperty startSecond = new SimpleDoubleProperty(0);
	private ObjectProperty<Date> endDate = new SimpleObjectProperty<>(this, "endDate");
	private DoubleProperty endHour = new SimpleDoubleProperty(0);
	private DoubleProperty endMinute = new SimpleDoubleProperty(0);
	private DoubleProperty endSecond = new SimpleDoubleProperty(0);
	private DoubleProperty priority = new SimpleDoubleProperty(0);
	
	private ViewHandler viewHandler;
	private ApplianceModel model;
	
	public LoginViewModel(ApplianceModel model) {
		this.model = model;
		
	}
	
	public void changeText() {
		this.setText("change");
	}
	
	
	
	public StringProperty applianceNameProperty() {return this.applianceName;}
	public final String getText() {return this.applianceName.get();}
	public final void setText(String text) {this.applianceName.set(text);}
	
	public ObjectProperty<Date> startDateProperty() {return this.startDate;}
	public final Date getStartDate() {return this.startDate.get();}
	public final void setStartDate(Date date) {this.startDate.set(date);}
	
	public DoubleProperty startHourProperty() {return this.startHour;}
	public final Double getStartHour() {return this.startHour.get();}
	public final void setStartHour(Double value) {this.startHour.set(value);}
	
	public DoubleProperty startMinuteProperty() {return this.startMinute;}
	public final Double getStartMinute() {return this.startMinute.get();}
	public final void setStartMinute(Double value) {this.startMinute.set(value);}
	
	public DoubleProperty startSecondProperty() {return this.startSecond;}
	public final Double getStartSecond() {return this.startSecond.get();}
	public final void setStartSecond(Double value) {this.startSecond.set(value);}
	
	public ObjectProperty<Date> endDateProperty() {return this.endDate;}
	public final Date getEndDate() {return this.endDate.get();}
	public final void setEndDate(Date date) {this.endDate.set(date);}
	
	public DoubleProperty endHourProperty() {return this.endHour;}
	public final Double getEndHour() {return this.endHour.get();}
	public final void setEndHour(Double value) {this.endHour.set(value);}
	
	public DoubleProperty endMinuteProperty() {return this.endMinute;}
	public final Double getEndMinute() {return this.endMinute.get();}
	public final void setEndMinute(Double value) {this.endMinute.set(value);}
	
	public DoubleProperty endSecondProperty() {return this.endSecond;}
	public final Double getEndSecond() {return this.endSecond.get();}
	public final void setEndSecond(Double value) {this.endSecond.set(value);}
	
	public DoubleProperty priorityProperty() {return this.priority;}
	public final Double getPriority() {return this.priority.get();}
	public final void setPriority(Double value) {this.priority.set(value);}

	public ViewHandler getViewHandler() {
		return viewHandler;
	}

	public void setViewHandler(ViewHandler viewHandler) {
		this.viewHandler = viewHandler;
	}
	
}
