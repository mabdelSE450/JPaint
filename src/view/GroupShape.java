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
	SelectedShapeList selectedShapeList;
	
	public ArrayList<IShape> groupShapeList = new ArrayList<IShape>();
	
	
	public GroupShape(ArrayList<IShape> selectedShapeList2) {
		System.out.println("GroupShapeTEmpPList size " + groupShapeList.size());
		for(IShape shape: selectedShapeList2) {
			{
				groupShapeList.add(shape);
			}
		}
		 IShape firstShape = groupShapeList.get(0);
		 
		 shapeType = firstShape.getShapeType();
		 primaryColor = firstShape.getPrimaryColor();
		 sst = firstShape.getSST();
		 secondaryColor = firstShape.getSecondaryColor();
	    	 int startX = firstShape.getStartPoint().x;
		 int endX = firstShape.getEndPoint().x;
		 int startY = firstShape.getStartPoint().y;
		 int endY = firstShape.getEndPoint().y;
		 
		 System.out.println("GroupShapeTEmpPList size " + groupShapeList.size());
		 
		for(IShape shape: groupShapeList) {

			
			 startPoint = shape.getStartPoint();
	         endPoint = shape.getEndPoint();
	        
			 startX = Math.min(startX, (Math.min(startPoint.x, endPoint.x)));
			 endX = Math.max(endX, (Math.max(startPoint.x, endPoint.x)));
			startY = Math.min(startY, (Math.min(startPoint.y, endPoint.y)));
			endY = Math.max(endY, (Math.max(startPoint.y, endPoint.y)));
		}

		
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
			if(shape instanceof JShape) {
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
		
	}
			else {
				shape.draw(graphics2d);
			}
	}
	}
		
				
				
	   
	
		
		
		
	

	@Override
	public void move(int deltaX, int deltaY) {
		for(IShape shape: groupShapeList) {

		shape.getStartPoint().x = shape.getStartPoint().x + deltaX;
		shape.getEndPoint().x = shape.getEndPoint().x + deltaX;
		shape.getStartPoint().y = shape.getStartPoint().y + deltaY;
		shape.getEndPoint().y = shape.getEndPoint().y + deltaY;
	}
	}
	@Override
	public void delete(ShapeList shapeList) {
		
		shapeList.removeShape(this);
		
	}
	@Override
	public IShape paste() {
		
		ArrayList<IShape> tempPaste = new ArrayList<IShape>();
		
		for(IShape shape: groupShapeList) {
			 PointClass startPoint = new PointClass(shape.getStartPoint().x + 20, shape.getStartPoint().y + 20);
			 PointClass endPoint = new PointClass(shape.getEndPoint().x + 20, shape.getEndPoint().y + 20);
			   IShape newShape = new JShape(startPoint, endPoint, shape.getPrimaryColor(), shape.getShapeType(), 
	            shape.getSST(), shape.getSecondaryColor());
			 tempPaste.add(newShape);
			  
		
			
		}
		GroupShape gp = new GroupShape(tempPaste);
		return gp;
	}

	}

	

