package view;

import view.gui.PaintCanvas;

public class UndoCommand implements IRun {

	 	ShapeList shapeList;
	    JShape shape;

	    

		@Override
		public void run() {
			shapeList.removeShape(shape);
			
		}

	
	

}
