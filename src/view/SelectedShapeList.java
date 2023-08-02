package view;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Iterator;

import model.persistence.ApplicationState;

public class SelectedShapeList implements Iterable<JShape>  {
	
	public final ArrayList<JShape> selectedShapeList;
	public SelectedShapeList() {
		selectedShapeList = new ArrayList<JShape>();
	}
	
	public void addShape(JShape selectedShape) {
		selectedShapeList.add(selectedShape);
		
		
	}
	
	public void removeShape(JShape selectedShape) {
		selectedShapeList.remove(selectedShape);
	}
	
	public void clearList() {
		selectedShapeList.clear();
	}
	public int getSize() {
		return selectedShapeList.size();
	}
	public void addAll(ArrayList<JShape> temp) {
		this.selectedShapeList.addAll(temp);
	}

	@Override
	public Iterator<JShape> iterator() {
		return selectedShapeList.iterator();
	}
	
	

	



}