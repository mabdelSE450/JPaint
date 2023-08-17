package view;

import java.awt.Graphics2D;
import java.util.ArrayList;

import view.gui.PaintCanvas;

public class CreateUngroupedShape implements IUndoable {

	PaintCanvas paintCanvas;
	ShapeList shapeList;
	SelectShape selectShape;
	SelectedShapeList selectedShapeList;
	ArrayList<IShape> temp = new ArrayList<IShape>();
	ArrayList<IShape> selectedShapeListTemp = new ArrayList<IShape>();
	Graphics2D graphics2d;
	CommandHistory cmd;
	public CreateUngroupedShape(ShapeList shapeList, PaintCanvas paintCanvas, CommandHistory cmd, SelectedShapeList selectedShapeList) {
		this.shapeList = shapeList;
		this.paintCanvas = paintCanvas;
		this.cmd = cmd;
		this.selectedShapeList = selectedShapeList;
		
	}
	
	
	public void run() {
		System.out.println("ShapeList size in CreateUngroupedShape " + shapeList.size());
		 
		for(IShape shape: shapeList) {
			if(shape instanceof GroupShape) {
				temp.add(shape);
			}
		}
		shapeList.removeAll(temp);
		cmd.add(this);
		
		for(IShape shape: selectedShapeList) {
			shapeList.addShape(shape);
			//selectedShapeListTemp.add(shape);
		
			
		}
		
		//selectedShapeList.removeAll(selectedShapeListTemp);
		System.out.println("ShapeList size in CreateUngroupedShape " + shapeList.size());
	}


	@Override
	public void undo() {
		//System.out.println("ShapeList size in CreateUNGroupShape undo " + shapeList.size());
		//System.out.println("SelectedShapeList size in CreateUNGroupShape undo " + selectedShapeList.getSize());
		ArrayList<IShape> undoTempGroupShape = new ArrayList<IShape>();
		for(IShape shape: selectedShapeList) {
			shapeList.removeShape(shape);
		}
		for(IShape shape: temp) {
			undoTempGroupShape.add(shape);
		}
		shapeList.addAll(undoTempGroupShape);
		System.out.println("ShapeList size in CreateUNGroupShape UNDO " + shapeList.size());
	}


	@Override
	public void redo() {
		ArrayList<IShape> redoTempShapes = new ArrayList<IShape>();
		for(IShape shape:temp) {
			shapeList.removeShape(shape);
		}
		for(IShape shape: selectedShapeList) {
			redoTempShapes.add(shape);
		}
		shapeList.addAll(redoTempShapes);
		System.out.println("ShapeList size in CreateUNGroupShape REDO " + shapeList.size());
	}
	
	
}

