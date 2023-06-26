
/**
 * @author Romil Dhagat 
 *
 * Class name : Temperature
 * 
 * This class Temperature represents a temperature at certain Degrees (in fahrenheit) and 
 * allows for conversion from Fahrenheit to celsius and displays both.
 *
 */
public class Temperature {
	
	double degrees;
	
	public double getCelsius() {
		return (5*(this.degrees - 32) / 9); 
	}
	
	public double getFahrenheit() {
		return this.degrees;
	}
	
	public static void main(String[] args) {
		
		Temperature thermostat1 = new Temperature();
		Temperature thermostat2 = new Temperature();
		
		thermostat1.degrees = 20.0;
		thermostat2.degrees = 98.6;
		
		System.out.println("The temperture of thermostat1 is " + thermostat1.getFahrenheit() + " in Fahrenheit");
		System.out.println("The temperture of thermostat1 is " + String.format("%.2f", thermostat1.getCelsius()) + " in Celsius");
		System.out.println("The temperture of thermostat2 is " + thermostat2.getFahrenheit() + " in Fahrenheit");
		System.out.println("The temperture of thermostat2 is " + thermostat2.getCelsius() + " in Celsius");
				
	}

}
