package view;

import java.util.ArrayList;

import model.interfaces.IApplicationState;
import model.persistence.ApplicationState;
import view.gui.PaintCanvas;

public class PasteShape implements IUndoable {

	ArrayList<IShape> temp = new ArrayList<IShape>();
	ShapeList shapeList;
	PaintCanvas paintCanvas;
	CommandHistory cmd;
	CopiedShapeList copiedShapeList;
	ITestGroupShape PastedShape;
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
	public void run(CreateGroupShape createGroupShape) {
		//createGroupShape.groupedOrNot = false;
    	deleteOrPaste.setPaste();
		temp.clear();
		cmd.add(this);
		System.out.println("CopiedSHapeList size " + copiedShapeList.getSize());
		for(IShape shape: copiedShapeList) {
			//if(shape instanceof JShape) {
			IShape newshape =  shape.paste();
			temp.add(newshape);	
		}
//			else {
//				temp.add(shape);
//				GroupShape gp = new GroupShape(temp);
				
			
		shapeList.addAll(temp);
		
		System.out.println("ShapeList size in Paste run " + shapeList.size());

		for (IShape shape: shapeList) {
			
			paintCanvas.getInstance().repaint();
		}
		copiedShapeList.clearList();
	}
	
	@Override
	public void undo() {
		//System.out.println("Paste method undo");
	for (IShape shape:temp) {
			shapeList.removeShape(shape);
		}

	}

	@Override
	public void redo() {
		for (IShape shape:temp) {
			shapeList.addShape(shape);
		}
		}
}
