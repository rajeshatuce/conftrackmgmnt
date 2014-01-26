package com.conftrackmgmnt.knowledgebase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.conftrackmgmnt.core.model.Confrence;

// TODO: Auto-generated Javadoc
/**
 * The Class ConfrenceScheduler.
 */
public class ConfrenceScheduler {

	/** The is target duration achieved. */
	private Boolean isTargetDurationAchieved;

	/** The permissible time tolerance. */
	private Integer permissibleTimeTolerance;

	/** The conf central. */
	private ConfrenceSchedulerCentral confCentral;

	/**
	 * The Enum ConfrenceSchedulerType.
	 */
	public enum ConfrenceSchedulerType{
		
		/** The morning scheduler. */
		MORNING_SCHEDULER,
/** The afternoon scheduler. */
AFTERNOON_SCHEDULER
	}

	/** The type. */
	private ConfrenceSchedulerType type;
	
	/**
	 * Instantiates a new confrence scheduler.
	 *
	 * @param permissibleTimeTolerance the permissible time tolerance
	 * @param type the type
	 * @param confCentral the conf central
	 */
	public ConfrenceScheduler(Integer permissibleTimeTolerance,ConfrenceSchedulerType type,ConfrenceSchedulerCentral confCentral){
		this.isTargetDurationAchieved=false;
		this.type=type;
		this.permissibleTimeTolerance=permissibleTimeTolerance;
		this.confCentral=confCentral;
	}

	/**
	 * Schedule confrence within target duration.
	 *
	 * @param targetDuration the target duration
	 * @param inputConf the input conf
	 */
	public void scheduleConfrenceWithinTargetDuration(Integer targetDuration,List<Confrence> inputConf){
		isTargetDurationAchieved=false;
		scheduleConfrenceWithinTargetDuration( inputConf,targetDuration, new ArrayList<Confrence>() );
	}

	/**
	 * Schedule confrence within target duration.
	 *
	 * @param numbers the numbers
	 * @param target the target
	 * @param partial the partial
	 */
	private void scheduleConfrenceWithinTargetDuration(List<Confrence> numbers, int target, ArrayList<Confrence> partial){
		   int s = 0;
		   if(isTargetDurationAchieved){
			   return;
		   }
	       for (Confrence x: partial){
	    	   s += x.getConfrenceDuration();
	       }
	       if (s == target){
	    	   isTargetDurationAchieved=true;
	    	   updateAppropriateSessionScheduler(partial);
	    	   return ;
	       }   
	       if (s >= target && (s-target)<=permissibleTimeTolerance){
	    	   isTargetDurationAchieved=true;
	    	   updateAppropriateSessionScheduler(partial);
	    	   return ;
	       }
	            
	       for(int i=0;i<numbers.size();i++) {
	             ArrayList<Confrence> remaining = new ArrayList<Confrence>();
	             int n = numbers.get(i).getConfrenceDuration();
	             for (int j=i+1; j<numbers.size();j++){
	            	 remaining.add(numbers.get(j));
	             }
	             ArrayList<Confrence> partial_rec = new ArrayList<Confrence>(partial);
	             partial_rec.add(numbers.get(i));
	             if(!isTargetDurationAchieved){
	            	 scheduleConfrenceWithinTargetDuration(remaining,target,partial_rec);
	             }
	       }
	}

	/**
	 * Update appropriate session scheduler.
	 *
	 * @param scheduledConf the scheduled conf
	 */
	private void updateAppropriateSessionScheduler(List<Confrence> scheduledConf) {
		if(type.equals(ConfrenceSchedulerType.MORNING_SCHEDULER)){
			confCentral.updateTrackWithMorningSchedule(scheduledConf);
		}else{
			confCentral.updateTrackWithAfterNoonSchedule(scheduledConf);
		}
	}

}
