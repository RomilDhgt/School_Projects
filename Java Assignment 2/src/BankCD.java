/**
 * Class representing a certificate of deposit.
 * 
 * @author Romil Dhagat
 *
 */ 
public class BankCD {
	
	double principal;
	double rate;
	double years;
	
	BankCD(double p, double r, double y){
		this.principal = p;
		this.rate = r;
		this.years = y;
	}
	
	public double calcYearly(){
		return (this.principal * Math.pow(1 + this.rate/100, this.years));
	}
	
	public double calcDaily() {
		return (this.principal * Math.pow(1 + this.rate/36500, 365*this.years));
	}

}
