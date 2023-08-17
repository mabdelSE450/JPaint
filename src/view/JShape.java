package view;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.EnumMap;

import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.persistence.ApplicationState;
import view.interfaces.IUiModule;

public class JShape implements IPointShape, IShape {
	//private IUiModule uiModule;
	PointClass endPoint;
	PointClass startPoint;
	//ApplicationState appState;
	final ShapeColor primaryColor;
	final ShapeType shapeType;
	final ShapeShadingType sst;
	final ShapeColor secondaryColor;
	//ShapeList shapeList;
	

	public JShape(PointClass startPoint, PointClass endPoint, ShapeColor primaryColor, 
			ShapeType shapeType, ShapeShadingType sst, ShapeColor secondaryColor) {
	
	this.primaryColor = primaryColor;
	this.endPoint = endPoint;
	this.startPoint = startPoint;
	//this.appState = appState;
	this.shapeType = shapeType;
	this.sst = sst;
	this.secondaryColor = secondaryColor;
}
	
//	public void setShapeList(ShapeList shapeList) {
//		this.shapeList = shapeList;
//	}

	@Override
	public PointClass getStartPoint() {
		return startPoint;
	}
	@Override
	public PointClass getEndPoint() {
		return endPoint;
	}
	@Override
	public  ShapeColor getPrimaryColor() {
		
		return  primaryColor;
		}
	@Override
	public ShapeType getShapeType() {
		return shapeType;
	}
	@Override
	public ShapeShadingType getSST() {
		return sst;
	}
	@Override
	public ShapeColor getSecondaryColor() {
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
		switch(this.shapeType.toString()) {
		case "RECTANGLE":
			DrawRectangleStrategy rect = new DrawRectangleStrategy();
			rect.draw(this, graphics2d);
			break;
		case "ELLIPSE":
			DrawEllipseStrategy ellp = new DrawEllipseStrategy();
			ellp.draw(this, graphics2d);
			break;
		case "TRIANGLE":
			DrawTriangleStrategy triangle = new DrawTriangleStrategy();
			triangle.draw(this, graphics2d);
			break;
		}
	}

//	@Override
//	public IPointShape paste(){
//	//public void paste(PointClass start, PointClass end) {
////		this.startPoint.x += 20;
////	    this.startPoint.y += 20;
////	    this.endPoint.x += 20;
////	    this.endPoint.y += 20;
////	PointClass startPoint = new PointClass(this.startPoint.x + 20, this.startPoint.y + 20);
////	    PointClass endPoint = new PointClass(this.endPoint.x + 20, this.endPoint.y + 20);
////	    IPointShape newShape = new IPointShape(startPoint, endPoint, this.getPrimaryColor(), this.getShapeType(), 
////	                                 this.getSST(), this.getSecondaryColor());
////	    return newShape;
//		
//		
//	}

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
			System.out.println("JShape delete method");
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
	

	
	
	


