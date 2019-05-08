package com.cjw.project.code.po; 


import org.apache.log4j.Logger;

import com.cjw.project.tool.annotation.Column;
import com.cjw.project.tool.annotation.PrimaryKey;
import com.cjw.project.tool.annotation.Table;
import com.cjw.project.tool.util.ObjectUtil;



/**
 * TSolicitudePO
 * Description:
 * @author:wkb
 * @email:842387850@qq.com
 */  
@Table("T_SOLICITUDE")
public class SolicitudePO implements java.io.Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 2646930209464273681L;


	Logger log = Logger.getLogger(this.getClass());
    
	
	/**  -- id */
    @PrimaryKey("ID")
	private String id;
	
	/**  -- user_id */
    @Column("USER_ID")    
	private String userId;
	
	/**  -- commodity_id */
    @Column("COMMODITY_ID")    
	private String commodityId;
	
	/**  -- category */
    @Column("CATEGORY")    
	private String category;
	
	/**  -- type */
    @Column("TYPE")    
	private String type;
    
    

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

    public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

    public String getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(String commodityId) {
		this.commodityId = commodityId;
	}

    public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

    public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
    
    
    @Override
	public String toString() {
		 StringBuffer sb = new StringBuffer();
         if(!ObjectUtil.isEmpty(this.getId()))sb.append("id="+this.id+ " | ");
         if(!ObjectUtil.isEmpty(this.getUserId()))sb.append("userId="+this.userId+ " | ");
         if(!ObjectUtil.isEmpty(this.getCommodityId()))sb.append("commodityId="+this.commodityId+ " | ");
         if(!ObjectUtil.isEmpty(this.getCategory()))sb.append("category="+this.category+ " | ");
         if(!ObjectUtil.isEmpty(this.getType()))sb.append("type="+this.type+ " | ");
		 log.debug(sb.toString());
		 return sb.toString();
	}
	
    
    
}