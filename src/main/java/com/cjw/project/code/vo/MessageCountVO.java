package com.cjw.project.code.vo;

/**
 * TUserPO
 * Description:
 * @author:WuKaiBin
 * @email:842387850@qq.com
 */  
public class MessageCountVO implements java.io.Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 4423566016919874770L;

	private int peopleNum;
	
	private int messageNum;

	public int getPeopleNum() {
		return peopleNum;
	}

	public void setPeopleNum(int peopleNum) {
		this.peopleNum = peopleNum;
	}

	public int getMessageNum() {
		return messageNum;
	}

	public void setMessageNum(int messageNum) {
		this.messageNum = messageNum;
	}
	
    
    
}