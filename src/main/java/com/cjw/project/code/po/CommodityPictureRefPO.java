package com.cjw.project.code.po; 


import org.apache.log4j.Logger;

import com.cjw.project.tool.annotation.Column;
import com.cjw.project.tool.annotation.PrimaryKey;
import com.cjw.project.tool.annotation.Table;
import com.cjw.project.tool.util.ObjectUtil;



/**
 * CommodityPictureRefPO
 * Description:
 * @author:WuKaiBin
 * @email:842387850@qq.com
 */  
@Table("COMMODITY_PICTURE_REF")
public class CommodityPictureRefPO implements java.io.Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -1822106207204279304L;


	Logger log = Logger.getLogger(this.getClass());
    
	
	/**
	 * -- cid
	 */
    @PrimaryKey("CID")
	private String cid;
	
	/**
	 * -- commodity_id
	 */
    @Column("COMMODITY_ID")    
	private String commodityId;
	
	/**
	 * -- picture_adress
	 */
    @Column("PICTURE_ADRESS")    
	private String pictureAdress;
    

    public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
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
         if(!ObjectUtil.isEmpty(this.getCid()))sb.append("cid="+this.cid+ " | ");
         if(!ObjectUtil.isEmpty(this.getCommodityId()))sb.append("commodityId="+this.commodityId+ " | ");
         if(!ObjectUtil.isEmpty(this.getPictureAdress()))sb.append("pictureAdress="+this.pictureAdress+ " | ");
		 log.debug(sb.toString());
		 return sb.toString();
	}
	
    
    
}