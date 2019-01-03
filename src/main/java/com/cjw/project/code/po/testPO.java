package com.cjw.project.code.po;

import java.util.Date;

public class testPO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -220618996628292762L;
	public String callerno;
	public Date waitbegin;
	public int devicetype;
	public String getCallerno() {
		return callerno;
	}
	public void setCallerno(String callerno) {
		this.callerno = callerno;
	}
	public Date getWaitbegin() {
		return waitbegin;
	}
	public void setWaitbegin(Date waitbegin) {
		this.waitbegin = waitbegin;
	}
	public int getDevicetype() {
		return devicetype;
	}
	public void setDevicetype(int devicetype) {
		this.devicetype = devicetype;
	}
	
}
