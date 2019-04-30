package com.cjw.project.code.po; 


import org.apache.log4j.Logger;

import com.cjw.project.tool.annotation.Column;
import com.cjw.project.tool.annotation.PrimaryKey;
import com.cjw.project.tool.annotation.Table;
import com.cjw.project.tool.util.ObjectUtil;



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
    @PrimaryKey("ID")
	private String id;
	
	/**  -- owner_id */
    @Column("OWNER_ID")    
	private String ownerId;
	
	/**  -- owner_name */
    @Column("OWNER_NAME")    
	private String ownerName;
	
	/**  -- passersby_id */
    @Column("PASSERSBY_ID")    
	private String passersbyId;
	
	/**  -- answer_id */
    @Column("ANSWER_ID")    
	private String answerId;
	
	/**  -- commodity_id */
    @Column("COMMODITY_ID")    
	private String commodityId;
	
	/**  -- content */
    @Column("CONTENT")    
	private String content;
	
	/**  -- time */
    @Column("TIME")    
	private Long time;
	
	/**  -- passersby_name */
    @Column("PASSERSBY_NAME")    
	private String passersbyName;
    
    private MessagePO message;

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
    
    public MessagePO getMessage() {
		return message;
	}

	public void setMessage(MessagePO message) {
		this.message = message;
	}

	@Override
	public String toString() {
		 StringBuffer sb = new StringBuffer();
         if(!ObjectUtil.isEmpty(this.getId()))sb.append("id="+this.id+ " | ");
         if(!ObjectUtil.isEmpty(this.getOwnerId()))sb.append("ownerId="+this.ownerId+ " | ");
         if(!ObjectUtil.isEmpty(this.getOwnerName()))sb.append("ownerName="+this.ownerName+ " | ");
         if(!ObjectUtil.isEmpty(this.getPassersbyId()))sb.append("passersbyId="+this.passersbyId+ " | ");
         if(!ObjectUtil.isEmpty(this.getAnswerId()))sb.append("answerId="+this.answerId+ " | ");
         if(!ObjectUtil.isEmpty(this.getCommodityId()))sb.append("commodityId="+this.commodityId+ " | ");
         if(!ObjectUtil.isEmpty(this.getContent()))sb.append("content="+this.content+ " | ");
         if(!ObjectUtil.isEmpty(this.getTime()))sb.append("time="+this.time+ " | ");
         if(!ObjectUtil.isEmpty(this.getPassersbyName()))sb.append("passersbyName="+this.passersbyName+ " | ");
		 log.debug(sb.toString());
		 return sb.toString();
	}
	
    
    
}