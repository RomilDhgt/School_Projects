
public class RightTriangle extends Shape2D{
	
	public RightTriangle() {
		this(1.0,2.0);
	}
	
	public RightTriangle(double w, double h) {
		super(w,h);
	}

	@Override
	public double getCircumference() {
		return this.getHeight() + this.getWidth() + Math.sqrt(Math.pow(this.getHeight(),2) + Math.pow(this.getWidth(),2)) ;
	}

	@Override
	public double getArea() {
		return (this.getHeight() * this.getWidth()) / 2;
	}
	
	
}
