/**
 * Class representing command-line interface to compute 
 * yearly and daily compounded certificate of deposit.
 *  
 * @author Romil Dhagat
 *
 */
import java.text.*;
import java.util.*;
public class BankCDApp {
	
	private BankCD bank;
	private InteractiveCLI cli;
	
	public BankCDApp() {
		
		cli = new InteractiveCLI();
	}
	
	public void run() {
		//TODO: add code here
		double principal;
		double years;
		double rate;
		
		NumberFormat cf = NumberFormat.getCurrencyInstance();
		NumberFormat pf = NumberFormat.getPercentInstance();
		pf.setMaximumFractionDigits(4);
		
		cli.display("************************ OUTPUT ********************\n");
		cli.display("Compare daily and annual compounding for a Bank CD.\n");
		
		cli.prompt("Input CD initial principal, e.g. 1000.55 > ");
		principal = cli.getKeyboardDouble();
		
		cli.prompt("Input CD interest rate, e.g. 6.8 > ");
		rate = cli.getKeyboardDouble();
		
		cli.prompt("Input the number of years to maturity, e.g., 10.5 > ");
		years = cli.getKeyboardDouble();
		
		BankCD bank = new BankCD(principal,rate,years);
		
		rate = rate/100.0;
		
		cli.display("For Principal = " + cf.format(principal) + " Rate = " + pf.format(rate) + " Years = " + years + "\n");
		cli.display("The maturity value compounded yearly is " + cf.format(bank.calcYearly()));
		cli.display("The maturity value compounded daily is " + cf.format(bank.calcDaily()));
		cli.display("************************ OUTPUT ********************\n");
	}

	public static void main(String[] args) {
		
		BankCDApp app = new BankCDApp();
		app.run();
		

	}

}
