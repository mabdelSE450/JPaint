package controller;

import java.util.ArrayList;

import model.interfaces.IApplicationState;
import view.CommandHistory;
import view.EventName;
import view.JShape;
import view.MoveShape;
import view.gui.PaintCanvas;
import view.interfaces.IUiModule;

public class JPaintController implements IJPaintController {
    private final IUiModule uiModule;
    private final IApplicationState applicationState;
    CommandHistory cmd;
    PaintCanvas paintCanvas;
    MoveShape moveShape;
    ArrayList<JShape> shapeListCopy;
    
public JPaintController(IUiModule uiModule, IApplicationState applicationState, CommandHistory cmd, MoveShape moveShape) {
        this.uiModule = uiModule;
        this.applicationState = applicationState;
        this.cmd = cmd;
        this.moveShape = moveShape;
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
    	else {
    		moveShape.undo();
    	}
    }

    private void redo() {
    	if(applicationState.getActiveMouseMode().toString().equals("DRAW")) {
    	cmd.redo();
    	}
    	else {
    		moveShape.redo();
    	}
    }

    private void copy() {
    }

    private void paste() {
    }

    private void delete() {
    }

    private void group() {
    }

    private void ungroup() {
    }
}
