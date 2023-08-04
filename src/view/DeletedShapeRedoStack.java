package view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class DeletedShapeRedoStack implements Iterable<JShape> {
	
	
	public final Stack<JShape> deletedShapeList;
	public DeletedShapeRedoStack() {
		//deletedShapeList = new ArrayList<JShape>();
		deletedShapeList = new Stack<JShape>();
	}
	
	public void pushShape(JShape selectedShape) {
		//deletedShapeList.add(selectedShape);
		deletedShapeList.push(selectedShape);
		
		
	}
	
	public JShape popShape() {
		//deletedShapeList.remove(selectedShape);
		  return deletedShapeList.pop();
	}
	
	public void clearList() {
		//deletedShapeList.clear();
		deletedShapeList.clear();
	}
	public int getSize() {
		//return deletedShapeList.size();
		return deletedShapeList.size();
	}
	public void addAll(ArrayList<JShape> temp) {
		this.deletedShapeList.addAll(temp);
	}

	@Override
	public Iterator<JShape> iterator() {
		return deletedShapeList.iterator();
		
	}
	public boolean isEmpty() {
		return deletedShapeList.isEmpty();
	}

}



