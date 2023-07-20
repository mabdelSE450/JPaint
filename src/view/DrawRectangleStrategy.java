package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.EnumMap;

import model.ShapeColor;
import view.gui.PaintCanvas;

public class DrawRectangleStrategy implements IStrategy {


	@Override
	public void draw(JShape shape, Graphics2D graphics2d) {
		int width = Math.abs(shape.getEndPoint().x - shape.getStartPoint().x);
		int height = Math.abs(shape.getEndPoint().y - shape.getStartPoint().y);
		//graphics2d.setColor(PaintCanvas.map.get(shape.getPrimaryColor()));
		
		switch(shape.getSST().toString()) {
		case("FILLED_IN"):
		if(shape.getStartPoint().x > shape.getEndPoint().x && shape.getStartPoint().y > shape.getEndPoint().y) {
			graphics2d.setColor(PaintCanvas.map.get(shape.getPrimaryColor()));
			graphics2d.fillRect(shape.getEndPoint().x, shape.getEndPoint().y, width, height);
			}
		else if(shape.getStartPoint().x > shape.getEndPoint().x && shape.getStartPoint().y < shape.getEndPoint().y) {
			graphics2d.setColor(PaintCanvas.map.get(shape.getPrimaryColor()));
			graphics2d.fillRect(shape.getEndPoint().x, shape.getStartPoint().y, width, height);
			}
		else if(shape.getStartPoint().x < shape.getEndPoint().x && shape.getStartPoint().y > shape.getEndPoint().y) {
			graphics2d.setColor(PaintCanvas.map.get(shape.getPrimaryColor()));
			graphics2d.fillRect(shape.getStartPoint().x, shape.getEndPoint().y, width, height);
			}
		else if(shape.getStartPoint().x < shape.getEndPoint().x && shape.getStartPoint().y < shape.getEndPoint().y) {
			graphics2d.setColor(PaintCanvas.map.get(shape.getPrimaryColor()));
			graphics2d.fillRect(shape.getStartPoint().x, shape.getStartPoint().y, width, height);
			}
		break;
		case("OUTLINE"):
			if(shape.getStartPoint().x > shape.getEndPoint().x && shape.getStartPoint().y > shape.getEndPoint().y) {
				graphics2d.setStroke(new BasicStroke(5));
				graphics2d.setColor(PaintCanvas.map.get(shape.getPrimaryColor()));
				//graphics2d.setColor(PaintCanvas.map.get(shape.getSecondayColor()));
				graphics2d.drawRect(shape.getEndPoint().x, shape.getEndPoint().y, width, height);
				}
			else if(shape.getStartPoint().x > shape.getEndPoint().x && shape.getStartPoint().y < shape.getEndPoint().y) {
				graphics2d.setStroke(new BasicStroke(5));
				graphics2d.setColor(PaintCanvas.map.get(shape.getPrimaryColor()));
				//graphics2d.setColor(PaintCanvas.map.get(shape.getSecondayColor()));
				graphics2d.drawRect(shape.getEndPoint().x, shape.getStartPoint().y, width, height);
				}
			else if(shape.getStartPoint().x < shape.getEndPoint().x && shape.getStartPoint().y > shape.getEndPoint().y) {
				graphics2d.setStroke(new BasicStroke(5));
				graphics2d.setColor(PaintCanvas.map.get(shape.getPrimaryColor()));
				//graphics2d.setColor(PaintCanvas.map.get(shape.getSecondayColor()));
				graphics2d.drawRect(shape.getStartPoint().x, shape.getEndPoint().y, width, height);
				}
			else if(shape.getStartPoint().x < shape.getEndPoint().x && shape.getStartPoint().y < shape.getEndPoint().y) {
				graphics2d.setStroke(new BasicStroke(5));
				graphics2d.setColor(PaintCanvas.map.get(shape.getPrimaryColor()));
				//graphics2d.setColor(PaintCanvas.map.get(shape.getSecondayColor()));
				graphics2d.drawRect(shape.getStartPoint().x, shape.getStartPoint().y, width, height);
				}
		break;
		case("OUTLINE_AND_FILLED_IN"):
			if(shape.getStartPoint().x > shape.getEndPoint().x && shape.getStartPoint().y > shape.getEndPoint().y) {
				graphics2d.setColor(PaintCanvas.map.get(shape.getPrimaryColor()));
				graphics2d.fillRect(shape.getEndPoint().x, shape.getEndPoint().y, width, height);
				graphics2d.setStroke(new BasicStroke(5));
				graphics2d.setColor(PaintCanvas.map.get(shape.getSecondayColor()));
				graphics2d.drawRect(shape.getEndPoint().x, shape.getEndPoint().y, width, height);
				}
			else if(shape.getStartPoint().x > shape.getEndPoint().x && shape.getStartPoint().y < shape.getEndPoint().y) {
				graphics2d.setColor(PaintCanvas.map.get(shape.getPrimaryColor()));
				graphics2d.fillRect(shape.getEndPoint().x, shape.getStartPoint().y, width, height);
				graphics2d.setStroke(new BasicStroke(5));
				graphics2d.setColor(PaintCanvas.map.get(shape.getSecondayColor()));
				graphics2d.drawRect(shape.getEndPoint().x, shape.getStartPoint().y, width, height);
				}
			else if(shape.getStartPoint().x < shape.getEndPoint().x && shape.getStartPoint().y > shape.getEndPoint().y) {
				graphics2d.setColor(PaintCanvas.map.get(shape.getPrimaryColor()));
				graphics2d.fillRect(shape.getStartPoint().x, shape.getEndPoint().y, width, height);
				graphics2d.setStroke(new BasicStroke(5));
				graphics2d.setColor(PaintCanvas.map.get(shape.getSecondayColor()));
				graphics2d.drawRect(shape.getStartPoint().x, shape.getEndPoint().y, width, height);
				}
			else if(shape.getStartPoint().x < shape.getEndPoint().x && shape.getStartPoint().y < shape.getEndPoint().y) {
				graphics2d.setColor(PaintCanvas.map.get(shape.getPrimaryColor()));
				graphics2d.fillRect(shape.getStartPoint().x, shape.getStartPoint().y, width, height);
				graphics2d.setStroke(new BasicStroke(5));
				graphics2d.setColor(PaintCanvas.map.get(shape.getSecondayColor()));
				graphics2d.drawRect(shape.getStartPoint().x, shape.getStartPoint().y, width, height);
				}
		break;
		}
	}
}

	
		
	




