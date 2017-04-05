package main.java.edu.nyu.cs9053.homework8;

public class Job {
	private final double startTime;
	private final double finishTime;
	
	public Job(double startTime, double finishTime){
		this.startTime = startTime;
		this.finishTime = finishTime;
	}
	
	public double getStartTime(){
		return this.startTime;
	}
	public double getFinishTime(){
		return this.finishTime;
	}

}
