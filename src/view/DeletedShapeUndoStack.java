package view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class DeletedShapeUndoStack implements Iterable<IShape> {
	
	
	//public final ArrayList<JShape> deletedShapeList;
	public final Stack<IShape> deletedShapeList;
	public DeletedShapeUndoStack() {
		//deletedShapeList = new ArrayList<JShape>();
		deletedShapeList = new Stack<IShape>();
	}
	
	public void pushShape(IShape selectedShape) {
		//deletedShapeList.add(selectedShape);
		deletedShapeList.push(selectedShape);
		
		
	}
	
	public IShape popShape() {
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
	public void addAll(ArrayList<IShape> temp) {
		this.deletedShapeList.addAll(temp);
	}

	@Override
	public Iterator<IShape> iterator() {
		return deletedShapeList.iterator();
		
	}
	public boolean isEmpty() {
		return deletedShapeList.isEmpty();
	}

}
