package view;

public class JShape implements IShape{
	
	Point endPoint;
	Point startPoint;
	
	public JShape(Point startPoint, Point endPoint  ) {
		this.endPoint = endPoint;
		this.startPoint = startPoint;
	}
	
	public Point getStartPoint() {
		return startPoint;
	}
	public Point getEndPoint() {
		return endPoint;
	}
	
	
	
	

}
