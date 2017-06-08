// Author: Varun Rajavelu (G00937282)

// This file contains code to calculate the Mean and standard Deviation
package Student_Survey;

public class DataProcessor {
	// Function to compute the average of the numbers; 
	// It takes in a string and converts it into numbers before calculating
	public float ComputeMean(String numbers_string){
		float result = 0;	// Variable to store the final result
		float sum;			// Variable to store the sum of the numbers
		int totalNum;		// Variable to store the total numbers that the user has entered
		String[] numbers = numbers_string.split(",");	// Split the string into numbers based on a delimiter
		
		totalNum = numbers.length;		// Calculate the total numbers
		
		sum = 0;
		for(int iterator = 0; iterator < totalNum; iterator++)
			sum += Integer.parseInt(numbers[iterator]);			// Calculate the sum of numbers
		
		result = (sum / totalNum);		//  Calculate the Mean of the numbers
		
		return result;
	}
	
	// Function to compute the Standard Deviation of the numbers;
	// It takes in a string and converts it into numbers before calculating
	public double ComputeStandardDeviation(String numbers_string){
		double result = 0; 	// Variable to store the final result
		float mean;			// Variable to store the Mean of the numbers
		float sum;			// Variable to store the sum of the numbers
		double variance; 
		
		mean = ComputeMean(numbers_string);		// Call the Compute Mean
		
		int totalNum;		// Variable to store the total numbers entered by the user
		String[] numbers = numbers_string.split(",");	// Split the string into numbers based on a delimiter
		
		totalNum = numbers.length;		// Calculate the total numbers
		
		sum = 0;
		for(int iterator = 0; iterator < totalNum; iterator++)
			// Get the Sum of square of the difference of the mean
			sum += ((Integer.parseInt(numbers[iterator]) - mean) * (Integer.parseInt(numbers[iterator]) - mean));
		
		variance = (sum / totalNum);	// Calculate the Variance
		result = Math.sqrt(variance);	// Calculate the Standard Deviation
		
		return result;
	}
}
