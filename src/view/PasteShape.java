package view;

import java.util.ArrayList;

import model.persistence.ApplicationState;
import view.gui.PaintCanvas;

public class PasteShape implements IUndoable {

	
	//PaintCanvas paintCanvas = new PaintCanvas();
	ShapeList shapeList;
	PaintCanvas paintCanvas;
	CommandHistory cmd;
	CopiedShapeList copiedShapeList;
	
	public PasteShape(PaintCanvas paintCanvas, ShapeList shapeList, CommandHistory cmd, CopiedShapeList copiedShapeList) {
		this.cmd = cmd;
		this.shapeList = shapeList;
		this.paintCanvas = paintCanvas;
		this.copiedShapeList = copiedShapeList;
	}
	
	
	public void run() {
		ArrayList<JShape> temp = new ArrayList<JShape>();

		for(JShape shape: copiedShapeList) {
			PointClass startPoint = new PointClass(shape.startPoint.x + 20, shape.startPoint.y + 20);
		    PointClass endPoint = new PointClass(shape.endPoint.x + 20, shape.endPoint.y + 20);
			

			
			
			  shape = new JShape(startPoint, endPoint, shape.getPrimaryColor(), shape.getShapeType(), 
					shape.getSST(), shape.getSecondayColor());
			//shapeList.addShape(shape);
			temp.add(shape);
			//paintCanvas.repaint();
			
		}
		shapeList.addAll(temp);
		for (JShape shape: shapeList) {
		
			paintCanvas.getInstance().repaint();
		//paintCanvas.repaint();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		
	}

}
