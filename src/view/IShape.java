package view;

import java.awt.Graphics2D;

public interface IShape {

		public void draw(Graphics2D graphics2d);
		public void paste();
		public void move(int x, int y);
		public void delete();
}
