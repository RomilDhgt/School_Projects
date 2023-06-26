
/**
 * @author Romil Dhagat
 * This class is used to calculate the square root of a number that is passed into the function
 * by using newtons method of calculating square roots
 *
 */
public class NewtonSolver {
	
	public static int count = 0;
	
	public static double sqrt(double n, double error, double guess) {
		
		double guess2 = 0.0;
		double error2 = guess - guess2;
		
		while(error2 >= error) {
			guess2 = (( n / guess ) + guess) / 2; 
			error2 = Math.abs(guess - guess2);
			guess = guess2;
			count += 1;
		}
		
		return guess;
		
	}
}
