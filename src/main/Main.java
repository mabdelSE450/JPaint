package main;



import controller.JPaintController;
import model.ShapeColor;
import model.persistence.ApplicationState;
import view.ClickHandler;

import view.CommandHistory;
import view.CopiedShape;
import view.CopiedShapeList;
import view.CreateShape;
import view.DeleteShape;
import view.DeletedShapeList;
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
    	
    	SelectedShapeList selectedShapeList = new SelectedShapeList();
    	CopiedShapeList copiedShapeList = new CopiedShapeList();
    	CommandHistory cmd = new CommandHistory();
    	//PaintCanvas paintCanvas = new PaintCanvas(shapeList);
    	//PaintCanvas.getInstance();
    	PaintCanvas paintCanvas = PaintCanvas.getInstance();
    	PaintCanvas.setShapeList(shapeList);
    	CreateShape createShape = new CreateShape(paintCanvas, shapeList, cmd);
    	SelectShape selectShape = new SelectShape(paintCanvas);
    	CopiedShape copiedShape = new CopiedShape(selectedShapeList, copiedShapeList);
    	DeletedShapeList deletedShapeList = new DeletedShapeList();
    	PasteShape pasteShape = new PasteShape(paintCanvas, shapeList, cmd, copiedShapeList, deletedShapeList);
    	DeleteShape deleteShape = new DeleteShape(shapeList, paintCanvas, selectedShapeList,pasteShape);
    	
    	shapeList.registerObserver(paintCanvas);
        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);
        
         ApplicationState appState = new ApplicationState(uiModule);
         MoveShape moveShape = new MoveShape(paintCanvas);
        new JPaintController(uiModule, appState,  cmd, moveShape, selectedShapeList, pasteShape, copiedShapeList, deleteShape,deletedShapeList);
       paintCanvas.addMouseListener(new ClickHandler(shapeList, paintCanvas, appState, selectedShapeList));
        
        
    }
}
