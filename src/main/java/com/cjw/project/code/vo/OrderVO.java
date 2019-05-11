package com.cjw.project.code.vo;

/**
 * TUserPO
 * Description:
 * @author:WuKaiBin
 * @email:842387850@qq.com
 */  
public class OrderVO implements java.io.Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -5637658707741978337L;


	/**  -- id */
	private String id;
	
	/**  -- commodity_id */
	private String commodityId;
	
	private CommiditionVO commodity;
	
	/**  -- picture_id */
	private String pictureId;
	
	/**  -- price */
	private Double price;
	
	/**  -- num */
	private Integer num;
	
	/**  -- seller_id */
	private String sellerId;
	
	private UserVO seller;
	
	/**  -- buyer_id */
	private String buyerId;
	
	/**  -- creart_time */
	private Long creartTime;
	
	/**  -- pay_time */
	private Long payTime;
	
	/**  -- state */
	private String state;
	
	/**  -- address */
	private String address;
	
	/**  -- is_sign */
	private Integer isSign;
	
	/**  -- is_pay */
	private Integer isPay;
	
	/**  -- logistics_code */
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

	public CommiditionVO getCommodity() {
		return commodity;
	}

	public void setCommodity(CommiditionVO commodity) {
		this.commodity = commodity;
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

	public UserVO getSeller() {
		return seller;
	}

	public void setSeller(UserVO seller) {
		this.seller = seller;
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

}