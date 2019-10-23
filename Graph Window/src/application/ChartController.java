package application;

import java.net.URL;
//import java.time.LocalTime;
import java.util.*;
 
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
//import javafx.scene.control.*;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
//import javafx.stage.Window;

public class ChartController implements Initializable {
	
	@FXML
	LineChart<String, Number> voltageChart;
	
	   // Initialize the scene controls
	   @Override
	   public void initialize(URL location, ResourceBundle resources) {
		   /*
		   XYChart.Series<String, Number> series = new XYChart.Series<>();
		   series.setName("applianceName");
		   voltageChart.getData().add(series);
		   */
	   }
	   
	   // use this to test Controller to Controller communication
	   public void printmsg(String msg) {
		   System.out.println(msg);
	   }
}
