
/**
 * @author Romil Dhagat
 * 
 * This class is used to set up and run the interactiveCLI to prompt and display to the user 
 * for the inputs and outputs of the program.
 *
 */
public class NewtonApp {
	
	private InteractiveCLI cli;
	
	public NewtonApp() {
		
		cli = new InteractiveCLI();
		
	}
	
	public void run() {
		
		double n;
		double guess;
		double error;
		
		cli.display("************************ OUTPUT ********************\n");
		cli.display("Newton's method of calculating square root\n");
		
		cli.prompt("Input the number > ");
		n = cli.getKeyboardDouble();
		
		cli.prompt("Input your initial guess > ");
		guess = cli.getKeyboardDouble();
		
		cli.prompt("Input your maximum error > ");
		error = cli.getKeyboardDouble();
		
		cli.display("The Square Root of " + n + " via newton's method is " + NewtonSolver.sqrt(n,error,guess));
		cli.display("Number of iterations: " + NewtonSolver.count + "\n");
		
		cli.display("************************ OUTPUT ********************\n");
		
	}
	
	public static void main(String[] args) {
		
		NewtonApp app = new NewtonApp();
		app.run();

	}

}
