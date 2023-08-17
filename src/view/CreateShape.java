package view;

import model.ShapeColor;
import model.ShapeType;
import model.persistence.ApplicationState;
import view.gui.PaintCanvas;
import view.interfaces.IUiModule;

public class CreateShape  implements IUndoable {
	//JShape shape;
	PaintCanvas paintCanvas;
	ShapeList shapeList;
	private IShape createdShape;
	CommandHistory cmd;
	private IUiModule uiModule;
	ApplicationState appState = new ApplicationState(uiModule);
	ShapeColor primaryColor;
	IUiModule ui;
	ShapeColor shapeColor;
	ShapeType shapeType;
	
	
public CreateShape(PaintCanvas paintCanvas, ShapeList shapeList, 
			CommandHistory cmd ) {
		this.paintCanvas = paintCanvas;
		this.shapeList = shapeList;
		this.cmd = cmd;
		}

	public void run(PointClass start, PointClass end, ApplicationState appState) {
		if(start.x > end.x && start.y > end.y ) {
			int tempX;
			int tempY;
			tempX = start.x;
			start.x = end.x;
			end.x = tempX;
			tempY = start.y;
			start.y = end.y;
			end.y = tempY;
			}
		else if(start.x < end.x && start.y >= end.y) {
			
			int temp;
			temp = end.y;
			end.y = start.y;
			start.y = temp;
			}
		else if(start.x >= end.x && start.y < end.y) {
			
			int temp;
			temp = start.x;
			start.x = end.x;
			end.x = temp;
			}
	IShape shape = new JShape(start, end , appState.getActivePrimaryColor(), appState.getActiveShapeType(), 
				appState.getActiveShapeShadingType(), appState.getActiveSecondaryColor());
	//System.out.println(shape.startPoint.x);
	//System.out.println(shape.endPoint.x);
		createdShape = shape;
		cmd.add(this);
		shapeList.addShape(shape);
		

		}
	

	@Override
	public void undo() {
		shapeList.removeShape(createdShape);
		//paintCanvas.getInstance().repaint();
		paintCanvas.repaint();
	}

	@Override
	public void redo() {
		shapeList.addShape(createdShape);
		//paintCanvas.getInstance().repaint();
		paintCanvas.repaint();
	}
	}