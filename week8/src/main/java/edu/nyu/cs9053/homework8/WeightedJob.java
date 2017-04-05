package main.java.edu.nyu.cs9053.homework8;

public class WeightedJob extends Job {
	private final double weight;
	
	public WeightedJob(double startTime, double finishTime, double weight){
		super(startTime,finishTime);
		this.weight = weight;
	}
	
	public double getWeight(){
		return this.weight;
	}

}
