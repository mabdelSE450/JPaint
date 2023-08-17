package main;



import controller.JPaintController;
import controller.JPaintControllerBuilder;
import model.ShapeColor;
import model.persistence.ApplicationState;
import view.ClickHandler;

import view.CommandHistory;
import view.CopiedShape;
import view.CopiedShapeList;
import view.CreateGroupShape;
import view.CreateShape;
import view.CreateUngroupedShape;
import view.DeleteOrPaste;
import view.DeleteShape;

import view.DeletedShapeRedoStack;
import view.DeletedShapeUndoStack;
import view.GroupShape;
import view.GroupShapeTempList;
import view.JShape;
import view.MoveShape;
import view.PasteShape;
import view.SelectShape;
import view.SelectedShapeList;
import view.ShapeList;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.IUiModule;

public class Main {
    public static void main(String[] args){
    	ShapeList shapeList = new ShapeList();
    	DeleteOrPaste deleteOrPaste = new DeleteOrPaste();
    	SelectedShapeList selectedShapeList = new SelectedShapeList();
    	CopiedShapeList copiedShapeList = new CopiedShapeList();
    	CommandHistory cmd = new CommandHistory();
    	PaintCanvas paintCanvas = PaintCanvas.getInstance();
    	PaintCanvas.setShapeList(shapeList);
    	CreateShape createShape = new CreateShape(paintCanvas, shapeList, cmd);
    	//SelectShape selectShape = new SelectShape(paintCanvas);
    	CopiedShape copiedShape = new CopiedShape(selectedShapeList, copiedShapeList);
    	DeletedShapeUndoStack undoStack = new DeletedShapeUndoStack();
    	DeletedShapeRedoStack redoStack = new DeletedShapeRedoStack();
    	PasteShape pasteShape = new PasteShape(paintCanvas, shapeList, cmd, copiedShapeList, undoStack, deleteOrPaste);
    	DeleteShape deleteShape = new DeleteShape( paintCanvas, selectedShapeList,
    			pasteShape, undoStack, redoStack, shapeList, cmd, deleteOrPaste);
    	GroupShapeTempList groupShapeTempList = new GroupShapeTempList();
    	CreateGroupShape createGroupShape = new CreateGroupShape(selectedShapeList, shapeList, paintCanvas,cmd);
    	CreateUngroupedShape createUngroupedShape = new CreateUngroupedShape(shapeList, paintCanvas, cmd, selectedShapeList);
    	SelectShape selectShape = new SelectShape(paintCanvas, createGroupShape);
    	shapeList.registerObserver(paintCanvas);
        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);
        
         ApplicationState appState = new ApplicationState(uiModule);
         MoveShape moveShape = new MoveShape(paintCanvas, cmd);
         JPaintControllerBuilder builder = new JPaintControllerBuilder();
         builder.setCMD(cmd);
         builder.setCopiedShape(copiedShape);
         builder.setCopiedShapeList(copiedShapeList);
         builder.setDeletedShapeRedOStack(redoStack);
         builder.setDeletedShapeUndoStack(undoStack);
         builder.setDeleteOrPaste(deleteOrPaste);
         builder.setDeleteShape(deleteShape);
         builder.setCreateGroupShape(createGroupShape);
         builder.setCreateUngroupedShape(createUngroupedShape);
         builder.setMoveShape(moveShape);
         //builder.setPaintCanvas(paintCanvas);
         builder.setPasteShape(pasteShape);
         builder.setSelectedShapeList(selectedShapeList);
         builder.setShapeList(shapeList);
         JPaintController jPaint;
         jPaint = builder.getJPaintController(uiModule, appState);
         //new JPaintController(uiModule, appState,  cmd, moveShape, selectedShapeList, pasteShape, 
       //  		copiedShapeList, deleteShape,undoStack, redoStack, deleteOrPaste, shapeList, copiedShape, groupShape);
       paintCanvas.addMouseListener(new ClickHandler(shapeList, paintCanvas, appState, selectedShapeList, undoStack, redoStack,createGroupShape));
        
        
    }
}
