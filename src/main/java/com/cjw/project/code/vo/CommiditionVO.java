package com.cjw.project.code.vo;

import java.util.List;

import com.cjw.project.code.po.CommodityPictureRefPO;

public class CommiditionVO implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8216569797490762761L;
	private String id;
	private String name;
	private String category;
	private String info;
	private Integer pop;
	private List<CommodityPictureRefPO> picture;
	private Double price;
	private Double secprice;
	private String conditions;
	private String messageId;
	private List<MessageVO> messages;
	private Integer num;
	private String sellerId;
	private UserVO seller;
	private String buyerId;
	private UserVO buyer;
	private Long creartTime;
	private Long closingTime;
	private String state;
	private String pictureId;
	private String comId;
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
	public List<CommodityPictureRefPO> getPicture() {
		return picture;
	}
	public void setPictureId(List<CommodityPictureRefPO> picture) {
		this.picture = picture;
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
	public List<MessageVO> getMessages() {
		return messages;
	}
	public void setMessages(List<MessageVO> messages) {
		this.messages = messages;
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
	public UserVO getBuyer() {
		return buyer;
	}
	public void setBuyer(UserVO buyer) {
		this.buyer = buyer;
	}
	public Long getCreartTime() {
		return creartTime;
	}
	public void setCreartTime(Long creartTime) {
		this.creartTime = creartTime;
	}
	public Long getClosingTime() {
		return closingTime;
	}
	public void setClosingTime(Long closingTime) {
		this.closingTime = closingTime;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPictureId() {
		return pictureId;
	}
	public void setPictureId(String pictureId) {
		this.pictureId = pictureId;
	}
	public void setPicture(List<CommodityPictureRefPO> picture) {
		this.picture = picture;
	}
	public String getComId() {
		return comId;
	}
	public void setComId(String comId) {
		this.comId = comId;
	}
	
}
