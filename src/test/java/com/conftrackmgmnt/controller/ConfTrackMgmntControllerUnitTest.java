package com.conftrackmgmnt.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.conftrackmgmnt.service.ConfTrackMgmntService;

@RunWith(MockitoJUnitRunner.class)
public class ConfTrackMgmntControllerUnitTest {
	@InjectMocks
	ConfTrackMgmntController controller=new ConfTrackMgmntController();
	@Mock
	private static ConfTrackMgmntService service;
	
	@Test
	public void testMain() throws Exception{
		ConfTrackMgmntController.main(null);
		Mockito.verify(service,Mockito.times(1)).scheduleConfrence();
	}

}
