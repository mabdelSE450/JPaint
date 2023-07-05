package main;



import controller.JPaintController;
import model.persistence.ApplicationState;
import view.Click_Handler;
import view.CommandHistory;
import view.CreateShape;

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

        new JPaintController(uiModule, appState,  cmd);
        
        paintCanvas.addMouseListener(new Click_Handler(shapeList, paintCanvas));
        
        
    }
}
