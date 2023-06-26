
/**
 * @author Romil Dhagat
 * Data series implements IBasicSTats to override the abstract methods for the data
 *
 */
public class DataSeries implements IBasicStats{
	
	public String label;
	public double[] data;
	public int count;
	
	
	public DataSeries(String label, double[] data) {
		this.label = label;
		this.data = data;
		this.count = data.length;
	}
	
	public void add(double value) {
		data[count++] = value;
	}
	
	int size() {
		return count;
	}
	
	@Override
	public double getMin() {
		if (count == 0) {
			throw new IllegalStateException("No elements have been added.");
		}
		
		double min = data[0];
		for (int i = 1; i < count; i++) {
			if (data[i] < min) {
				min = data[i];
			}
		}
		return min;
	}
	
	@Override
	public double getMax() {
		if (count == 0) {
			throw new IllegalStateException("No elements have been added.");
		}
		
		double max = data[0];
		for (int i = 1; i < count; i++) {
			if (data[i] > max) {
				max = data[i];
			}
		}
		return max;
	}
	
	@Override
	public double getSum() {
		double sum = 0;
		for (int i = 0; i < count; i++) {
			sum += data[i];
		}
		return sum;
	}
	
	@Override
	public double getMean() {
		if (count == 0) {
			throw new IllegalStateException("No elements have been added.");
		}
		double sum = getSum();
		double mean = sum/count;
		return mean;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(label).append(": ");
		for (int i =0; i < count; i++) {
			sb.append(data[i]);
			if (i < count -1 ) {
				sb.append(" ,");
			}
		}
		return sb.toString();
	}
}

