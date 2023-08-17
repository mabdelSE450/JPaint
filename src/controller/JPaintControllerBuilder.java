package controller;

import java.util.ArrayList;

import model.interfaces.IApplicationState;
import view.CommandHistory;
import view.CopiedShape;
import view.CopiedShapeList;
import view.CreateGroupShape;
import view.DeleteOrPaste;
import view.DeleteShape;
import view.DeletedShapeRedoStack;
import view.DeletedShapeUndoStack;
import view.GroupShape;
import view.JShape;
import view.MoveShape;
import view.PasteShape;
import view.SelectedShapeList;
import view.ShapeList;
import view.gui.PaintCanvas;
import view.interfaces.IUiModule;

public class JPaintControllerBuilder {

	IUiModule uiModule;
	IApplicationState applicationState;
	CommandHistory cmd;
    PaintCanvas paintCanvas;
    MoveShape moveShape;
    ArrayList<JShape> shapeListCopy;
    SelectedShapeList selectedShapeList = new SelectedShapeList();
    CopiedShapeList copiedShapeList;
    CopiedShape copiedShape;
    ShapeList shapeList;
    PasteShape pasteShape;
    DeleteShape deleteShape;
    DeletedShapeUndoStack undoStack;
    DeletedShapeRedoStack redoStack;
    DeleteOrPaste deleteOrPaste;
    CreateGroupShape createGroupShape;
    

    public JPaintControllerBuilder setCMD(CommandHistory cmd) {
    	this.cmd = cmd;
    	return this;
    }
    
    public JPaintControllerBuilder setCreateGroupShape(CreateGroupShape createGroupShape) {
    	this.createGroupShape = createGroupShape;
    	return this;
    }
    
    public JPaintControllerBuilder setPaintCanvas(PaintCanvas paintCanvas) {
    	this.paintCanvas = paintCanvas;
    	return this;
    }
    public JPaintControllerBuilder setMoveShape(MoveShape moveShape) {
    	this.moveShape = moveShape;
    	return this;
    	
    }
    public JPaintControllerBuilder setSelectedShapeList(SelectedShapeList selectedShapeList) {
    	this.selectedShapeList = selectedShapeList;
    	return this;
    }
    public JPaintControllerBuilder setCopiedShapeList(CopiedShapeList copiedShapeList) {
    	this.copiedShapeList = copiedShapeList;
    	return this;
    }
    public JPaintControllerBuilder setCopiedShape(CopiedShape copiedShape) {
    	this.copiedShape = copiedShape;
    	return this;
    }
    public JPaintControllerBuilder setShapeList(ShapeList shapeList) {
    	this.shapeList = shapeList;
    	return this;
    }
    public JPaintControllerBuilder setPasteShape(PasteShape pasteShape) {
    	this.pasteShape = pasteShape;
    	return this;
    }
    public JPaintControllerBuilder setDeleteShape(DeleteShape deleteShape) {
    	this.deleteShape = deleteShape;
    	return this;
    }
    public JPaintControllerBuilder setDeletedShapeUndoStack(DeletedShapeUndoStack undoStack) {
    	this.undoStack = undoStack;
    	return this;
    }
    public JPaintControllerBuilder setDeletedShapeRedOStack(DeletedShapeRedoStack redoStack) {
    	this.redoStack = redoStack;
    	return this;
    }
    public JPaintControllerBuilder setDeleteOrPaste(DeleteOrPaste deleteOrPaste) {
    	this.deleteOrPaste = deleteOrPaste;
    	return this;
    }
//    public JPaintControllerBuilder setGroupShape(GroupShape groupShape) {
//    	this.groupShape = groupShape;
//    	return this;
    
    public JPaintController getJPaintController(IUiModule uiModule, IApplicationState applicationState ) {
    	//return new JPaintController(uiModule,applicationState,cmd,paintCanvas,moveShape, selectedShapeList,
    		//	copiedShapeList,copiedShape,shapeList,pasteShape,deleteShape,undoStack, redoStack, deleteOrPaste, groupShape)
    	this.uiModule = uiModule;
    	this.applicationState = applicationState;
    	
    	return new JPaintController(uiModule, applicationState,  cmd, moveShape, 
    			selectedShapeList, pasteShape, copiedShapeList, deleteShape, undoStack, 
    			redoStack, deleteOrPaste, shapeList, copiedShape, createGroupShape);
    }
    
}
