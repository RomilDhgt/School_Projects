import java.util.Arrays;

public class TestShapes {

	public static void printShapeInfo(Shape2D s) {
		System.out.println(s);

		System.out.println("area= " + s.getArea());
		System.out.println("circumference= " + s.getCircumference());
	}

	public static void printPointInformation(IShapePoints shape) {
		System.out.println("Reference point: "+shape.getReferencePoint());
		System.out.println("All points: "+Arrays.toString(shape.getAllShapePoints()));
	}
	
	public static void printReferencePointChangeTest(IShapePoints shape) {
		printPointInformation(shape);
		Point2DD p = new Point2DD(5.0, 10.0);
		System.out.println("\nSetting reference point to "+p);
		shape.setReferencePoint(p);
		printPointInformation(shape);
	}
	
	
	public static void printReferencePointGetTest(IShapePoints shape) {
		Point2DD p = shape.getReferencePoint();
		System.out.println("Got point "+p);
		p.x = -10;
		System.out.println("Changed point to "+p);
		System.out.println("Shape reference is "+shape.getReferencePoint());
		System.out.println("Comparing points is "+p.equals(shape.getReferencePoint())+" (should be false)");
	}

	public static void printReferencePointSetTest(IShapePoints shape) {
		Point2DD p = new Point2DD(-1, -1);
		System.out.println("Set reference to point "+p);
		shape.setReferencePoint(p);
		System.out.println("Shape reference is "+shape.getReferencePoint());
		p.x = 1;
		p.y = 1;
		System.out.println("Changed point to "+p);
		System.out.println("Shape reference is "+shape.getReferencePoint());
		System.out.println("Comparing points is "+p.equals(shape.getReferencePoint())+" (should be false)");
	}
	
	public static void printSquareWidthTest(Shape2D s) {
		System.out.println("prior " + s);
		s.setWidth(5);
		System.out.println("after setWidth(5) " + s);
		s.setHeight(10);
		System.out.println("after setHeight(10) " + s);
	}

	public static void main(String[] args) {

		Shape2D[] shapes = { 
				//TODO uncomment once implemented
				new RightTriangle(1.0, 2.0), 
				new Rectangle(1.0, 2.0), 
				//TODO uncomment once implemented
				new Square(2.0) 
				};

		for(Shape2D shape: shapes) {
			System.out.println("\n*** " + shape.getClass().getSimpleName() + " ***");
			printShapeInfo(shape);
		}
		
		//TODO uncomment once implemented
		System.out.println("\n*** Reference point change ***");
		printReferencePointChangeTest(new Rectangle(1.0, 2.0));
		
		System.out.println("\n*** Change get reference point test ***");
		printReferencePointGetTest(new Rectangle(1.0, 2.0));
		
		System.out.println("\n*** Change set reference point test ***");
		printReferencePointSetTest(new Rectangle(1.0, 2.0));

		System.out.println("\n*** Square set width/height test *** ");
		printSquareWidthTest(new Square());

	}

}
