package view;

import java.util.ArrayList;

import model.persistence.ApplicationState;
import view.gui.PaintCanvas;

public class PasteShape implements IUndoable {

	ArrayList<JShape> temp = new ArrayList<JShape>();
	ShapeList shapeList;
	PaintCanvas paintCanvas;
	CommandHistory cmd;
	CopiedShapeList copiedShapeList;
	JShape PastedShape;
	DeletedShapeUndoStack deletedShapeList;
	DeleteOrPaste deleteOrPaste;
	public PasteShape(PaintCanvas paintCanvas, ShapeList shapeList, CommandHistory cmd, 
			CopiedShapeList copiedShapeList, DeletedShapeUndoStack deletedShapeList, DeleteOrPaste deleteOrPaste) {
		this.cmd = cmd;
		this.shapeList = shapeList;
		this.paintCanvas = paintCanvas;
		this.copiedShapeList = copiedShapeList;
		this.deletedShapeList = deletedShapeList;
		this.deleteOrPaste = deleteOrPaste;
	}
	
	
	//public void run() {
	public void run() {
    	deleteOrPaste.setPaste();
		temp.clear();
		for(JShape shape: copiedShapeList) {
			//System.out.println("ShapeList size " + shapeList.size());
			//shape.paste(start, end);
			JShape newShape = shape.paste();
			temp.add(newShape);	
		}
		shapeList.addAll(temp);
		//System.out.println("ShapeList size " + shapeList.size());

		for (JShape shape: shapeList) {
		
			paintCanvas.getInstance().repaint();
		}
		copiedShapeList.clearList();
	}
	
	@Override
	public void undo() {
	for (JShape shape:temp) {
			shapeList.removeShape(shape);
		}

	}

	@Override
	public void redo() {
		for (JShape shape:temp) {
			shapeList.addShape(shape);
		}
		}
}
