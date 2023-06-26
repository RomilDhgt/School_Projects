
/**
 * A class to test the Days class.
 * 
 * Runs through all the months 1 - 12 and prints the number of days.
 * 
 * @author Romil Dhagat
 *
 */
public class DaysTester {

	public static void main(String[] args) {
		for(int i = 1; i <= 12;i++) {
			System.out.print("The month "+ i + " has " + Days.howManyDaysInMonth(i) + " days \n");
		}

	}

}
