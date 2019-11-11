package view.mapper;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import jfxtras.labs.util.event.MouseControlUtil;
import viewmodel.MappingViewModel;

public class MapperController{
	
	@FXML
	Button verticalLineButton;
	@FXML
	Button horizontalLineButton;
	@FXML
	Pane mapperPane;
	
	private MappingViewModel viewModel;
	
	
	public void init(MappingViewModel mappingViewModel) {
		this.viewModel = mappingViewModel;
		
		//test.textProperty().bindBidirectional(viewModel.buttonTextProperty());
	}
	
	
	
	public void verticalButtonClicked(ActionEvent e) {
		Line line = new Line(100,100,100,200);
		line.setStrokeWidth(8);
		viewModel.lines.add(line);
		//System.out.println(lines);
		mapperPane.getChildren().add(line);
		MouseControlUtil.makeDraggable(line);
	}
	
	public void horizontalButtonClicked(ActionEvent e) {
		Line line = new Line(100,100,200,100);
		line.setStrokeWidth(8);
		viewModel.lines.add(line);
		//System.out.println(lines);
		mapperPane.getChildren().add(line);
		MouseControlUtil.makeDraggable(line);
	}
}





//ArrayList<Point> points = new ArrayList<Point>();
//Canvas canvas = new Canvas(500, 550);
//GraphicsContext gc = canvas.getGraphicsContext2D();
/*
Rectangle r = new Rectangle();
r.setX(45);
r.setY(45);
r.setWidth(400);
r.setHeight(400);
r.setFill(Color.WHITE);
r.setStroke(Color.BLACK);
r.setStrokeWidth(10);
*/
//root.getChildren().add(button3);

//utilize javafx.node line and set a standard rectangle as the house walls, swap over to working on the interior room designs

		/*
		canvas.setOnMouseClicked((event) -> {
			System.out.printf("x: %.2f, y: %.2f\n", event.getX(),event.getY());
			double pointX =  event.getX();
			double pointY =  event.getY();
			Line line = new Line(pointX,pointY,0,0);
			line.setFill(Color.BLACK);
			if(event.getButton()== MouseButton.SECONDARY) {
				System.out.println("right clicked");
				double point2X = event.getX();
				double point2Y = event.getY();
				line.setEndX(point2X);
				line.setEndY(point2Y);
				lines.add(line);
			}
			System.out.println(line);
			//Point p = new Point(pointX,pointY,colorCode);
			root.getChildren().add(line);
*/
		/*
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
		*/