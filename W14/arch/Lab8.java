import java.util.ArrayList;
import java.util.Arrays;

public class Lab8 {

	public static void main(String[] args) {
		intArray();
		stringArray();
		arrayList();
	}
	
	public static void intArray() {
		int[] intArray = new int[10000];
		long median= 0;
		long[] timesArray = new long [100];
		long allTimes= 0;
		
		for (int i=0; i<100; i++) {
			//start time to put info in array of 10000
			long startTime = System.nanoTime();	
			for (int j=0; j<intArray.length; j++) {
				intArray[j]=j;
			}
			//end time
			long estimatedTime = System.nanoTime() - startTime;
			allTimes = allTimes + estimatedTime;
			
			//put time in array
			timesArray[i]=estimatedTime;
		}
		
		long mean = allTimes/100;
		
		Arrays.sort(timesArray);
		median = timesArray[50];
		
		long variance = 0;
		//get variance
		for (int i=0; i<100; i++) {
			variance += (long)Math.pow((timesArray[i] - mean), 2);
		}
		
		long standardDev = (long)Math.sqrt(variance/100);
		
		System.out.println("Median time of int array of 10,000: "+ 
				median + " nanoseconds");
		System.out.println("Mean time of int array of 10,000: "+ 
				mean + " nanoseconds");
		System.out.println("Standard deviation of int array of 10,000: "+ 
				standardDev + " nanoseconds");
	        System.out.println();
	}
	
	public static void stringArray() {
		String[] stringArray = new String[10000];
		long median= 0;
		long[] timesArray = new long [100];
		long allTimes = 0;
		
		for (int i=0; i<100; i++) {
			//start time to put info in array of 10000
			long startTime = System.nanoTime();	
			for (int j=0; j<stringArray.length; j++) {
				stringArray[j]="apple " +j;
			}
			//end time
			long estimatedTime = System.nanoTime() - startTime;
			allTimes = allTimes + estimatedTime;
		
			//put time in array
			timesArray[i]=estimatedTime;
		}
		
		Arrays.sort(timesArray);
		median = timesArray[50];
		
		long mean = allTimes/100;
		
		long variance = 0;
		//get variance
		for (int i=0; i<100; i++) {
			variance += (long)Math.pow((timesArray[i] - mean), 2);
		}
		
		long standardDev = (long)Math.sqrt(variance/100);
		
		System.out.println("Median time of String array of 10,000: "+ 
				median + " nanoseconds");
		System.out.println("Mean time of String array of 10,000: "+ 
				mean + " nanoseconds");
		System.out.println("Standard deviation of String array of 10,000: "+ 
				standardDev + " nanoseconds");
		System.out.println();
	}
	
	public static void arrayList() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		long[] timesArray = new long [100];
		long median= 0;
		long allTimes = 0;
		
		for (int i=0; i<100; i++) {
			//start time to put info in array list of 10000
			long startTime = System.nanoTime();
			
			for (int j=0; j<10000; j++) {
				list.add(j);
			}
			//end time
			long estimatedTime = System.nanoTime() - startTime;
			allTimes = allTimes + estimatedTime;

			timesArray[i]=estimatedTime;
		}
		
		Arrays.sort(timesArray);
		median = timesArray[50];
		
		long mean = allTimes/100;
		
		long variance = 0;
		//get variance
		for (int i=0; i<100; i++) {
			variance += (long)Math.pow((timesArray[i] - mean), 2);
		}
		
		long standardDev = (long)Math.sqrt(variance/100);
		
		System.out.println("Median time of array list of 10,000: "+ 
				median + " nanoseconds");
		System.out.println("Mean time of array list of 10,000: "+ 
				mean + " nanoseconds");
		System.out.println("Standard deviation of list array of 10,000: "+ 
				standardDev + " nanoseconds");
	}
}
