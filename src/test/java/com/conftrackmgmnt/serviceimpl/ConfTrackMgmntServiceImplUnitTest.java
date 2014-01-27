package com.conftrackmgmnt.serviceimpl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.conftrackmgmnt.knowledgebase.ConfrenceSchedulerCentral;

@RunWith(MockitoJUnitRunner.class)
public class ConfTrackMgmntServiceImplUnitTest {
	
	@InjectMocks
	ConfTrackMgmntServiceImpl service=new ConfTrackMgmntServiceImpl();
	
	@Mock
	private ConfrenceSchedulerCentral scheduleCentral;
	
	@Test
	public void testScheduleConfrence() throws Exception{
		service.scheduleConfrence();
		Mockito.verify(scheduleCentral,Mockito.times(1)).startScheduling();
	}

}
