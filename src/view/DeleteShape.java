package view;

import java.util.ArrayList;

import view.gui.PaintCanvas;

public class DeleteShape implements IUndoable {
	
	SelectedShapeList selectedShapeList;
	PaintCanvas paintCanvas;
	ShapeList shapeList;
	DeletedShapeUndoStack undoStack;
	DeletedShapeRedoStack redoStack;
	PasteShape pasteShape;
	DeleteOrPaste deleteOrPaste;
	public DeleteShape(PaintCanvas paintCanvas, SelectedShapeList selectedShapeList, 
			PasteShape pasteShape, DeletedShapeUndoStack undoStack, DeletedShapeRedoStack redoStack, DeleteOrPaste deleteOrPaste, ShapeList shapeList) {
		this.paintCanvas = paintCanvas;
		this.selectedShapeList = selectedShapeList;
		this.shapeList = shapeList;
		this.pasteShape = pasteShape;
		this.undoStack = undoStack;
		this.redoStack = redoStack;
		//this.deleteOrPaste = deleteOrPaste;
		this.deleteOrPaste = deleteOrPaste;
	}
	
	public void run() {
    	deleteOrPaste.setDelete();
				for(JShape shape:selectedShapeList) {
					shape.delete(shapeList);
					undoStack.pushShape(shape);
					}
				
		
	}


	@Override
	public void undo() {
		System.out.println("Undo Stack size " + undoStack.getSize());
    	if(!undoStack.isEmpty()) {
			
			JShape shapeToAddBack = undoStack.popShape();
			shapeList.addShape(shapeToAddBack);
			redoStack.pushShape(shapeToAddBack);

			}
		
		}
	

	@Override
	public void redo() {
		

		if(!redoStack.isEmpty()) {
			JShape shapeToRemoveAgain = redoStack.popShape();
			shapeList.removeShape(shapeToRemoveAgain);

		undoStack.pushShape(shapeToRemoveAgain);
	}
		

}
}
