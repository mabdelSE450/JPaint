package controller;

import java.util.ArrayList;

import model.interfaces.IApplicationState;
import view.CommandHistory;
import view.CopiedShape;
import view.CopiedShapeList;
import view.DeleteOrPaste;
import view.DeleteShape;

import view.DeletedShapeRedoStack;
import view.DeletedShapeUndoStack;
import view.EventName;
import view.JShape;
import view.MoveShape;
import view.PasteShape;
import view.SelectedShapeList;
import view.ShapeList;
import view.gui.PaintCanvas;
import view.interfaces.IUiModule;

public class JPaintController implements IJPaintController {
    private final IUiModule uiModule;
    private final IApplicationState applicationState;
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
    public JPaintController(IUiModule uiModule, IApplicationState applicationState, CommandHistory cmd, 
    		MoveShape moveShape, SelectedShapeList selectedShapeList, PasteShape pasteShape, 
    		CopiedShapeList copiedShapeList, DeleteShape deleteShape, DeletedShapeUndoStack undoStack, 
    		DeletedShapeRedoStack redoStack, DeleteOrPaste deleteOrPaste, ShapeList shapeList, CopiedShape copiedShape) {
        this.uiModule = uiModule;
        this.applicationState = applicationState;
        this.cmd = cmd;
        this.moveShape = moveShape;
        this.selectedShapeList = selectedShapeList;
        this.pasteShape = pasteShape;
        this.copiedShapeList = copiedShapeList;
        this.deleteShape = deleteShape;
        this.undoStack = undoStack;
        this.redoStack = redoStack;
        this.deleteOrPaste = deleteOrPaste;
        this.shapeList = shapeList;
        this.copiedShape = copiedShape;
       setupEvents();
    }

     

	private void setupEvents() {
        uiModule.addEvent(EventName.CHOOSE_SHAPE, applicationState::setActiveShape);
        uiModule.addEvent(EventName.CHOOSE_PRIMARY_COLOR, applicationState::setActivePrimaryColor);
        uiModule.addEvent(EventName.CHOOSE_SECONDARY_COLOR, applicationState::setActiveSecondaryColor);
        uiModule.addEvent(EventName.CHOOSE_SHADING_TYPE, applicationState::setActiveShadingType);
        uiModule.addEvent(EventName.CHOOSE_MOUSE_MODE, applicationState::setActiveStartAndEndPointMode);
        uiModule.addEvent(EventName.UNDO, this:: undo);
        uiModule.addEvent(EventName.REDO, this::redo);
        uiModule.addEvent(EventName.COPY, this::copy);
        uiModule.addEvent(EventName.PASTE, this::paste);
        uiModule.addEvent(EventName.DELETE, this::delete);
        uiModule.addEvent(EventName.GROUP, this::group);
        uiModule.addEvent(EventName.UNGROUP, this::ungroup);
    }

    private void undo() {
    	if(applicationState.getActiveMouseMode().toString().equals("DRAW")) {
    	cmd.undo();
    	}
    	else if(applicationState.getActiveMouseMode().toString().equals("SELECT")) {
    		if(deleteOrPaste.checkDelete() ==1) {
    			deleteShape.undo();
    		}
    		else {
    	pasteShape.undo();
    		}
    	}
    	else {
    		
    		moveShape.undo();
    	}
    }

    private void redo() {
    	if(applicationState.getActiveMouseMode().toString().equals("DRAW")) {
    	cmd.redo();
    	}
    	else if(applicationState.getActiveMouseMode().toString().equals("SELECT")) {
    		if(deleteOrPaste.checkDelete() ==1) {
    			deleteShape.redo();
    		}
    		else {
       	pasteShape.redo();
    		}
    	}
    	else {
    		moveShape.redo();
    	}
    }

    private void copy() {
    	//CopiedShape copiedShape = new CopiedShape(selectedShapeList, copiedShapeList);
    	
    	copiedShape.run();
    	
    	
    }

    private void paste() {
    	
    	pasteShape.run();
    }

    private void delete() {
    	deleteShape.run();
    	
    }

    private void group() {
    }

    private void ungroup() {
    }
}
