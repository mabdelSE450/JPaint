package view;

public class BoundingBoxShape implements IPointShape {

	PointClass startPoint;
	PointClass endPoint;
	JShape shape;
	
	
	public BoundingBoxShape(PointClass startPoint, PointClass endPoint) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		//this.shape = shape;
	}
	@Override
	public PointClass getEndPoint() {
		return endPoint;
	}

	@Override
	public PointClass getStartPoint() {
		return startPoint;
	}
	public int getWidth() {
		return Math.abs(this.getEndPoint().x - this.getStartPoint().x);
	}
	
	public int getHeight() {
		return Math.abs(this.getEndPoint().y - this.getStartPoint().y);
	}

}
