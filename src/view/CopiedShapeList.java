package view;

import java.util.ArrayList;
import java.util.Iterator;

public class CopiedShapeList  implements Iterable<IShape> {

	public final ArrayList<IShape> copiedShapeList;
	public CopiedShapeList() {
		copiedShapeList = new ArrayList<IShape>();
	}
	
	public void addShape(IShape selectedShape) {
		copiedShapeList.add(selectedShape);
		
		
	}
	
	public void removeShape(IShape selectedShape) {
		copiedShapeList.remove(selectedShape);
	}
	
	public void clearList() {
		copiedShapeList.clear();
	}
	public int getSize() {
		return copiedShapeList.size();
	}
	public void addAll(ArrayList<IShape> temp) {
		this.copiedShapeList.addAll(temp);
	}

	@Override
	public Iterator<IShape> iterator() {
		return copiedShapeList.iterator();
	}
	
	
}
