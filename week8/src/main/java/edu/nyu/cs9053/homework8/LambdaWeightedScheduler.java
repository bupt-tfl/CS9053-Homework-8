package main.java.edu.nyu.cs9053.homework8;

import java.util.*;

public class LambdaWeightedScheduler{
	final LinkedList<WeightedJob> jobs;
	LinkedList<WeightedJob> optimizedJobs;
	
	public LambdaWeightedScheduler(){
		this.jobs = new LinkedList();
		this.optimizedJobs = new LinkedList();
	}

	public void schedule(){ 
		sortJobsByFinishTime();
		optimizedJobs = maxValueSchedule(jobs.size()-1);
		printJobs(optimizedJobs);
	}

	public void printJobs(LinkedList<WeightedJob> jobs){
		Iterator iter = jobs.iterator();
		while(iter.hasNext()){
			WeightedJob next = (WeightedJob) iter.next();
			System.out.printf("job: %.2f - %.2f value: %f%n",next.getStartTime(), next.getFinishTime(),next.getWeight());
		}
		System.out.printf("totalValue: %f",totalValue(jobs));
	}
	
	public LinkedList<WeightedJob> maxValueSchedule(int endIndex){
		
		LinkedList<WeightedJob> nowScheduledJobs = new LinkedList<WeightedJob>();
		if (jobs == null || jobs.size() == 0 || endIndex < 0 || endIndex >= jobs.size()) {
			return nowScheduledJobs;
		}
		if (endIndex == 0) {
			nowScheduledJobs.add(jobs.get(0));
			return nowScheduledJobs;
		}
		LinkedList<WeightedJob> lastScheduledJobs = maxValueSchedule(endIndex - 1);
		WeightedJob endJob = jobs.get(endIndex);
		for (WeightedJob job : lastScheduledJobs) {
			if (job.getFinishTime() < endJob.getStartTime()) {
				nowScheduledJobs.add(job);
			}
		}
		nowScheduledJobs.add(endJob);
		return totalValue(nowScheduledJobs) > totalValue(lastScheduledJobs) ? nowScheduledJobs : lastScheduledJobs;
	}
	
	public void sortJobsByFinishTime(){
		for(int i = 1; i < jobs.size();i++){
			int j = i;
			WeightedJob target = jobs.remove(j);
			while(j>0 && target.getFinishTime() < (jobs.get(j-1)).getFinishTime()){
				j--;
			}
			jobs.add(j, target);
		}
	}
	public double totalValue(List<WeightedJob> jobs){
		double totalValue = 0d;
		Iterator iter = jobs.iterator();
		while(iter.hasNext()){
			WeightedJob next = (WeightedJob) iter.next();
			totalValue += next.getWeight();
		}
		return totalValue;
	}



}
