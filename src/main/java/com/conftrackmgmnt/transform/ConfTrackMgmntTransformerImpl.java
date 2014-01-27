package com.conftrackmgmnt.transform;

import java.util.ArrayList;
import java.util.List;

import com.conftrackmgmnt.core.model.Confrence;
import com.conftrackmgmnt.exception.ConfTrackMgmntException;
import com.conftrackmgmnt.util.ConfTrackMgmntUtil;

public class ConfTrackMgmntTransformerImpl implements ConfTrackMgmntTransformer {

	public List<Confrence> transformToListOfConfrenceObject(
			List<String> inputList) throws ConfTrackMgmntException {
		List<Confrence> confrenceList=new ArrayList<Confrence>();
		Integer confDuration=null;
		for(String input:inputList){
			confDuration=ConfTrackMgmntUtil.getIntegerFromString(input);
			if(confDuration==null){
				if(input.contains("lightning")){
					confDuration=5;
				}else{
					throw new ConfTrackMgmntException("Invalid confrence input:"+input);
				}
			}
			Confrence confrence=new Confrence();
			confrence.setConfrenceDetail(input);
			confrence.setConfrenceDuration(confDuration);
			confrenceList.add(confrence);
		}
		return confrenceList;
	}

}
