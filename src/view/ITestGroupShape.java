package view;

import java.awt.Graphics2D;

import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;

public interface ITestGroupShape {

	PointClass getStartPoint();

	PointClass getEndPoint();

	ShapeColor getPrimaryColor();

	ShapeType getShapeType();

	ShapeShadingType getSST();

	ShapeColor getSecondaryColor();

	int getWidth();

	int getHeight();

	void draw(Graphics2D graphics2d);

	ITestGroupShape paste();

	void move(int deltaX, int deltaY);

	void delete(ShapeList shapeList);

}