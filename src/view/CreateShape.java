package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import view.gui.PaintCanvas;

public class CreateShape  implements IUndoable {
	PaintCanvas paintCanvas;
	ShapeList shapeList;
	private JShape createdShape;
	//CommandHistory cmd = new CommandHistory();
	CommandHistory cmd;
	
	public CreateShape(PaintCanvas paintCanvas, ShapeList shapeList, CommandHistory cmd) {
		this.paintCanvas = paintCanvas;
		this.shapeList = shapeList;
		this.cmd = cmd;
	}
	
	//PaintCanvas paintCanvas = new PaintCanvas();
	//ShapeList shapelist = new ShapeList(paintCanvas);
	
	//PaintCanvas paintCanvas = new PaintCanvas();
	
	public void run(Point start, Point end) {
		
		JShape shape = new JShape(start, end);
		createdShape = shape;
		cmd.add(this);
		shapeList.addShape(shape);
		//Shape.getRectangle();
		//paintCanvas.repaint();
		//shapeList.removeShape(shape);
		}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		shapeList.removeShape(createdShape);
		//paintCanvas.repaint();
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		shapeList.addShape(createdShape);
		//paintCanvas.repaint();
	}
	}