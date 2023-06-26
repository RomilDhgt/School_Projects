
/**
 * 
 * A class that returns the amount of days in the month by following a certain logic
 * 
 * @author Romil Dhagat
 *
 */
public final class Days {
	
	/**
	 * Days cannot be instantiated, has static methods only.
	 */
	private Days() {}
	
	public static int howManyDaysInMonth(int month) {
		
		
		if(month == 0 || month > 12) {
			return 0;
		} else if(month < 8) {
			if(month % 2 == 0 && month != 2) {
				return 30;
			} else if(month == 2) {
				return 28;
			} else if (month == 0) {
				return 0;
			}else {
				return 31;
			}
		} else {
			if(month % 2 == 0 && month != 2) {
				return 31;
			} else {
				return 30;
			}
		} 
			
	}

}
