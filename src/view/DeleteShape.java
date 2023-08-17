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
	CommandHistory cmd;
	DeleteOrPaste deleteOrPaste;
	public DeleteShape(PaintCanvas paintCanvas, SelectedShapeList selectedShapeList, 
			PasteShape pasteShape, DeletedShapeUndoStack undoStack, DeletedShapeRedoStack redoStack, ShapeList shapeList, CommandHistory cmd, DeleteOrPaste deleteOrPaste) {
		this.paintCanvas = paintCanvas;
		this.selectedShapeList = selectedShapeList;
		this.shapeList = shapeList;
		this.pasteShape = pasteShape;
		this.undoStack = undoStack;
		this.redoStack = redoStack;
		this.cmd = cmd;
		this.deleteOrPaste = deleteOrPaste;
	}
	
	public void run() {
    		deleteOrPaste.setDelete();
    			cmd.add(this);
				for(IShape shape:selectedShapeList) {
					shape.delete(shapeList);
					undoStack.pushShape(shape);
					}
				
		
	}


	@Override
	public void undo() {
		System.out.println("DeleteShape undo");
    	if(!undoStack.isEmpty()) {
			
			IShape shapeToAddBack = undoStack.popShape();
			shapeList.addShape(shapeToAddBack);
			redoStack.pushShape(shapeToAddBack);

			}
		
		}
	

	@Override
	public void redo() {
		

		if(!redoStack.isEmpty()) {
			IShape shapeToRemoveAgain = redoStack.popShape();
			shapeList.removeShape(shapeToRemoveAgain);

		undoStack.pushShape(shapeToRemoveAgain);
	}
		

}
}
