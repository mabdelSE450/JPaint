package view.gui;

import javax.swing.JComponent;

import model.ShapeColor;
import model.interfaces.IDialogProvider;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.EnumMap;
import java.util.Map;
import model.persistence.ApplicationState;
import view.IShapeListObserver;
import view.JShape;
import view.ShapeList;
import view.interfaces.IUiModule;


public class PaintCanvas extends JComponent implements IShapeListObserver {
	
	private  IUiModule uiModule;
    private  IDialogProvider dialogProvider;
    public ApplicationState appState = new ApplicationState(uiModule);
	public static EnumMap<ShapeColor, Color> map = new EnumMap<ShapeColor, Color>(ShapeColor.class);
	ShapeList shapeList;
	public PaintCanvas(ShapeList myList) {
		this.shapeList = myList;
		
		map.put(ShapeColor.BLACK, Color.black);
		map.put(ShapeColor.BLUE, Color.blue);
		map.put(ShapeColor.CYAN, Color.cyan);
		map.put(ShapeColor.RED, Color.red);
		map.put(ShapeColor.DARK_GRAY, Color.darkGray);
		map.put(ShapeColor.GRAY, Color.gray);
		map.put(ShapeColor.LIGHT_GRAY, Color.gray);
		map.put(ShapeColor.MAGENTA, Color.magenta);
		map.put(ShapeColor.ORANGE, Color.orange);
		map.put(ShapeColor.PINK, Color.pink);
		map.put(ShapeColor.WHITE, Color.white);
		map.put(ShapeColor.YELLOW, Color.yellow);
		map.put(ShapeColor.RED, Color.red);
		map.put(ShapeColor.GREEN, Color.green);
		
	}
//	public void setAppState(ApplicationState appState) {
//		this.appState = appState;
//	}

	
	
	@Override
    public void paint(Graphics g) {
    
		
        Graphics2D graphics2d = (Graphics2D)g;
        
        
        for( JShape shape:shapeList) {
        	
        	
        	shape.draw(graphics2d);
        	

        	
        	
        	//        	 graphics2d.setColor(map.get(shape.primaryColor));
//        	
//        	//graphics2d.setColor(Color.red);
//    		int width = Math.abs(shape.getEndPoint().x - shape.getStartPoint().x);
//    		int height = Math.abs(shape.getEndPoint().y - shape.getStartPoint().y);
//    		
//    		if(shape.getStartPoint().x > shape.getEndPoint().x && shape.getStartPoint().y > shape.getEndPoint().y) {
//    			graphics2d.fillRect(shape.getEndPoint().x, shape.getEndPoint().y, width, height);
//    			}
//    		else if(shape.getStartPoint().x > shape.getEndPoint().x && shape.getStartPoint().y < shape.getEndPoint().y) {
//    			graphics2d.fillRect(shape.getEndPoint().x, shape.getStartPoint().y, width, height);
//    			}
//    		else if(shape.getStartPoint().x < shape.getEndPoint().x && shape.getStartPoint().y > shape.getEndPoint().y) {
//    			graphics2d.fillRect(shape.getStartPoint().x, shape.getEndPoint().y, width, height);
//    			}
//    		else if(shape.getStartPoint().x < shape.getEndPoint().x && shape.getStartPoint().y < shape.getEndPoint().y) {
//    			graphics2d.fillRect(shape.getStartPoint().x, shape.getStartPoint().y, width, height);
//    			}
//    		
//    		}

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



	@Override
	public void update() {
		this.repaint();
	}
}
