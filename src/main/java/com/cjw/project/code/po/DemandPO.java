package com.cjw.project.code.po; 


import java.util.List;

import org.apache.log4j.Logger;

import com.cjw.project.code.vo.MessageVO;
import com.cjw.project.code.vo.UserVO;
import com.cjw.project.tool.annotation.Column;
import com.cjw.project.tool.annotation.Id;
import com.cjw.project.tool.annotation.Table;
import com.cjw.project.tool.annotation.UnColumn;
import com.cjw.project.tool.util.ObjectUtil;



/**
 * TDemandPO
 * Description:
 * @author:wkb
 * @email:842387850@qq.com
 */  
@Table("T_DEMAND")
public class DemandPO implements java.io.Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 5708989869804522779L;


	Logger log = Logger.getLogger(this.getClass());
    
	
	/**  -- id */
    @Id("ID")
	private Integer id;
	
	/**  -- seller_id */
    @Column("SELLER_ID")    
	private String sellerId;
    
    @UnColumn
    private UserVO seller;
	
	/**  -- price */
    @Column("PRICE")    
	private Integer price;
	
	/**  -- name */
    @Column("NAME")    
	private String name;
	
	/**  -- info */
    @Column("INFO")    
	private String info;
	
	/**  -- buyer_id */
    @Column("BUYER_ID")    
	private String buyerId;
	
	/**  -- creart_time */
    @Column("CREART_TIME")    
	private String creartTime;
	
	/**  -- message_id */
    @Column("MESSAGE_ID")    
	private String messageId;
	
    @UnColumn
    private List<MessageVO> messages;
    
	/**  -- state */
    @Column("STATE")    
	private String state;
    
    

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

    public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

    public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

    public String getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}

    public String getCreartTime() {
		return creartTime;
	}

	public void setCreartTime(String creartTime) {
		this.creartTime = creartTime;
	}

    public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

    public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
    
    public UserVO getSeller() {
		return seller;
	}

	public void setSeller(UserVO seller) {
		this.seller = seller;
	}

	public List<MessageVO> getMessages() {
		return messages;
	}

	public void setMessages(List<MessageVO> messages) {
		this.messages = messages;
	}

	@Override
	public String toString() {
		 StringBuffer sb = new StringBuffer();
         if(!ObjectUtil.isEmpty(this.getId()))sb.append("id="+this.id+ " | ");
         if(!ObjectUtil.isEmpty(this.getSellerId()))sb.append("sellerId="+this.sellerId+ " | ");
         if(!ObjectUtil.isEmpty(this.getPrice()))sb.append("price="+this.price+ " | ");
         if(!ObjectUtil.isEmpty(this.getName()))sb.append("name="+this.name+ " | ");
         if(!ObjectUtil.isEmpty(this.getInfo()))sb.append("info="+this.info+ " | ");
         if(!ObjectUtil.isEmpty(this.getBuyerId()))sb.append("buyerId="+this.buyerId+ " | ");
         if(!ObjectUtil.isEmpty(this.getCreartTime()))sb.append("creartTime="+this.creartTime+ " | ");
         if(!ObjectUtil.isEmpty(this.getMessageId()))sb.append("messageId="+this.messageId+ " | ");
         if(!ObjectUtil.isEmpty(this.getState()))sb.append("state="+this.state+ " | ");
		 log.debug(sb.toString());
		 return sb.toString();
	}
	
    
    
}