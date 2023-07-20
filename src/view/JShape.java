package view;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.EnumMap;

import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.persistence.ApplicationState;
import view.interfaces.IUiModule;

public class JShape implements IPointShape, IShape{
	private IUiModule uiModule;
	PointClass endPoint;
	PointClass startPoint;
	ApplicationState appState;
	final ShapeColor primaryColor;
	final ShapeType shapeType;
	final ShapeShadingType sst;
	final ShapeColor secondaryColor;
	
	

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
	
	

	public PointClass getStartPoint() {
		return startPoint;
	}
	public PointClass getEndPoint() {
		return endPoint;
	}
	public  ShapeColor getPrimaryColor() {
		
		return  primaryColor;
		}
	public ShapeType getShapeType() {
		return shapeType;
	}
	public ShapeShadingType getSST() {
		return sst;
	}
	public ShapeColor getSecondayColor() {
		return secondaryColor;
	}
	public int getWidth() {
		return Math.abs(this.getEndPoint().x - this.getStartPoint().x);
	}
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

	@Override
	public void paste() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move(int deltaX, int deltaY) {
		
		this.startPoint.x = this.startPoint.x + deltaX;
		this.endPoint.x = this.endPoint.x + deltaX;
		this.startPoint.y = this.startPoint.y + deltaY;
		this.endPoint.y = this.endPoint.y + deltaY;

	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}
	}
	

	
	
	


