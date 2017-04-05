package main.java.edu.nyu.cs9053.homework8;

import java.util.*;


public class LambdaScheduler{
	final LinkedList<Job> jobs;
	final LinkedList<Job> scheduledJobs;
	
	public LambdaScheduler(){
		jobs = new LinkedList();
		scheduledJobs = new LinkedList();
	}
	
	public void schedule(){
		maxSizedSchedule();
		printJobs(scheduledJobs);
	}
	
	public void sortJobsByFinishTime(){
		for(int i = 1; i < jobs.size();i++){
			int j = i;
			Job target = jobs.remove(j);
			while(j>0 && target.getFinishTime() < (jobs.get(j-1)).getFinishTime()){
				j--;
			}
			jobs.add(j, target);
		}
	}
	
	public void maxSizedSchedule(){
		sortJobsByFinishTime();
		scheduledJobs.add(jobs.get(0));
		Job lastJob =  jobs.get(0);
		for (Job job : jobs) {
			if (job.getStartTime() > lastJob.getFinishTime()) {
				scheduledJobs.add(job);
				lastJob = job;
			}
		}
	}
	
	public void printJobs(LinkedList<Job> jobs){
		Iterator iter = jobs.iterator();
		while(iter.hasNext()){
			Job next = (Job) iter.next();
			System.out.printf("job: %.2f - %.2f%n",next.getStartTime(), next.getFinishTime());
		}
	}
}
