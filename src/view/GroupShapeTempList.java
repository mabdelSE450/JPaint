package view;

import java.util.ArrayList;
import java.util.Iterator;

public class GroupShapeTempList implements Iterable<IShape> {
	
	
	   
		
		public final ArrayList<IShape> groupselectedShapeList;
		public GroupShapeTempList() {
			groupselectedShapeList = new ArrayList<IShape>();
		}
		
		public void addShape(IShape selectedShape) {
			groupselectedShapeList.add(selectedShape);
			
			
		}
		
		public void removeShape(IShape selectedShape) {
			groupselectedShapeList.remove(selectedShape);
		}
		
		public void clearList() {
			groupselectedShapeList.clear();
		}
		public int getSize() {
			return groupselectedShapeList.size();
		}
		public void addAll(ArrayList<IShape> temp) {
			this.groupselectedShapeList.addAll(temp);
		}

		@Override
		public Iterator<IShape> iterator() {
			return groupselectedShapeList.iterator();
		}
		
		

		



	}


