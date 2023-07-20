package view;

import java.awt.Graphics2D;

import model.ShapeColor;
import model.ShapeShadingType;

public abstract class Shape implements IShape {

	private PointClass startPoint;
	private int height;
	private int width;
	private ShapeColor primaryColor;
	private ShapeColor secondaryColor;
	private ShapeShadingType shadingType;
	
	
}
