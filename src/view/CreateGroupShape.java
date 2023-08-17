package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.util.ArrayList;

import view.gui.PaintCanvas;

public class CreateGroupShape implements IUndoable{
	
	SelectedShapeList selectedShapeList;
	ShapeList shapeList;
	PaintCanvas paintCanvas;
	Graphics graphics;
	 Graphics2D graphics2d = (Graphics2D)graphics;
	boolean groupedOrNot;
	 ArrayList<IShape> temp = new ArrayList<IShape>();
	 ArrayList<IShape> undoTempList = new ArrayList<IShape>();
	 CommandHistory cmd;
	 ArrayList<IShape> createdGroupShapesList = new ArrayList<IShape>();
	 
	public CreateGroupShape(SelectedShapeList selectedShapeList, ShapeList shapeList, PaintCanvas paintCanvas,CommandHistory cmd) {
		this.selectedShapeList = selectedShapeList;
		this.shapeList = shapeList;
		this.paintCanvas = paintCanvas;
		//this.selectShape = selectedShape;
		this.cmd = cmd;
		
	}
	
	public void run() {
		groupedOrNot = true;
		//System.out.println("selectedShapeList size in CreateGroupShape first " + selectedShapeList.getSize());
		for(IShape shape: selectedShapeList) {
			shapeList.removeShape(shape);
//			IShape groupShape = new GroupShape(shape.getStartPoint(), shape.getEndPoint(), shape.getPrimaryColor(),
//					shape.getShapeType(), shape.getSST(), shape.getSecondaryColor());
			//shapeList.addShape(groupShape);
	}	
		GroupShape groupShape = new GroupShape(selectedShapeList, this);
		cmd.add(this);
		//GroupShape groupShape = new GroupShape(groupShapeTempList);
		shapeList.addShape(groupShape);
		createdGroupShapesList.add(groupShape);
		}
	

	@Override
	public void undo() {
		for(IShape shape: shapeList) {
//			System.out.println("GroupSHape startX " + shape.getStartPoint().x);
//	    	System.out.println("GroupSHape starty " + shape.getStartPoint().y);
//	    	System.out.println("GroupSHape endX " + shape.getEndPoint().x);
//	    	System.out.println("GroupSHape endX " + shape.getEndPoint().y);
//	    	System.out.println("GroupSHape height " + shape.getHeight());
//	    	System.out.println("GroupSHape width " + shape.getWidth());
			if(shape instanceof GroupShape) {
				temp.add(shape);
			}
		}
		shapeList.removeAll(temp);
		for(IShape shape: selectedShapeList) {
			shapeList.addShape(shape);
			undoTempList.add(shape);
		//selectedShapeList.removeAll(undoTempList);
	}
		createdGroupShapesList.clear();
		System.out.println("ShapeList size in CreateGroupShape undo " + shapeList.size());
		
	}

	@Override
	public void redo() {
		ArrayList<IShape> redoTemp = new ArrayList<IShape>();
		for(IShape shape: undoTempList) {
			//if(shape instanceof JShape) {
			shapeList.removeShape(shape);
		}
		
		for(IShape shape: temp) {
			//if(shape instanceof GroupShape) {
			//shapeList.addShape(shape);
			redoTemp.add(shape);
			createdGroupShapesList.add(shape);
			
		}
		shapeList.addAll(redoTemp);
		System.out.println("ShapeList size in CreateGroupShape redo " + shapeList.size());
		temp.clear();
	}
        
	}


