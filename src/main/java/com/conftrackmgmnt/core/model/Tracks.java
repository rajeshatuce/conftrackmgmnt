package com.conftrackmgmnt.core.model;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class Tracks.
 */
public class Tracks {

	/** The morning session. */
	private List<Confrence> morningSession;
	
	/** The after noon session. */
	private List<Confrence> afterNoonSession;

	/**
	 * Gets the morning session.
	 *
	 * @return the morning session
	 */
	public List<Confrence> getMorningSession() {
		return morningSession;
	}

	/**
	 * Sets the morning session.
	 *
	 * @param morningSession the new morning session
	 */
	public void setMorningSession(List<Confrence> morningSession) {
		this.morningSession = morningSession;
	}

	/**
	 * Gets the after noon session.
	 *
	 * @return the after noon session
	 */
	public List<Confrence> getAfterNoonSession() {
		return afterNoonSession;
	}

	/**
	 * Sets the after noon session.
	 *
	 * @param afterNoonSession the new after noon session
	 */
	public void setAfterNoonSession(List<Confrence> afterNoonSession) {
		this.afterNoonSession = afterNoonSession;
	}
	
	
}
