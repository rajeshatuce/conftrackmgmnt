package com.conftrackmgmnt.serviceimpl;

import java.util.List;

import com.conftrackmgmnt.core.constant.ConfTrackMgmntConstant;
import com.conftrackmgmnt.core.model.Confrence;
import com.conftrackmgmnt.input.ClasspathResourceLoader;
import com.conftrackmgmnt.input.ResourceLoader;
import com.conftrackmgmnt.knowledgebase.ConfrenceSchedulerCentral;
import com.conftrackmgmnt.service.ConfTrackMgmntService;
import com.conftrackmgmnt.transform.ConfTrackMgmntTransformer;
import com.conftrackmgmnt.transform.ConfTrackMgmntTransformerImpl;
import com.conftrackmgmnt.util.ConfTrackMgmntUtil;


// TODO: Auto-generated Javadoc
/**
 * The Class ConfTrackMgmntServiceImpl.
 */
public class ConfTrackMgmntServiceImpl implements ConfTrackMgmntService {
	
	private ConfrenceSchedulerCentral scheduleCentral=new ConfrenceSchedulerCentral();// Initialize ConfrenceSchedulerCentral job;
	
	private ConfTrackMgmntTransformer transformer=new ConfTrackMgmntTransformerImpl();

	/* (non-Javadoc)
	 * @see com.conftrackmgmnt.service.ConfTrackMgmntService#scheduleConfrence()
	 */
	public void scheduleConfrence() throws Exception{
		ResourceLoader loader=new ClasspathResourceLoader();//1. Initialize Resource Loader
		String filePath=loader.retrieveFilePath(ConfTrackMgmntConstant.INPUT_TXT_FILE);//2. Find the absolute file path
		List<String> inputList=ConfTrackMgmntUtil.readFile(filePath);//3. Load file into List of String
		List<Confrence> inputConfrence=transformer.transformToListOfConfrenceObject(inputList);//4. Transform to more meaningful Confrence object
		scheduleCentral.setCurrentInput(inputConfrence);//5. Set the input to be processed
		scheduleCentral.startScheduling();//6. Start scheduling
	}
}
