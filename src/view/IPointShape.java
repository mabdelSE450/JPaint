package view;

import java.awt.Graphics2D;

import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;

public interface IPointShape {
	
	public  PointClass getEndPoint();
	public  PointClass getStartPoint();
	
//	ShapeColor getPrimaryColor();
//	
//	ShapeType getShapeType();
//
//	ShapeShadingType getSST();
//
//	ShapeColor getSecondaryColor();
//
//	int getWidth();
//
//	int getHeight();
//
//	void draw(Graphics2D graphics2d);
//
//	public IPointShape paste();
//
//	void move(int deltaX, int deltaY);
//
//	void delete(ShapeList shapeList);
//	
//	void addShape(IPointShape shape);
}
