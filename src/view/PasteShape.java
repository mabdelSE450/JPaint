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
	DeletedShapeList deletedShapeList;
	public PasteShape(PaintCanvas paintCanvas, ShapeList shapeList, CommandHistory cmd, CopiedShapeList copiedShapeList, DeletedShapeList deletedShapeList) {
		this.cmd = cmd;
		this.shapeList = shapeList;
		this.paintCanvas = paintCanvas;
		this.copiedShapeList = copiedShapeList;
		this.deletedShapeList = deletedShapeList;
	}
	
	
	public void run() {
		deletedShapeList.clearList();
		temp.clear();
		for(JShape shape: copiedShapeList) {
			PointClass startPoint = new PointClass(shape.startPoint.x + 20, shape.startPoint.y + 20);
		    PointClass endPoint = new PointClass(shape.endPoint.x + 20, shape.endPoint.y + 20);
			shape = new JShape(startPoint, endPoint, shape.getPrimaryColor(), shape.getShapeType(), 
					shape.getSST(), shape.getSecondaryColor());
			temp.add(shape);	
		}
		shapeList.addAll(temp);
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
