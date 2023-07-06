package view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import view.gui.PaintCanvas;

public class Click_Handler extends MouseAdapter{
	
	 PointClass startPoint = new PointClass(0,0);
	 PointClass endPoint = new PointClass(0,0); 
	
	PaintCanvas paintCanvas;
	 int width;
	int height;
	ShapeList shapeList;
	CommandHistory cmd;
	
	public Click_Handler(ShapeList shapeList, PaintCanvas paintCanvas) {
		this.shapeList = shapeList;
		this.paintCanvas = paintCanvas;
		
	}
	
	

	@Override
	public void mousePressed(MouseEvent e) {
		startPoint = new PointClass(e.getX(), e.getY());
		}	
	
	
	@Override
	public void mouseReleased(MouseEvent e) {
		endPoint = new PointClass(e.getX(), e.getY());
		CreateShape createShape = new CreateShape(paintCanvas, shapeList, cmd);
		createShape.run(startPoint, endPoint);
		

		}
	}
