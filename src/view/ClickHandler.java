package view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import model.MouseMode;
import model.ShapeColor;
import model.persistence.ApplicationState;
import view.gui.PaintCanvas;
import view.interfaces.IUiModule;

public class ClickHandler extends MouseAdapter{
	SelectShape selectShape;
	 PointClass startPoint = new PointClass(0,0);
	 PointClass endPoint = new PointClass(0,0); 
	 SelectedShapeList selectedShapeList = new SelectedShapeList();
	 //SelectedShapeList groupShapeSelectedShapeList = new SelectedShapeList();
	 DeletedShapeUndoStack undoStack;
	DeletedShapeRedoStack redoStack;
	CreateGroupShape createGroupShape; 
	
	PaintCanvas paintCanvas;
	 int width;
	int height;
	ShapeList shapeList;
	CommandHistory cmd;
	IUiModule uiModule;
	 ApplicationState appState = new ApplicationState(uiModule);
	IUiModule ui;
	public ClickHandler(ShapeList shapeList, PaintCanvas paintCanvas,  ApplicationState appState, 
			SelectedShapeList selectedShapeList, DeletedShapeUndoStack undoStack, DeletedShapeRedoStack redoStack, CreateGroupShape createGroupShape) {
		this.shapeList = shapeList;
		this.paintCanvas = paintCanvas;
		this.appState = appState;
		this.selectedShapeList = selectedShapeList;
		this.undoStack = undoStack;
		this.redoStack = redoStack;
		this.createGroupShape = createGroupShape;
		
		
	}
	

	@Override
	public void mousePressed(MouseEvent e) {
		startPoint = new PointClass(e.getX(), e.getY());
		}	
	
	
	@Override
	public void mouseReleased(MouseEvent e) {
		endPoint = new PointClass(e.getX(), e.getY());
		final MouseMode mouseMode;
		mouseMode = appState.getActiveMouseMode();
		switch(mouseMode.toString()) {
		case("DRAW"):
		CreateShape createShape = new CreateShape(paintCanvas, shapeList, cmd);
		createShape.run(startPoint, endPoint, appState);
		//undoStack.clearList();
		//redoStack.clearList();
		
		break;
		case("SELECT"):	
			//System.out.println("SelectedShapeList size in clickHandler " + selectedShapeList.getSize());
		
			ArrayList<IShape> temp = new ArrayList<IShape>();
		SelectShape boundingBoxShape = new SelectShape(paintCanvas);
		boundingBoxShape.run(selectedShapeList,startPoint, endPoint);
		//System.out.println("SelectedShapeList size in clickHandler " + selectedShapeList.getSize());
		//System.out.println("SHapeList size in clickHandler " + shapeList.size());
		//for (JShape shape : shapeList) {
		for(IShape shape: shapeList) {
			
            if (boundingBoxShape.checkCollision(shape)) {
            	temp.add(shape);
            	//undoStack.clearList();
            	//redoStack.clearList();
            	}
            }
		selectedShapeList.addAll(temp);
		//System.out.println("SelectedShapeList size in ClickHandler " + selectedShapeList.getSize());
		//groupShapeSelectedShapeList.addAll(temp);
		
		break;
		case("MOVE"):
			
			MoveShape moveShape = new MoveShape(paintCanvas, cmd);
			moveShape.run(selectedShapeList, startPoint, endPoint);
			break;
			}
	}
}