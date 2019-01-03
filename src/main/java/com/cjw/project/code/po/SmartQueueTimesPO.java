package com.cjw.project.code.po;

import com.cjw.project.tool.annotation.Column;
import com.cjw.project.tool.annotation.PrimaryKey;
import com.cjw.project.tool.annotation.Table;

@Table("smart_queue")
public class SmartQueueTimesPO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3750727965724443712L;
	/**
	 * 
	 */
	@PrimaryKey("call_id")
	public String callId;
	@Column("queue_times") 
	public int queueTimes;
	public String getCallId() {
		return callId;
	}
	public void setCallId(String callId) {
		this.callId = callId;
	}
	public int getQueueTimes() {
		return queueTimes;
	}
	public void setQueueTimes(int queueTimes) {
		this.queueTimes = queueTimes;
	}
	
}
