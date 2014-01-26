package com.conftrackmgmnt.controller;

import com.conftrackmgmnt.service.ConfTrackMgmntService;
import com.conftrackmgmnt.serviceimpl.ConfTrackMgmntServiceImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class ConfTrackMgmntController.
 */
public class ConfTrackMgmntController {
	
	/** The service. */
	private static ConfTrackMgmntService service=new ConfTrackMgmntServiceImpl();;

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws Exception the exception
	 */
	public static void main(String[] args) throws Exception {
		service.scheduleConfrence();

	}

}
