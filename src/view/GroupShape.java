package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.util.ArrayList;

import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;

public class GroupShape implements IPointShape, IShape  {
	 PointClass startPoint;
	 PointClass endPoint;
	 ShapeColor primaryColor;
	 ShapeType shapeType;
	 ShapeShadingType sst;
	 ShapeColor secondaryColor;
	 CreateGroupShape createGroupShape;
	
	public ArrayList<IShape> groupShapeList = new ArrayList<IShape>();
	
	//ShapeList shapeList;
	//SelectedShapeList selectedShapeList;
	//GroupShapeTempList groupShapeTempList;
//	public GroupShape(PointClass startPoint, PointClass endPoint, ShapeColor primaryColor, 
//			ShapeType shapeType, ShapeShadingType sst, ShapeColor secondaryColor) {
//		this.primaryColor = primaryColor;
//		this.endPoint = endPoint;
//		this.startPoint = startPoint;
//		//this.appState = appState;
//		this.shapeType = shapeType;
//		this.sst = sst;
//		this.secondaryColor = secondaryColor;
//	}
//	
	// Pass in an arrayList to GroupShape constructor
	public GroupShape(SelectedShapeList selectedShapeList, CreateGroupShape createGroupShape) {
	//public GroupShape(GroupShapeTempList groupShapeTempList) {
		this.createGroupShape = createGroupShape;

		groupShapeList = selectedShapeList.selectedShapeList;
		//groupShapeList = groupShapeTempList.groupselectedShapeList;
		 IShape firstShape = groupShapeList.get(0);
	    	 int startX = firstShape.getStartPoint().x;
		 int endX = firstShape.getEndPoint().x;
		 int startY = firstShape.getStartPoint().y;
		 int endY = firstShape.getEndPoint().y;
		  
		 
		for(IShape shape: groupShapeList) {
//			System.out.println("SHape startX " + shape.getStartPoint().x);
//	    	System.out.println("SHape starty " + shape.getStartPoint().y);
//	    	System.out.println("SHape endX " + shape.getEndPoint().x);
//	    	System.out.println("SHape endY " + shape.getEndPoint().y);
//	    	System.out.println("SHape height " + shape.getHeight());
//	    	System.out.println("SHape width " + shape.getWidth());
//	    	System.out.println("New SHape Cord");
			
			 startPoint = shape.getStartPoint();
	         endPoint = shape.getEndPoint();
	        
			 startX = Math.min(startX, (Math.min(startPoint.x, endPoint.x)));
			 endX = Math.max(endX, (Math.max(startPoint.x, endPoint.x)));
			startY = Math.min(startY, (Math.min(startPoint.y, endPoint.y)));
			endY = Math.max(endY, (Math.max(startPoint.y, endPoint.y)));
		}
//		System.out.println("GroupSHape startX " + startX);
//    	System.out.println("GroupSHape starty " + startY);
//    	System.out.println("GroupSHape endX " + endX);
//    	System.out.println("GroupSHape endY " + endY);
    	//System.out.println("GroupSHape height " + firstShape.getHeight());
    	//System.out.println("GroupSHape width " + firstShape.getWidth());
		
		this.startPoint = new PointClass(startX, startY);
		this.endPoint = new PointClass(endX, endY);
	}
	

		
	@Override
	public PointClass getEndPoint() {
		return endPoint;
	}
	@Override
	public PointClass getStartPoint() {
		// TODO Auto-generated method stub
		return startPoint;
	}
	@Override
	public ShapeColor getPrimaryColor() {
		// TODO Auto-generated method stub
		return primaryColor;
	}
	@Override
	public ShapeType getShapeType() {
		// TODO Auto-generated method stub
		return shapeType;
	}
	@Override
	public ShapeShadingType getSST() {
		// TODO Auto-generated method stub
		return sst;
	}
	@Override
	public ShapeColor getSecondaryColor() {
		// TODO Auto-generated method stub
		return secondaryColor;
	}
	@Override
	public int getWidth() {
		return Math.abs(this.getEndPoint().x - this.getStartPoint().x);
	}
	@Override
	public int getHeight() {
		return Math.abs(this.getEndPoint().y - this.getStartPoint().y);
	}
	@Override
	public void draw(Graphics2D graphics2d) {
		for(IShape shape: groupShapeList) {
			switch(shape.getShapeType().toString()) {
			case "RECTANGLE":
				DrawRectangleStrategy rect = new DrawRectangleStrategy();
				rect.draw(shape, graphics2d);
				break;
			case "ELLIPSE":
				DrawEllipseStrategy ellp = new DrawEllipseStrategy();
				ellp.draw(shape, graphics2d);
				break;
			case "TRIANGLE":
				DrawTriangleStrategy triangle = new DrawTriangleStrategy();
				triangle.draw(shape, graphics2d);
				break;
			}
			//graphics2d.drawRect(this.getStartPoint().x, this.getStartPoint().y, getWidth(), getHeight());
		}
		if(createGroupShape.groupedOrNot) {
		PointClass startPoint = new PointClass(this.getStartPoint().x - 3, this.getStartPoint().y - 3);
    	PointClass endPoint = new PointClass(this.getEndPoint().x - 3, this.getEndPoint().y - 3);
    	int newHeight = this.getHeight() + 6;
    	int newWidth = this.getWidth() +6 ;
			
			Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
	        graphics2d.setStroke(stroke);
	        graphics2d.setColor(Color.BLACK);
	        if(startPoint.x > endPoint.x && startPoint.y > endPoint.y) {
	        	System.out.println("First check");
				graphics2d.drawRect(endPoint.x, endPoint.y, newWidth, newHeight);
				System.out.println("First check");
				}
			else if(startPoint.x> endPoint.x && startPoint.y < endPoint.y) {
				System.out.println("second check");
				graphics2d.drawRect(endPoint.x, startPoint.y, newWidth, newHeight);
				System.out.println("second check");
				}
			else if(startPoint.x < endPoint.x && startPoint.y > endPoint.y) {
				System.out.println("third check");
				graphics2d.drawRect(startPoint.x, endPoint.y, newWidth, newHeight);
				System.out.println("third check");
				}
			else if(startPoint.x < endPoint.x && startPoint.y < endPoint.y) {
				
				graphics2d.drawRect(startPoint.x, startPoint.y, newWidth, newHeight);
				
				
				}
	        
	        
		}
	}
		
		
		
	

	@Override
	public void move(int deltaX, int deltaY) {
		this.startPoint.x = this.startPoint.x + deltaX;
		this.endPoint.x = this.endPoint.x + deltaX;
		this.startPoint.y = this.startPoint.y + deltaY;
		this.endPoint.y = this.endPoint.y + deltaY;
		
	}
	@Override
	public void delete(ShapeList shapeList) {
		
		shapeList.removeShape(this);
		
	}
	@Override
	public IShape paste() {
		PointClass startPoint = new PointClass(this.startPoint.x + 20, this.startPoint.y + 20);
		PointClass endPoint = new PointClass(this.endPoint.x + 20, this.endPoint.y + 20);
		IShape newShape = new JShape(startPoint, endPoint, this.getPrimaryColor(), this.getShapeType(), 
            this.getSST(), this.getSecondaryColor());
		return newShape;
	}

	
}
