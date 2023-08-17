package view;

import java.awt.Graphics2D;
import java.util.ArrayList;

public interface IGroupStrategy {

	public void draw(ArrayList<IShape> groupShape, Graphics2D graphics);
}
