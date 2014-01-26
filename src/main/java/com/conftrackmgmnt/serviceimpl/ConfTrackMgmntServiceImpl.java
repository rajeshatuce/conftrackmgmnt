package com.conftrackmgmnt.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import com.conftrackmgmnt.core.constant.ConfTrackMgmntConstant;
import com.conftrackmgmnt.core.model.Confrence;
import com.conftrackmgmnt.input.ResourceLoader;
import com.conftrackmgmnt.knowledgebase.ConfrenceSchedulerCentral;
import com.conftrackmgmnt.service.ConfTrackMgmntService;
import com.conftrackmgmnt.util.ConfTrackMgmntException;
import com.conftrackmgmnt.util.ConfTrackMgmntUtil;


// TODO: Auto-generated Javadoc
/**
 * The Class ConfTrackMgmntServiceImpl.
 */
public class ConfTrackMgmntServiceImpl implements ConfTrackMgmntService {

	/* (non-Javadoc)
	 * @see com.conftrackmgmnt.service.ConfTrackMgmntService#scheduleConfrence()
	 */
	public void scheduleConfrence() throws Exception{
		ResourceLoader loader=new ResourceLoader();//1. Initialize Resource Loader
		String filePath=loader.retrieveFilePath(ConfTrackMgmntConstant.INPUT_TXT_FILE);//2. Find the absolute file path
		List<String> inputList=ConfTrackMgmntUtil.readFile(filePath);//3. Load file into List of String
		List<Confrence> inputConfrence=transformToListOfConfrenceObject(inputList);//4. Transform to more meaningful Confrence object
		ConfrenceSchedulerCentral scheduleCentral=new ConfrenceSchedulerCentral(inputConfrence);//5. Initialize ConfrenceSchedulerCentral job
		scheduleCentral.startScheduling();//6. Start scheduling
	}
	
	/**
	 * Transform to list of confrence object.
	 *
	 * @param inputList the input list
	 * @return the list
	 * @throws ConfTrackMgmntException the conf track mgmnt exception
	 */
	private List<Confrence> transformToListOfConfrenceObject(List<String> inputList) throws ConfTrackMgmntException {
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
