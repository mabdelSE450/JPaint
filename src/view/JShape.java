package view;

public class JShape implements IShape{
	
	PointClass endPoint;
	PointClass startPoint;
	
	public JShape(PointClass startPoint, PointClass endPoint  ) {
		this.endPoint = endPoint;
		this.startPoint = startPoint;
	}
	
	public PointClass getStartPoint() {
		return startPoint;
	}
	public PointClass getEndPoint() {
		return endPoint;
	}
	
	
	
	

}
