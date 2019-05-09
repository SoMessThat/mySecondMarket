package com.cjw.project.code.po; 


import java.util.List;

import org.apache.log4j.Logger;

import com.cjw.project.tool.annotation.Column;
import com.cjw.project.tool.annotation.PrimaryKey;
import com.cjw.project.tool.annotation.Table;
import com.cjw.project.tool.annotation.UnColumn;
import com.cjw.project.tool.util.ObjectUtil;



/**
 * TCommodityPO
 * Description:
 * @author:WuKaiBin
 * @email:842387850@qq.com
 */  
@Table("T_COMMODITY")
public class CommodityPO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4927757202547643759L;


	Logger log = Logger.getLogger(this.getClass());
    
	
	/**  -- id */
    @PrimaryKey("ID")
	private String id;
	
	/**  -- name */
    @Column("NAME")    
	private String name;
	
	/**  -- category */
    @Column("CATEGORY")    
	private String category;
	
	/**  -- info */
    @Column("INFO")    
	private String info;
	
	/**  -- pop */
    @Column("POP")    
	private Integer pop;
	
	/**  -- picture_id */
    @Column("PICTURE_ID")    
	private String pictureId;
	
	/**  -- price */
    @Column("PRICE")    
	private Double price;
	
	/**  -- secprice */
    @Column("SECPRICE")    
	private Double secprice;
	
	/**  -- conditions */
    @Column("CONDITIONS")    
	private String conditions;
	
	/**  -- message_id */
    @Column("MESSAGE_ID")    
	private String messageId;
	
	/**  -- num */
    @Column("NUM")    
	private Integer num;
	
	/**  -- seller_id */
    @Column("SELLER_ID")    
	private String sellerId;
	
	/**  -- buyer_id */
    @Column("BUYER_ID")    
	private String buyerId;
	
	/**  -- creart_time */
    @Column("CREART_TIME")    
	private Long creartTime;
//	// (查询条件 - 开始) 
//	private Long creartTimeBegin;
//    // (查询条件 - 结束)  
//    private Long creartTimeEnd;
    
	
	/**  -- closing_time */
    @Column("CLOSING_TIME")    
	private Long closingTime;
//	// (查询条件 - 开始) 
//	private Long closingTimeBegin;
//    // (查询条件 - 结束)  
//    private Long closingTimeEnd;
    
	
	/**  -- state */
    @Column("STATE")    
	private String state;
    @UnColumn
    private List<CommodityPictureRefPO> pics;
    @UnColumn
    private List<MessagePO> messagess;
    
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
    

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    

    public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
    

    public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
    

    public Integer getPop() {
		return pop;
	}

	public void setPop(Integer pop) {
		this.pop = pop;
	}
    

    public String getPictureId() {
		return pictureId;
	}

	public void setPictureId(String pictureId) {
		this.pictureId = pictureId;
	}
    

    public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
    

    public Double getSecprice() {
		return secprice;
	}

	public void setSecprice(Double secprice) {
		this.secprice = secprice;
	}
    

    public String getConditions() {
		return conditions;
	}

	public void setConditions(String conditions) {
		this.conditions = conditions;
	}
    

    public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
    

    public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}
    

    public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
    

    public String getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}
    

    public Long getCreartTime() {
		return creartTime;
	}

	public void setCreartTime(Long creartTime) {
		this.creartTime = creartTime;
	}
//	public Long getCreartTimeBegin() {
//		return creartTimeBegin;
//	}
//	public void setCreartTimeBegin(Long creartTimeBegin) {
//		this.creartTimeBegin = creartTimeBegin;
//	}
//    public Long getCreartTimeEnd() {
//		return creartTimeEnd;
//	}
//	public void setCreartTimeEnd(Long creartTimeEnd) {
//		this.creartTimeEnd = creartTimeEnd;
//	}
    
    

    public Long getClosingTime() {
		return closingTime;
	}

	public void setClosingTime(Long closingTime) {
		this.closingTime = closingTime;
	}
//	public Long getClosingTimeBegin() {
//		return closingTimeBegin;
//	}
//	public void setClosingTimeBegin(Long closingTimeBegin) {
//		this.closingTimeBegin = closingTimeBegin;
//	}
//    public Long getClosingTimeEnd() {
//		return closingTimeEnd;
//	}
//	public void setClosingTimeEnd(Long closingTimeEnd) {
//		this.closingTimeEnd = closingTimeEnd;
//	}
    
    

    public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
    
    public List<CommodityPictureRefPO> getPics() {
		return pics;
	}

	public void setPics(List<CommodityPictureRefPO> pics) {
		this.pics = pics;
	}
	
	public List<MessagePO> getMessagess() {
		return messagess;
	}

	public void setMessagess(List<MessagePO> messagess) {
		this.messagess = messagess;
	}

	@Override
	public String toString() {
		 StringBuffer sb = new StringBuffer();
         if(!ObjectUtil.isEmpty(this.getId()))sb.append("id="+this.id+ " | ");
         if(!ObjectUtil.isEmpty(this.getName()))sb.append("name="+this.name+ " | ");
         if(!ObjectUtil.isEmpty(this.getCategory()))sb.append("category="+this.category+ " | ");
         if(!ObjectUtil.isEmpty(this.getInfo()))sb.append("info="+this.info+ " | ");
         if(!ObjectUtil.isEmpty(this.getPop()))sb.append("pop="+this.pop+ " | ");
         if(!ObjectUtil.isEmpty(this.getPictureId()))sb.append("pictureId="+this.pictureId+ " | ");
         if(!ObjectUtil.isEmpty(this.getPrice()))sb.append("price="+this.price+ " | ");
         if(!ObjectUtil.isEmpty(this.getSecprice()))sb.append("secprice="+this.secprice+ " | ");
         if(!ObjectUtil.isEmpty(this.getConditions()))sb.append("conditions="+this.conditions+ " | ");
         if(!ObjectUtil.isEmpty(this.getMessageId()))sb.append("messageId="+this.messageId+ " | ");
         if(!ObjectUtil.isEmpty(this.getNum()))sb.append("num="+this.num+ " | ");
         if(!ObjectUtil.isEmpty(this.getSellerId()))sb.append("sellerId="+this.sellerId+ " | ");
         if(!ObjectUtil.isEmpty(this.getBuyerId()))sb.append("buyerId="+this.buyerId+ " | ");
         if(!ObjectUtil.isEmpty(this.getCreartTime()))sb.append("creartTime="+this.creartTime+ " | ");
         if(!ObjectUtil.isEmpty(this.getClosingTime()))sb.append("closingTime="+this.closingTime+ " | ");
         if(!ObjectUtil.isEmpty(this.getState()))sb.append("state="+this.state+ " | ");
		 log.debug(sb.toString());
		 return sb.toString();
	}
	
    
    
}