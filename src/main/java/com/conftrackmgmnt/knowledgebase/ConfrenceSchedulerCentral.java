package com.conftrackmgmnt.knowledgebase;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.conftrackmgmnt.core.constant.ConfTrackMgmntConstant;
import com.conftrackmgmnt.core.model.Confrence;
import com.conftrackmgmnt.core.model.Tracks;
import com.conftrackmgmnt.knowledgebase.ConfrenceScheduler.ConfrenceSchedulerType;
import com.conftrackmgmnt.util.ConfTrackMgmntUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class ConfrenceSchedulerCentral.
 */
public class ConfrenceSchedulerCentral {

	/** The possible tracks. */
	private List<Tracks> possibleTracks;

	/** The morning session scheduler. */
	private ConfrenceScheduler morningSessionScheduler;
	
	/** The afternoon session scheduler. */
	private ConfrenceScheduler afternoonSessionScheduler;
	
	/** The current input. */
	private List<Confrence> currentInput;
	
	/** The current track. */
	private Tracks currentTrack;
	
	/**
	 * Instantiates a new confrence scheduler central.
	 *
	 * @param initialInput the initial input
	 */
	public ConfrenceSchedulerCentral(List<Confrence> initialInput){
		possibleTracks=new ArrayList<Tracks>();
		this.currentInput=initialInput;
	}

	/**
	 * Start scheduling.
	 */
	public void startScheduling(){
		currentTrack=new Tracks();
		morningSessionScheduler=new ConfrenceScheduler(ConfTrackMgmntConstant.MORNING_SESSION_TOLERANCE,ConfrenceSchedulerType.MORNING_SCHEDULER,this);
		morningSessionScheduler.scheduleConfrenceWithinTargetDuration(ConfTrackMgmntConstant.MORNING_SESSION_TARGET_DURATION, currentInput);
	}

	/**
	 * Update track with morning schedule.
	 *
	 * @param morningConfrence the morning confrence
	 */
	public void updateTrackWithMorningSchedule(List<Confrence> morningConfrence){
		currentTrack.setMorningSession(morningConfrence);
		smokeAlreadyScheduledConfrence(morningConfrence);
		if(!currentInput.isEmpty()){//more to go.lets do it in afternoon session
			afternoonSessionScheduler=new ConfrenceScheduler(ConfTrackMgmntConstant.AFTERNOON_SESSION_TOLERANCE,ConfrenceSchedulerType.AFTERNOON_SCHEDULER,this);
			afternoonSessionScheduler.scheduleConfrenceWithinTargetDuration(ConfTrackMgmntConstant.AFTERNOON_SESSION_TARGET_DURATION, currentInput);
		}else{
			//We are done with scheduling
			possibleTracks.add(currentTrack);//add current track to possible track list
			displayTrackList();
		}

	}

	/**
	 * Update track with after noon schedule.
	 *
	 * @param afternoonConfrence the afternoon confrence
	 */
	public void updateTrackWithAfterNoonSchedule(List<Confrence> afternoonConfrence){
		currentTrack.setAfterNoonSession(afternoonConfrence);
		//done for current track. Lets add this in track list
		possibleTracks.add(currentTrack);
		smokeAlreadyScheduledConfrence(afternoonConfrence);
		if(!currentInput.isEmpty()){//more to go.lets do it in morning session of new track
			currentTrack=new Tracks();
			morningSessionScheduler=new ConfrenceScheduler(ConfTrackMgmntConstant.MORNING_SESSION_TOLERANCE,ConfrenceSchedulerType.MORNING_SCHEDULER,this);
			morningSessionScheduler.scheduleConfrenceWithinTargetDuration(ConfTrackMgmntConstant.MORNING_SESSION_TARGET_DURATION, currentInput);
		}else{
			//We are done with scheduling ,since current track already added to track list ,just display the entire tracklist
			displayTrackList();
		}

	}
	
	/**
	 * Smoke already scheduled confrence.
	 *
	 * @param alreadyScheduled the already scheduled
	 */
	private void smokeAlreadyScheduledConfrence(List<Confrence> alreadyScheduled){
		for(Confrence confrence:alreadyScheduled){
			currentInput.remove(confrence);//Done with this confrence
		}
	}

	/**
	 * Display track list.
	 */
	private void displayTrackList(){
		Calendar calendar=Calendar.getInstance();
		for(int i=0;i<possibleTracks.size();i++){
			calendar.set(ConfTrackMgmntConstant.START_YR, ConfTrackMgmntConstant.START_MNTH, ConfTrackMgmntConstant.START_DT, ConfTrackMgmntConstant.START_HR, ConfTrackMgmntConstant.START_MIN);
			System.out.println("Track "+(i+1)+":");
			for(int j=0;j<possibleTracks.get(i).getMorningSession().size();j++){
				System.out.println(ConfTrackMgmntUtil.formatDateTime(calendar)+possibleTracks.get(i).getMorningSession().get(j).getConfrenceDetail());
				calendar.add(Calendar.MINUTE, possibleTracks.get(i).getMorningSession().get(j).getConfrenceDuration());
			}
			System.out.println(ConfTrackMgmntUtil.formatDateTime(calendar)+ConfTrackMgmntConstant.LUNCH_EVENT);
			calendar.add(Calendar.MINUTE,ConfTrackMgmntConstant.LUNCH_TIME);
			for(int j=0;j<possibleTracks.get(i).getAfterNoonSession().size();j++){
				System.out.println(ConfTrackMgmntUtil.formatDateTime(calendar)+possibleTracks.get(i).getAfterNoonSession().get(j).getConfrenceDetail());
				calendar.add(Calendar.MINUTE, possibleTracks.get(i).getAfterNoonSession().get(j).getConfrenceDuration());
			}
			System.out.println(ConfTrackMgmntUtil.formatDateTime(calendar)+ConfTrackMgmntConstant.NETWORKING_EVENT);
			System.out.println(ConfTrackMgmntConstant.NEW_LINE);
		}
	}
	
	

}
