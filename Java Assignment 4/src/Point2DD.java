

public class Point2DD{
	protected double x, y;
	
	Point2DD(){
		this(0.0, 0.0);
	}
	
	Point2DD(Point2DD p){
		this(p.x, p.y);
	}
	
	Point2DD(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "("+x+", "+y+")";
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == null)return false;
		if(!(o instanceof Point2DD)) return false;
		
		Point2DD that = (Point2DD)o;
		return (this.x == that.x) && (this.y == that.y);
	}
}