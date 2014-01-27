package com.conftrackmgmnt.view;

import java.util.Calendar;
import java.util.List;

import com.conftrackmgmnt.core.constant.ConfTrackMgmntConstant;
import com.conftrackmgmnt.core.model.Tracks;
import com.conftrackmgmnt.util.ConfTrackMgmntUtil;

public class ConfTrackMgmntConsoleView implements ConfTrackMgmntView {

	public void displayTrackList(List<Tracks> possibleTracks) {
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
