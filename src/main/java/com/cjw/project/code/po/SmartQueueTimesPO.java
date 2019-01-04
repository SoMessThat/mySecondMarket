package com.cjw.project.code.po;

import java.util.Date;

import com.cjw.project.tool.annotation.Column;
import com.cjw.project.tool.annotation.PrimaryKey;
import com.cjw.project.tool.annotation.Table;

@Table("smart_queue")
//@Table("smart_queue_times")
public class SmartQueueTimesPO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3750727965724443712L;
	/**
	 * 
	 */
	@PrimaryKey("call_id")
//	public String callId;
//	
//	@PrimaryKey("callerno")
	public String callerno;
	
//	@Column("queue_times") 
//	public int queueTimes;
	
	@Column("inhale_time") 
	public int inhaleTime;
	
	@Column("wait_begin") 
	public Date waitbegin;
	
	public Date getWaitbegin() {
		return waitbegin;
	}
	public void setWaitbegin(Date waitbegin) {
		this.waitbegin = waitbegin;
	}
	
//	public String getCallId() {
//		return callId;
//	}
//	public void setCallId(String callId) {
//		this.callId = callId;
//	}
//	public int getQueueTimes() {
//		return queueTimes;
//	}
	public String getCallerno() {
		return callerno;
	}
	public void setCallerno(String callerno) {
		this.callerno = callerno;
	}
//	public void setQueueTimes(int queueTimes) {
//		this.queueTimes = queueTimes;
//	}
	public int getInhaleTime() {
		return inhaleTime;
	}
	public void setInhaleTime(int inhaleTime) {
		this.inhaleTime = inhaleTime;
	}
	
}
