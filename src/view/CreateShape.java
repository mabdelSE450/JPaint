package view;

import view.gui.PaintCanvas;

public class CreateShape  implements IUndoable {
	PaintCanvas paintCanvas;
	ShapeList shapeList;
	private JShape createdShape;
	CommandHistory cmd;
	
	public CreateShape(PaintCanvas paintCanvas, ShapeList shapeList, CommandHistory cmd) {
		this.paintCanvas = paintCanvas;
		this.shapeList = shapeList;
		this.cmd = cmd;
	}
	
	public void run(PointClass start, PointClass end) {
		
		JShape shape = new JShape(start, end);
		createdShape = shape;
		cmd.add(this);
		shapeList.addShape(shape);
		
		}

	@Override
	public void undo() {
		shapeList.removeShape(createdShape);
		paintCanvas.repaint();
	}

	@Override
	public void redo() {
		shapeList.addShape(createdShape);
		paintCanvas.repaint();
	}
	}