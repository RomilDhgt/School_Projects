import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author Romil Dhagat
 * This dataframe class is used to read the data of a csv file and then aggregration computations are used 
 */

public class DataFrame {
	
	public String[] headerNames;
	private double[][] data;
	public int numOfRows;
	public int numOfCols;
	
    public DataFrame(String fileName) throws FileNotFoundException {
        
    	File file = new File(fileName); 
    	
        Scanner scanner = new Scanner(file); 
        String row = scanner.nextLine(); 
        
        headerNames = row.split(",");
        numOfCols = headerNames.length;
        data = new double[100][numOfCols];
        numOfRows = 0;
        
        while (scanner.hasNextLine()) { 
            String rows = scanner.nextLine();
            String[] nums = rows.split(",");
            for (int i = 0; i < numOfCols; i++) {
                if (i < nums.length) {
                    data[numOfRows][i] = Double.parseDouble(nums[i]);
                } else {
                    data[numOfRows][i] = 0.0;
                }
            }
            numOfRows++;
        }
        scanner.close();
    }
	
	public String[] getHeaderNames() { 
		return headerNames;
	}
	
	public DataSeries getColumnByIndex(int index) { 
		
		if (index >= 0 && index < numOfCols) {
			String label = headerNames[index];
			double[] nums = new double[numOfRows];
			
			for (int i = 0; i < numOfRows; i++) {
				nums[i] = data[i][index];
			}
			
			return new DataSeries(label, nums);
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	public int getNumOfCols() {
		return numOfCols;
	}
	
	public int getNumOfRows() {
		return numOfRows;
	}
	
	@Override
    public String toString() { 
		
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < Math.min(numOfRows, 10); i++) {
            for (int j = 0; j < numOfCols; j++) {
                sb.append(data[i][j]).append("\t");
            }
            
            sb.append("\n");
        }
        return sb.toString();
    }
}

