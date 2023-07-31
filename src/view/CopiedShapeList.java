package view;

import java.util.ArrayList;
import java.util.Iterator;

public class CopiedShapeList  implements Iterable<JShape> {

	public final ArrayList<JShape> copiedShapeList;
	public CopiedShapeList() {
		copiedShapeList = new ArrayList<JShape>();
	}
	
	public void addShape(JShape selectedShape) {
		copiedShapeList.add(selectedShape);
		
		
	}
	
	public void removeShape(JShape selectedShape) {
		copiedShapeList.remove(selectedShape);
	}
	
	public void clearList() {
		copiedShapeList.clear();
	}
	public int getSize() {
		return copiedShapeList.size();
	}
	public void addAll(ArrayList<JShape> temp) {
		this.copiedShapeList.addAll(temp);
	}

	@Override
	public Iterator<JShape> iterator() {
		return copiedShapeList.iterator();
	}
	
	
}
