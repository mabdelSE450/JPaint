package view;

import java.util.ArrayList;
import java.util.Iterator;

import view.gui.PaintCanvas;

public class ShapeList  implements Iterable<JShape>   {
	ShapeList shapeList;
	
	private ArrayList<JShape> myList;
	
	PaintCanvas paintCanvas = new PaintCanvas(shapeList);
	//PaintCanvas paintCanvas;
	public ShapeList() {
		myList = new ArrayList<JShape>();
		
		}
	
	public void setPaintCanvas(PaintCanvas paintCanvas) {
		this.paintCanvas = paintCanvas;
	}
	
	
	public void addShape(JShape shape) {
		myList.add(shape);
		paintCanvas.repaint();
		
	}
	
	public boolean isEmpty() {
		return myList.isEmpty();
	}

	public int size() {
		return myList.size();
	}
	
	public void removeShape(JShape shape) {
		myList.remove(shape);
		paintCanvas.repaint();
		
	}

	@Override
	public Iterator<JShape> iterator() {
		return myList.iterator();
	}


	
	

}
