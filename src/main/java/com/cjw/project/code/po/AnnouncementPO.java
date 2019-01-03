package com.cjw.project.code.po; 


import org.apache.log4j.Logger;

import com.cjw.project.tool.annotation.Column;
import com.cjw.project.tool.annotation.PrimaryKey;
import com.cjw.project.tool.annotation.Table;
import com.cjw.project.tool.util.ObjectUtil;



/**
 * AnnouncementPO
 * Description:
 * @author:WuKaiBin
 * @email:842387850@qq.com
 */  
@Table("T_ANNOUNCEMENT")
public class AnnouncementPO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9177748064496492884L;


	Logger log = Logger.getLogger(this.getClass());
    
	
	/**  -- id */
    @PrimaryKey("ID")
	private String id;
	
	/**  -- titlle */
    @Column("TITLLE")    
	private String titlle;
	
	/**  -- content */
    @Column("CONTENT")    
	private String content;
	
	/**  -- picture_id */
    @Column("PICTURE_ID")    
	private String pictureId;
	
	/**  -- creat_time */
    @Column("CREAT_TIME")    
	private Long creatTime;
	// (查询条件 - 开始) 
	private Long creatTimeBegin;
    // (查询条件 - 结束)  
    private Long creatTimeEnd;
    
	
	/**  -- state */
    @Column("STATE")    
	private String state;
    
    

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
    

    public String getTitlle() {
		return titlle;
	}

	public void setTitlle(String titlle) {
		this.titlle = titlle;
	}
    

    public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
    

    public String getPictureId() {
		return pictureId;
	}

	public void setPictureId(String pictureId) {
		this.pictureId = pictureId;
	}
    

    public Long getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(Long creatTime) {
		this.creatTime = creatTime;
	}
	public Long getCreatTimeBegin() {
		return creatTimeBegin;
	}
	public void setCreatTimeBegin(Long creatTimeBegin) {
		this.creatTimeBegin = creatTimeBegin;
	}
    public Long getCreatTimeEnd() {
		return creatTimeEnd;
	}
	public void setCreatTimeEnd(Long creatTimeEnd) {
		this.creatTimeEnd = creatTimeEnd;
	}
    
    

    public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
    
    
    
    @Override
	public String toString() {
		 StringBuffer sb = new StringBuffer();
         if(!ObjectUtil.isEmpty(this.getId()))sb.append("id="+this.id+ " | ");
         if(!ObjectUtil.isEmpty(this.getTitlle()))sb.append("titlle="+this.titlle+ " | ");
         if(!ObjectUtil.isEmpty(this.getContent()))sb.append("content="+this.content+ " | ");
         if(!ObjectUtil.isEmpty(this.getPictureId()))sb.append("pictureId="+this.pictureId+ " | ");
         if(!ObjectUtil.isEmpty(this.getCreatTime()))sb.append("creatTime="+this.creatTime+ " | ");
         if(!ObjectUtil.isEmpty(this.getState()))sb.append("state="+this.state+ " | ");
		 log.debug(sb.toString());
		 return sb.toString();
	}
	
    
    
}