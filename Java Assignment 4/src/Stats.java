/**
 * Implementing the stats class 
 * 
 * @author Romil Dhagat
 * 
 */
public class Stats {

	private int grades[];
	private int count;

	public Stats() {
		grades = new int[100];
		count = 0;
	}

	/**
	 * 
	 * Sorts the first count elements of grades array with Bubble sort.
	 * 
	 * Bubble sort adapted
	 * from 5.2 Try-this: Sorting an array 
	 * in Java, a beginner's guide 9th ed 
	 * 
	 */
	public void sort() {
		int a, b, t;
		for(a=1; a<count; a++) {
			for(b=count-1;b>=a;b--) {
				if(grades[b-1]>grades[b]) {
					t = grades[b-1];
					grades[b-1] = grades[b];
					grades[b] = t;
				}
			}
			
		}
	}
	
	public void add(int grade) {
		grades[count] = grade;
		count++;
	}
	
	public double getMean() {
		double mean  = 0;
		for(int i = 0; i < count; i++) {
			mean += grades[i];
		}
		mean = mean / count; //check if count > 0
		return mean;
	}
	
	/**
	 * Calculates and returns the median of the grades.
	 */
	
	public double getMedian() {
		double median = 0;
		sort();
		
		if(count % 2 == 0) {
			median = (grades[(count / 2) - 1] + grades[count / 2]) / 2;
		} else {
			median = grades[(count/2)];
		}
		return median;	
	}
	
	/**
	 * Returns a string representation of the grades array.
	 */
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		for(int i = 0; i < count; i++) {
			string.append(grades[i]);
			string.append(" ");
		}
		
		String string1 = string.toString();
		return string1;
	}
}
