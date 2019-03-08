package com.cjw.project.code.vo; 


import org.apache.log4j.Logger;

import com.cjw.project.tool.annotation.Table;



/**
 * TMessagePO
 * Description:
 * @author:WuKaiBin
 * @email:842387850@qq.com
 */  
@Table("T_MESSAGE")
public class MessagePO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2490441853418057421L;


	Logger log = Logger.getLogger(this.getClass());
    
	
	/**  -- id */
	private String id;
	
	/**  -- owner_id */
	private String ownerId;
	
	private UserVO owner;
	
	/**  -- owner_name */
	private String ownerName;
	
	/**  -- passersby_id */
	private String passersbyId;
	
	private UserVO passersby;
	
	/**  -- answer_id */
	private String answerId;
	
	private MessagePO answer;
	
	/**  -- commodity_id */
	private String commodityId;
	
	/**  -- content */
	private String content;
	
	/**  -- time */
	private Long time;
	
	/**  -- passersby_name */
	private String passersbyName;
    
    

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
    

    public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
    

    public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
    

    public String getPassersbyId() {
		return passersbyId;
	}

	public void setPassersbyId(String passersbyId) {
		this.passersbyId = passersbyId;
	}
    

    public String getAnswerId() {
		return answerId;
	}

	public void setAnswerId(String answerId) {
		this.answerId = answerId;
	}
    

    public String getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(String commodityId) {
		this.commodityId = commodityId;
	}
    

    public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
    

    public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}
    

    public String getPassersbyName() {
		return passersbyName;
	}

	public void setPassersbyName(String passersbyName) {
		this.passersbyName = passersbyName;
	}

	public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
	}

	public UserVO getOwner() {
		return owner;
	}

	public void setOwner(UserVO owner) {
		this.owner = owner;
	}

	public UserVO getPassersby() {
		return passersby;
	}

	public void setPassersby(UserVO passersby) {
		this.passersby = passersby;
	}

	public MessagePO getAnswer() {
		return answer;
	}

	public void setAnswer(MessagePO answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "MessagePO [log=" + log + ", id=" + id + ", ownerId=" + ownerId + ", owner=" + owner + ", ownerName="
				+ ownerName + ", passersbyId=" + passersbyId + ", passersby=" + passersby + ", answerId=" + answerId
				+ ", answer=" + answer + ", commodityId=" + commodityId + ", content=" + content + ", time=" + time
				+ ", passersbyName=" + passersbyName + "]";
	}
    
    
}