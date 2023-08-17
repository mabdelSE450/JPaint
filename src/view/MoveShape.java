package view;

import java.util.ArrayList;

import view.gui.PaintCanvas;

public class MoveShape implements IUndoable  {
	BoundingBoxShape boundingBox;
	SelectedShapeList selectedShapeList = new SelectedShapeList(); 
	PaintCanvas paintCanvas;
	private static int deltaX;
	private static int deltaY;
	CommandHistory cmd;
	
	 private static ArrayList<IShape> shapeListCopy = new ArrayList<IShape>();
	public MoveShape(PaintCanvas paintCanvas, CommandHistory cmd) {
		this.paintCanvas = paintCanvas;
		this.cmd = cmd;
}
	
public void run(SelectedShapeList selectedShapeList, PointClass startPoint, PointClass endPoint) {
	
		shapeListCopy.clear();
		boundingBox = new BoundingBoxShape(startPoint, endPoint);
		 deltaX = boundingBox.getEndPoint().x - boundingBox.getStartPoint().x;
		 deltaY = boundingBox.getEndPoint().y - boundingBox.getStartPoint().y;
		 cmd.add(this);
		for(IShape shape: selectedShapeList) {
		shape.move(deltaX, deltaY);
		shapeListCopy.add(shape);
		//paintCanvas.getInstance().repaint();
		paintCanvas.repaint();
		}
}
	
	@Override
	public void undo() {
		for(IShape shape: shapeListCopy) {
			shape.move(-(deltaX), -(deltaY));
			//paintCanvas.getInstance().repaint();
			paintCanvas.repaint();
		}
	}
	
	

	@Override
	public void redo() {
		for(IShape shape: shapeListCopy) {
			shape.move(deltaX, deltaY);
			//paintCanvas.getInstance().repaint();
			paintCanvas.repaint();
		}
		
	}
}
	