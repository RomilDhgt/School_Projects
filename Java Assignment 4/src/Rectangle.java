
public class Rectangle extends Shape2D implements IShapePoints{

	private Point2DD point = new Point2DD(0.0,0.0);; 
	
	public Rectangle() {
		super(1.0,  2.0);
		this.point = new Point2DD(0.0,0.0);
	}

	public Rectangle(double w, double h) {
		super(w, h);
		this.point = new Point2DD(point);
	}

	@Override
	public double getCircumference() {
		return 2 * (this.getHeight() + this.getWidth());
	}

	@Override
	public double getArea() {
		return this.getHeight() * this.getWidth();
	}

	@Override
	public Point2DD getReferencePoint() {
		return new Point2DD(point);
	}
	
	@Override
	public void setReferencePoint(Point2DD p) {
		this.point = new Point2DD(p);
	}

	@Override
	public Point2DD[] getAllShapePoints() {
		double x = point.x;
		double y = point.y;
		Point2DD point0 = new Point2DD(point);
		Point2DD point1 = new Point2DD(x + getWidth() , y + getHeight());
		Point2DD point2 = new Point2DD(x , y + getHeight());
		Point2DD point3 = new Point2DD(x + getWidth() , y);
		
		Point2DD[] points = {point,point1,point2,point3};
		
		return points;
	}

}

