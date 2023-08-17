package view;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Iterator;

import model.persistence.ApplicationState;

public class SelectedShapeList implements Iterable<IShape>  {
	
	public final ArrayList<IShape> selectedShapeList;
	public SelectedShapeList() {
		selectedShapeList = new ArrayList<IShape>();
	}
	
	public void addShape(IShape selectedShape) {
		selectedShapeList.add(selectedShape);
		
		
	}
	
	public void removeShape(IShape selectedShape) {
		selectedShapeList.remove(selectedShape);
	}
	
	public void clearList() {
		selectedShapeList.clear();
	}
	public int getSize() {
		return selectedShapeList.size();
	}
	public void addAll(ArrayList<IShape> temp) {
		this.selectedShapeList.addAll(temp);
	}
	public void removeAll(ArrayList<IShape> temp) {
		this.selectedShapeList.removeAll(temp);
	}

	@Override
	public Iterator<IShape> iterator() {
		return selectedShapeList.iterator();
	}
	
	

	



}