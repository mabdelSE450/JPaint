package view;

import java.util.ArrayList;

import view.gui.PaintCanvas;

public class DeleteShape implements IUndoable {
	
	SelectedShapeList selectedShapeList;
	PaintCanvas paintCanvas;
	ShapeList shapeList;
	DeletedShapeList deletedShapeList;
	PasteShape pasteShape;
	public DeleteShape(ShapeList shapeList, PaintCanvas paintCanvas, SelectedShapeList selectedShapeList, PasteShape pasteShape) {
		this.paintCanvas = paintCanvas;
		this.selectedShapeList = selectedShapeList;
		this.shapeList = shapeList;
		this.pasteShape = pasteShape;
	}
	
	
	public void run() {
		deletedShapeList = new DeletedShapeList();
		for(JShape shape:selectedShapeList) {
			shapeList.removeShape(shape);
			deletedShapeList.addShape(shape);
			
		}
		
	}


	@Override
	public void undo() {
		System.out.println("DeleteShape undo method ran");
		for(JShape shape: deletedShapeList) {
			shapeList.addShape(shape);
		}
		}
	

	@Override
	public void redo() {
		for(JShape shape: deletedShapeList) {
			shapeList.removeShape(shape);
		}
		
	}
}
