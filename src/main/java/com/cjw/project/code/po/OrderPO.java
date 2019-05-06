package com.cjw.project.code.po; 


import org.apache.log4j.Logger;

import com.cjw.project.tool.annotation.Column;
import com.cjw.project.tool.annotation.PrimaryKey;
import com.cjw.project.tool.annotation.Table;
import com.cjw.project.tool.util.ObjectUtil;



/**
 * TOrderPO
 * Description:
 * @author:WuKaiBin
 * @email:842387850@qq.com
 */  
@Table("T_ORDER")
public class OrderPO implements java.io.Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -7956833134006148489L;

	Logger log = Logger.getLogger(this.getClass());
    
	
	/**  -- id */
    @PrimaryKey("ID")
	private String id;
	
	/**  -- commodity_id */
    @Column("COMMODITY_ID")    
	private String commodityId;
	
	/**  -- picture_id */
    @Column("PICTURE_ID")    
	private String pictureId;
	
	/**  -- price */
    @Column("PRICE")    
	private Double price;
	
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
	
	/**  -- pay_time */
    @Column("PAY_TIME")    
	private Long payTime;
	
	/**  -- state */
    @Column("STATE")    
	private String state;
	
	/**  -- address */
    @Column("ADDRESS")    
	private String address;
	
	/**  -- is_sign */
    @Column("IS_SIGN")    
	private Integer isSign;
	
	/**  -- is_pay */
    @Column("IS_PAY")    
	private Integer isPay;
	
	/**  -- logistics_code */
    @Column("LOGISTICS_CODE")    
	private String logisticsCode;
    
    

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
    

    public String getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(String commodityId) {
		this.commodityId = commodityId;
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

    public Long getPayTime() {
		return payTime;
	}

	public void setPayTime(Long payTime) {
		this.payTime = payTime;
	}

    public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
    

    public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
    

    public Integer getIsSign() {
		return isSign;
	}

	public void setIsSign(Integer isSign) {
		this.isSign = isSign;
	}
    

    public Integer getIsPay() {
		return isPay;
	}

	public void setIsPay(Integer isPay) {
		this.isPay = isPay;
	}
    

    public String getLogisticsCode() {
		return logisticsCode;
	}

	public void setLogisticsCode(String logisticsCode) {
		this.logisticsCode = logisticsCode;
	}
    
    
    
    @Override
	public String toString() {
		 StringBuffer sb = new StringBuffer();
         if(!ObjectUtil.isEmpty(this.getId()))sb.append("id="+this.id+ " | ");
         if(!ObjectUtil.isEmpty(this.getCommodityId()))sb.append("commodityId="+this.commodityId+ " | ");
         if(!ObjectUtil.isEmpty(this.getPictureId()))sb.append("pictureId="+this.pictureId+ " | ");
         if(!ObjectUtil.isEmpty(this.getPrice()))sb.append("price="+this.price+ " | ");
         if(!ObjectUtil.isEmpty(this.getNum()))sb.append("num="+this.num+ " | ");
         if(!ObjectUtil.isEmpty(this.getSellerId()))sb.append("sellerId="+this.sellerId+ " | ");
         if(!ObjectUtil.isEmpty(this.getBuyerId()))sb.append("buyerId="+this.buyerId+ " | ");
         if(!ObjectUtil.isEmpty(this.getCreartTime()))sb.append("creartTime="+this.creartTime+ " | ");
         if(!ObjectUtil.isEmpty(this.getPayTime()))sb.append("payTime="+this.payTime+ " | ");
         if(!ObjectUtil.isEmpty(this.getState()))sb.append("state="+this.state+ " | ");
         if(!ObjectUtil.isEmpty(this.getAddress()))sb.append("address="+this.address+ " | ");
         if(!ObjectUtil.isEmpty(this.getIsSign()))sb.append("isSign="+this.isSign+ " | ");
         if(!ObjectUtil.isEmpty(this.getIsPay()))sb.append("isPay="+this.isPay+ " | ");
         if(!ObjectUtil.isEmpty(this.getLogisticsCode()))sb.append("logisticsCode="+this.logisticsCode+ " | ");
		 log.debug(sb.toString());
		 return sb.toString();
	}
	
    
    
}