package view;

import java.util.ArrayList;

import view.gui.PaintCanvas;

public class MoveShape implements IUndoable  {
	BoundingBoxShape boundingBox;
	SelectedShapeList selectedShapeList = new SelectedShapeList(); 
	PaintCanvas paintCanvas;
	private static int deltaX;
	private static int deltaY;
	
	 private static ArrayList<JShape> shapeListCopy = new ArrayList<JShape>();
	public MoveShape(PaintCanvas paintCanvas) {
		this.paintCanvas = paintCanvas;
}
	
public void run(SelectedShapeList selectedShapeList, PointClass startPoint, PointClass endPoint) {
		shapeListCopy.clear();
		boundingBox = new BoundingBoxShape(startPoint, endPoint);
		 deltaX = boundingBox.getEndPoint().x - boundingBox.getStartPoint().x;
		 deltaY = boundingBox.getEndPoint().y - boundingBox.getStartPoint().y;
		 System.out.println("DeltaX and DeltaY for run method");
		 System.out.println(deltaX);
			System.out.println(deltaY);
		for(JShape shape: selectedShapeList) {
		shape.move(deltaX, deltaY);
		shapeListCopy.add(shape);
		paintCanvas.repaint();
		}
}
	
	@Override
	public void undo() {
		System.out.println("Deltax and DeltaY for undo method");
		System.out.println(deltaX);
		System.out.println(deltaY);
		for(JShape shape: shapeListCopy) {
			shape.move(-(deltaX), -(deltaY));
			paintCanvas.repaint();
		}
	}
	
	

	@Override
	public void redo() {
		System.out.println("DeltaX and DeltaY for redo method");
		System.out.println(deltaX);
		System.out.println(deltaY);
		for(JShape shape: shapeListCopy) {
			shape.move(deltaX, deltaY);
			paintCanvas.repaint();
		}
		
	}
}
	