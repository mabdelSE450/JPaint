package view;

import java.util.ArrayList;

import model.persistence.ApplicationState;

public class SelectShape {
	
	SelectedShapeList selectedShapeList = new SelectedShapeList();
	
	BoundingBoxShape boundingShape;
	
	
	public void run(SelectedShapeList selectedShapeList,PointClass start, PointClass end) {
		selectedShapeList.clearList();
		
		if(start.x > end.x && start.y > end.y ) {
			int tempX;
			int tempY;
			tempX = start.x;
			start.x = end.x;
			end.x = tempX;
			tempY = start.y;
			start.y = end.y;
			end.y = tempY;
			
		}
		else if(start.x < end.x && start.y >= end.y) {
			int temp;
			temp = end.y;
			end.y = start.y;
			start.y = temp;
			
			
		}
		else if(start.x >= end.x && start.y < end.y) {
			int temp;
			temp = start.x;
			start.x = end.x;
			end.x = temp;
			
			
		}
		boundingShape = new BoundingBoxShape(start, end) ;

	}
	public boolean checkCollision(JShape shape) {
		
		if(boundingShape.getStartPoint().x < shape.getEndPoint().x && 
		boundingShape.getEndPoint().x  > shape.getStartPoint().x &&
		boundingShape.getStartPoint().y < shape.getEndPoint().y &&
		boundingShape.getEndPoint().y > shape.getStartPoint().y)
		

		{return true;}
		else {
			return false;
		}
		
}
	
}
