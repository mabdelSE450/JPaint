package view;

import java.awt.Color;

import model.ShapeColor;

public class StoredShapeColor {
	private JShape shape;
	private ShapeColor shapeColor;
	private Color color;

	
	public StoredShapeColor(JShape shape, ShapeColor shapeColor, Color color) {
		this.shape = shape;
		this.shapeColor = shapeColor;
		this.color = color;
	}
	
	public JShape getShape() {
		return shape;
	}
	public ShapeColor getShapeColor() {
		return shapeColor;
	}
	public Color getColor() {
		return color;
	}
}
