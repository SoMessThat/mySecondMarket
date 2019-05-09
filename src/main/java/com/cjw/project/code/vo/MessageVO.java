package com.cjw.project.code.vo; 


import java.util.List;



/**
 * TMessagePO
 * Description:
 * @author:WuKaiBin
 * @email:842387850@qq.com
 */  
/**
 * @author Wu
 *
 */
public class MessageVO implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3447892576563515900L;

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
	
	private List<MessageVO> answer;
	
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

	public List<MessageVO> getAnswer() {
		return answer;
	}

	public void setAnswer(List<MessageVO> answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "MessageVO [id=" + id + ", ownerId=" + ownerId + ", owner=" + owner + ", ownerName="
				+ ownerName + ", passersbyId=" + passersbyId + ", passersby=" + passersby + ", answerId=" + answerId
				+ ", answer=" + answer + ", commodityId=" + commodityId + ", content=" + content + ", time=" + time
				+ ", passersbyName=" + passersbyName + "]";
	}

    
}