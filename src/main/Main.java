package main;



import controller.JPaintController;
import model.ShapeColor;
import model.persistence.ApplicationState;
import view.ClickHandler;

import view.CommandHistory;
import view.CreateShape;
import view.MoveShape;
import view.ShapeList;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.IUiModule;

public class Main {
    public static void main(String[] args){
    	ShapeList shapeList = new ShapeList();
    	CommandHistory cmd = new CommandHistory();
    	PaintCanvas paintCanvas = new PaintCanvas(shapeList);
    	CreateShape createShape = new CreateShape(paintCanvas, shapeList, cmd);
    	shapeList.setPaintCanvas(paintCanvas);
        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);
        
         ApplicationState appState = new ApplicationState(uiModule);
         MoveShape moveShape = new MoveShape(paintCanvas);
        new JPaintController(uiModule, appState,  cmd, moveShape);
        paintCanvas.addMouseListener(new ClickHandler(shapeList, paintCanvas, appState));
        
        
    }
}
