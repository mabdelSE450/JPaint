package view;

import java.awt.Color;

import model.ShapeColor;

public class StoredShapeColor {
	private ITestGroupShape shape;
	private ShapeColor shapeColor;
	private Color color;

	
	public StoredShapeColor(ITestGroupShape shape, ShapeColor shapeColor, Color color) {
		this.shape = shape;
		this.shapeColor = shapeColor;
		this.color = color;
	}
	
	public ITestGroupShape getShape() {
		return shape;
	}
	public ShapeColor getShapeColor() {
		return shapeColor;
	}
	public Color getColor() {
		return color;
	}
}
