package com.conftrackmgmnt.core.model;

// TODO: Auto-generated Javadoc
/**
 * The Class Confrence.
 */
public class Confrence {

	/** The confrence detail. */
	private String confrenceDetail;
	
	/** The confrence duration. */
	private Integer confrenceDuration;

	/**
	 * Gets the confrence detail.
	 *
	 * @return the confrence detail
	 */
	public String getConfrenceDetail() {
		return confrenceDetail;
	}

	/**
	 * Sets the confrence detail.
	 *
	 * @param confrenceDetail the new confrence detail
	 */
	public void setConfrenceDetail(String confrenceDetail) {
		this.confrenceDetail = confrenceDetail;
	}

	/**
	 * Gets the confrence duration.
	 *
	 * @return the confrence duration
	 */
	public Integer getConfrenceDuration() {
		return confrenceDuration;
	}

	/**
	 * Sets the confrence duration.
	 *
	 * @param confrenceDuration the new confrence duration
	 */
	public void setConfrenceDuration(Integer confrenceDuration) {
		this.confrenceDuration = confrenceDuration;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		return confrenceDetail;
	}
}
