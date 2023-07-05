package view.gui;

import javax.swing.JComponent;


import view.JShape;
import view.ShapeList;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class PaintCanvas extends JComponent {
	ShapeList shapeList;
	public PaintCanvas(ShapeList myList) {
		this.shapeList = myList;
	}
	
	PaintCanvas paintCanvas;
		
	
	@Override
    public void paint(Graphics g) {
    
        Graphics2D graphics2d = (Graphics2D)g;
        System.out.println(shapeList.size());
        
        for( JShape shape:shapeList) {
        	graphics2d.setColor(Color.red);
    		int width = Math.abs(shape.getEndPoint().x - shape.getStartPoint().x);
    		int height = Math.abs(shape.getEndPoint().y - shape.getStartPoint().y);
    		
    		if(shape.getStartPoint().x > shape.getEndPoint().x && shape.getStartPoint().y > shape.getEndPoint().y) {
    			graphics2d.fillRect(shape.getEndPoint().x, shape.getEndPoint().y, width, height);
    			}
    		else if(shape.getStartPoint().x > shape.getEndPoint().x && shape.getStartPoint().y < shape.getEndPoint().y) {
    			graphics2d.fillRect(shape.getEndPoint().x, shape.getStartPoint().y, width, height);
    			}
    		else if(shape.getStartPoint().x < shape.getEndPoint().x && shape.getStartPoint().y > shape.getEndPoint().y) {
    			graphics2d.fillRect(shape.getStartPoint().x, shape.getEndPoint().y, width, height);
    			}
    		else if(shape.getStartPoint().x < shape.getEndPoint().x && shape.getStartPoint().y < shape.getEndPoint().y) {
    			graphics2d.fillRect(shape.getStartPoint().x, shape.getStartPoint().y, width, height);
    			}
    		}

        // Draw all shapes here

        // For example purposes only; remove all lines below from your final project.
//        graphics2d.setColor(Color.GREEN);
//        graphics2d.fillRect(12, 13, 200, 400);
//
//        // Outlined rectangle
//        graphics2d.setStroke(new BasicStroke(5));
//        graphics2d.setColor(Color.BLUE);
//        graphics2d.drawRect(12, 13, 200, 400);
//
//        // Selected Shape
//        Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
//        graphics2d.setStroke(stroke);
//        graphics2d.setColor(Color.BLACK);
//        graphics2d.drawRect(7, 8, 210, 410);
        
    }
}
