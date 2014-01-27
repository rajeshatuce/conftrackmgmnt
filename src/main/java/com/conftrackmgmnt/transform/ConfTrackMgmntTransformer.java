package com.conftrackmgmnt.transform;

import java.util.List;

import com.conftrackmgmnt.core.model.Confrence;
import com.conftrackmgmnt.exception.ConfTrackMgmntException;

public interface ConfTrackMgmntTransformer {
	
	List<Confrence> transformToListOfConfrenceObject(List<String> inputList) throws ConfTrackMgmntException; 

}
