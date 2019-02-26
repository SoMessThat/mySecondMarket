package com.cjw.project.code.po; 

import org.apache.log4j.Logger;

import com.cjw.project.tool.annotation.Column;
import com.cjw.project.tool.annotation.PrimaryKey;
import com.cjw.project.tool.annotation.Table;
import com.cjw.project.tool.util.ObjectUtil;



/**
 * CommodityPictureRefPO
 * Description:
 * @author:ZhengChao
 * @email:zhengchao730@163.com
 */  
@Table("COMMODITY_PICTURE_REF")
public class CommodityPictureRefPO implements java.io.Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 9116521330813183091L;


	Logger log = Logger.getLogger(this.getClass());
    
	
	/**  -- id */
	@PrimaryKey("CID")    
	private String id;
	
	/**  -- commodity_id */
    @Column("COMMODITY_ID")    
	private String commodityId;
	
	/**  -- picture_adress */
    @Column("PICTURE_ADRESS")    
	private String pictureAdress;
    
    

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
    

    public String getPictureAdress() {
		return pictureAdress;
	}

	public void setPictureAdress(String pictureAdress) {
		this.pictureAdress = pictureAdress;
	}
    
    
    
    @Override
	public String toString() {
		 StringBuffer sb = new StringBuffer();
         if(!ObjectUtil.isEmpty(this.getId()))sb.append("id="+this.id+ " | ");
         if(!ObjectUtil.isEmpty(this.getCommodityId()))sb.append("commodityId="+this.commodityId+ " | ");
         if(!ObjectUtil.isEmpty(this.getPictureAdress()))sb.append("pictureAdress="+this.pictureAdress+ " | ");
		 log.debug(sb.toString());
		 return sb.toString();
	}
	
    
    
}