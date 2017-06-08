// Author: Varun Rajavelu (G00937282)

// This file contains the Setters and Getters for Mean and StandardDeviation
package Student_Survey;

import java.io.Serializable;

public class DataBean implements Serializable {
	private float Mean;
	private double StandardDeviation;
	
	public DataBean(){
	}

	public DataBean(float Mean, double SD){
		this.Mean = Mean;
		this.StandardDeviation = SD;
	}
	
	public float getMean() {
		return Mean;
	}

	public void setMean(float mean) {
		this.Mean = mean;
	}

	public double getStandardDeviation() {
		return StandardDeviation;
	}

	public void setStandardDeviation(double standardDeviation) {
		this.StandardDeviation = standardDeviation;
	}
}
