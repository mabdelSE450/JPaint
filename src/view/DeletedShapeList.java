package view;

import java.util.ArrayList;
import java.util.Iterator;

public class DeletedShapeList implements Iterable<JShape> {
	
	
	public final ArrayList<JShape> deletedShapeList;
	public DeletedShapeList() {
		deletedShapeList = new ArrayList<JShape>();
	}
	
	public void addShape(JShape selectedShape) {
		deletedShapeList.add(selectedShape);
		
		
	}
	
	public void removeShape(JShape selectedShape) {
		deletedShapeList.remove(selectedShape);
	}
	
	public void clearList() {
		deletedShapeList.clear();
	}
	public int getSize() {
		return deletedShapeList.size();
	}
	public void addAll(ArrayList<JShape> temp) {
		this.deletedShapeList.addAll(temp);
	}

	@Override
	public Iterator<JShape> iterator() {
		return deletedShapeList.iterator();
	}

}
