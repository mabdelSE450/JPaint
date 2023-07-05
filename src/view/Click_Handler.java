package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import view.gui.PaintCanvas;

public class Click_Handler extends MouseAdapter{
	
	Point startPoint = new Point();
	Point endPoint = new Point();
	
	PaintCanvas paintCanvas;
	int width;
	int height;
	ShapeList shapeList;
	CommandHistory cmd;
	
	public Click_Handler(ShapeList shapeList, PaintCanvas paintCanvas) {
		this.shapeList = shapeList;
		this.paintCanvas = paintCanvas;
	}
	
//	public Click_Handler(ShapeList shapeList, PaintCanvas paintCanvas) {
//		this.paintCanvas = paintCanvas;
//		this.shapeList = shapeList;
//	}
	
	
	@Override
	public void mousePressed(MouseEvent e) {
		startPoint.x = e.getX();
		
		startPoint.y = e.getY();
		}	
	
	
	@Override
	public void mouseReleased(MouseEvent e) {
		endPoint.x = e.getX();
		endPoint.y = e.getY();
		CreateShape createShape = new CreateShape(paintCanvas, shapeList, cmd);
		//CreateShape createShape = new CreateShape(paintCanvas, shapeList);
		createShape.run(startPoint, endPoint);
		
//		Graphics g = paintCanvas.getGraphics();
//		Graphics2D g2d = (Graphics2D)g;
//		g2d.setColor(Color.BLUE);
		
//		width = Math.abs(endPoint.x - startPoint.x);
//		height = Math.abs(endPoint.y - startPoint.y);
		
//		if(startPoint.x > endPoint.x && startPoint.y > endPoint.y) {
//			g2d.fillOval(endPoint.x, endPoint.y, width, height);
//			}
//		else if(startPoint.x > endPoint.x && startPoint.y < endPoint.y) {
//			g2d.fillOval(endPoint.x, startPoint.y, width, height);
//		}
//		else if(startPoint.x < endPoint.x && startPoint.y > endPoint.y) {
//			g2d.fillOval(startPoint.x, endPoint.y, width, height);
//		}
//		else if(startPoint.x < endPoint.x && startPoint.y < endPoint.y) {
//			g2d.fillOval(startPoint.x, startPoint.y, width, height);
//		}
		}
	}
