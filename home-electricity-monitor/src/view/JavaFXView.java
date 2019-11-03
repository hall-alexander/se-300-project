package view;

import java.awt.event.KeyEvent;

import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;

class Point {
    private int x;
    private int y;
    private int colorCode;
    private boolean connect;
    public void setX(int x) {
        this.x = x;
    }
    public int getX() {
        return x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getY() {
        return y;
    }
    public int getColorCode(){
    	return colorCode;
    }
    public int setColorCode(int x){
    	colorCode=x;
    	return colorCode;
	}
    public Point() {
        x = 0;
        y = 0;
    }
    
    public Point(int x, int y, int colorCode) {
        setX(x);
        setY(y);
        setColorCode(colorCode);
        connect=true;
    }
    public boolean getConnected(){
    	return connect;
    }
    public boolean setConnected(int c){
    	if(c==1){
    		connect=true;
    		return connect;
    	}else{
    		connect=false;
    		return connect;
    	}
    }
    @Override
    public String toString() {
        return String.format("%d %d %d", x, y, colorCode);
    }
}

public class JavaFXView extends Application{
	Button button = new Button();
	Point prevPoint = null;
	private ArrayList<Point> points;

	public static void main(String[] args) {
		launch(args);
	}
	//controller class for fxml file (basically what i have now except changing a few things to make it compatable
	//scene builder
	public void start(Stage primaryStage){
		button.setText("Clear");
		ArrayList<Point> points = new ArrayList<Point>();
		int colorCode = 0;
		primaryStage.setTitle("ALPHA Mapping Demo");
		Group root = new Group();
		Canvas canvas = new Canvas(500, 550);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		button.setOnAction((event) ->{
			gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
	    	points.clear();
		});
		canvas.setOnMouseClicked((event) -> {
			System.out.printf("x: %.2f, y: %.2f\n", event.getX(),event.getY());
			int pointX = (int) event.getX();
			int pointY = (int) event.getY();
			Point p = new Point(pointX,pointY,colorCode);
		    points.add(p);
		    for (int i = 0; i < points.size(); i++) {
		    	Point p1 = points.get(i);
		    	gc.fillOval(p1.getX(), p1.getY(), 10, 10);
			   	prevPoint = p1;
			   	if (prevPoint != null){
			   		Point p2 = points.get(i+1);
			   		gc.strokeLine(prevPoint.getX()+5, prevPoint.getY()+5, p2.getX()+5, p2.getY()+5);
			   		prevPoint = p2;
			   		p2=points.get(i+1);
			   	}
			   	for (Point pp: points){
					Point firstPoint = points.get(0);
					if (pp.getX() > firstPoint.getX()-20 && 
							pp.getX() < firstPoint.getX()+20 && 
							pp.getY() > firstPoint.getY()-20 && 
							pp.getY() < firstPoint.getY()+20 ){
						pp.setX(firstPoint.getX());
						pp.setY(firstPoint.getY());
					}
					if (pp.getX() == firstPoint.getX() && pp.getY() == firstPoint.getY()){
						
					}
				}
			}
		});
		root.getChildren().add(canvas);
		root.getChildren().add(button);
		Scene scene = new Scene(root, 500, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
