package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.util.ArrayList;

import model.persistence.ApplicationState;
import view.gui.PaintCanvas;

public class SelectShape {
	PaintCanvas paintCanvas;
	boolean dsp;
	SelectedShapeList selectedShapeList = new SelectedShapeList();
	GroupShapeTempList groupShapeTempList = new GroupShapeTempList();
	BoundingBoxShape boundingShape;
	//CommandHistory cmd;
	
	Graphics graphics;
	 Graphics2D graphics2d = (Graphics2D)graphics;
	 
	 public SelectShape(PaintCanvas paintCanvas) {
		 this.paintCanvas = paintCanvas;
		// this.createGroupShape = createGroupShape
		 
	 }
	 
	
	
	public void run(SelectedShapeList selectedShapeList,PointClass start, PointClass end ) {
		
		
		
		selectedShapeList.clearList();
		
		if(start.x > end.x && start.y > end.y ) {
			int tempX;
			int tempY;
			tempX = start.x;
			start.x = end.x;
			end.x = tempX;
			tempY = start.y;
			start.y = end.y;
			end.y = tempY;
			
		}
		else if(start.x < end.x && start.y >= end.y) {
			int temp;
			temp = end.y;
			end.y = start.y;
			start.y = temp;
			
			
		}
		else if(start.x >= end.x && start.y < end.y) {
			int temp;
			temp = start.x;
			start.x = end.x;
			end.x = temp;
			
			
		}
		boundingShape = new BoundingBoxShape(start, end) ;
		
	}
	public boolean checkCollision(IShape shape) {
		
		if(boundingShape.getStartPoint().x < shape.getEndPoint().x && 
		boundingShape.getEndPoint().x  > shape.getStartPoint().x &&
		boundingShape.getStartPoint().y < shape.getEndPoint().y &&
		boundingShape.getEndPoint().y > shape.getStartPoint().y)
		
		{ 
			
			PointClass startPoint = new PointClass(shape.getStartPoint().x - 3, shape.getStartPoint().y - 3);
	    	PointClass endPoint = new PointClass(shape.getEndPoint().x - 3, shape.getEndPoint().y - 3);
	    	int newHeight = shape.getHeight() + 6;
	    	int newWidth = shape.getWidth() +6 ;
			
			graphics2d = (Graphics2D) paintCanvas.getGraphics();
			//System.out.println("Graphics2d hash code " + graphics2d.hashCode());
			Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
	        graphics2d.setStroke(stroke);
	        graphics2d.setColor(Color.BLACK);
	        if(shape instanceof GroupShape) {
	        	if(startPoint.x > endPoint.x && startPoint.y > endPoint.y) {
	    			graphics2d.drawRect(endPoint.x, endPoint.y, newWidth, newHeight);
	    			}
	    		else if(startPoint.x> endPoint.x && startPoint.y < endPoint.y) {
	    			graphics2d.drawRect(endPoint.x, startPoint.y, newWidth, newHeight);
	    			}
	    		else if(startPoint.x < endPoint.x && startPoint.y > endPoint.y) {
	    			graphics2d.drawRect(startPoint.x, endPoint.y, newWidth, newHeight);
	    			}
	    		else if(startPoint.x < endPoint.x && startPoint.y < endPoint.y) {
	    			graphics2d.drawRect(startPoint.x, startPoint.y, newWidth, newHeight);
	    			}
	        }
	        
	        else if(shape.getShapeType().toString().equals("RECTANGLE")) {
	        if(startPoint.x > endPoint.x && startPoint.y > endPoint.y) {
    			graphics2d.drawRect(endPoint.x, endPoint.y, newWidth, newHeight);
    			}
    		else if(startPoint.x> endPoint.x && startPoint.y < endPoint.y) {
    			graphics2d.drawRect(endPoint.x, startPoint.y, newWidth, newHeight);
    			}
    		else if(startPoint.x < endPoint.x && startPoint.y > endPoint.y) {
    			graphics2d.drawRect(startPoint.x, endPoint.y, newWidth, newHeight);
    			}
    		else if(startPoint.x < endPoint.x && startPoint.y < endPoint.y) {
    			graphics2d.drawRect(startPoint.x, startPoint.y, newWidth, newHeight);
    			}
	        }
	        else if(shape.getShapeType().toString().equals("ELLIPSE")) {
	        	if(startPoint.x > endPoint.x && startPoint.y > endPoint.y) {
	    			graphics2d.drawOval(endPoint.x, endPoint.y, newWidth, newHeight);
	    			}
	    		else if(startPoint.x> endPoint.x && startPoint.y < endPoint.y) {
	    			graphics2d.drawOval(endPoint.x, startPoint.y, newWidth, newHeight);
	    			}
	    		else if(startPoint.x < endPoint.x && startPoint.y > endPoint.y) {
	    			graphics2d.drawOval(startPoint.x, endPoint.y, newWidth, newHeight);
	    			}
	    		else if(startPoint.x < endPoint.x && startPoint.y < endPoint.y) {
	    			graphics2d.drawOval(startPoint.x, startPoint.y, newWidth, newHeight);
	    			}
	        }
	        else if(shape.getShapeType().toString().equals("TRIANGLE")) {
//	        	int[] x  = new int[3];
//	    		x[0] = shape.startPoint.x - 3;
//	    		x[1] = shape.endPoint.x + 10;
//	    		x[2] = shape.startPoint.x - 3;
//	    		int[] y = new int [3];
//	    		y[0] = shape.startPoint.y - 6;
//	    		y[1] = shape.endPoint.y + 3;
//	    		y[2] = shape.endPoint.y + 3;
//	    		int nInts = 3;
	        	int[] x  = new int[3];
	    		x[0] = shape.getStartPoint().x - 3;
	    		x[1] = shape.getEndPoint().x + 10;
	    		x[2] = shape.getStartPoint().x - 3;
	    		int[] y = new int [3];
	    		y[0] = shape.getStartPoint().y - 6;
	    		y[1] = shape.getEndPoint().y + 3;
	    		y[2] = shape.getEndPoint().y + 3;
	    		int nInts = 3;
	    		graphics2d.drawPolygon(x, y, nInts);
	        }
	        return true;}
		else {
			return false;
		}
		}
	}

