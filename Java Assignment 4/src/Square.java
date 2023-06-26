
public class Square extends Shape2D{

	public Square() {
		super(1.0,1.0);
	}
	
	public Square(double l) {
		super(l,l);
	}
	
	@Override
	public void setHeight(double l) {
		super.setHeight(l);
		super.setWidth(l);
	}
	
	@Override
	public void setWidth(double l) {
		super.setWidth(l);
		super.setHeight(l);
	}
	
	@Override
	public double getCircumference() {
		return (4 * getHeight());
	}

	@Override
	public double getArea() {
		return (getHeight() * getWidth());
	}
	
}
