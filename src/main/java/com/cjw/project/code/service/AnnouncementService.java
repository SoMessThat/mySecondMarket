package com.cjw.project.code.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.cjw.project.code.po.AnnouncementPO;
import com.cjw.project.tool.bean.Paged;
import com.cjw.project.tool.bean.Query;
import com.cjw.project.tool.util.ObjectUtil;
import com.cjw.project.tool.web.MysqlDBException;


@Service("AnnouncementService")
public class AnnouncementService extends BaseService<AnnouncementPO>{
	
	Logger log = Logger.getLogger(this.getClass());
	
	/**
	 * 新增对象
	 * @param obj
	 * @throws MysqlDBException
	 */
	public void addTAnnouncement(AnnouncementPO obj) throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("新增对象为空");
			log.error("新增对象为空",e);
			throw e;
		}
		this.insert(obj);
	}
	
	/**
	 * 更新单个对象
	 * @param obj
	 * @throws MysqlDBException
	 */
	public void updateTAnnouncement(AnnouncementPO obj) throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("修改对象为空");
			log.error("修改对象为空",e);
			throw e;
		}
		this.update(obj);
	}
	
	/**
	 * 通过主键删除对象
	 * @param id
	 * @throws MysqlDBException 
	 */
	public void deleteTAnnouncementById(String id) throws MysqlDBException{
		if(ObjectUtil.isEmpty(id)){
			MysqlDBException e = new MysqlDBException("通过主键删除对象，主键 id 不能为空");
			log.error("通过主键删除对象，主键 id 不能为空",e);
			throw e;
		}
		this.delete(id);
	}
	
	/**
	 * 通过主键 查询对象
	 * @param id
	 * @throws MysqlDBException
	 */
	public AnnouncementPO getTAnnouncementById(String id) throws MysqlDBException{
		if(ObjectUtil.isEmpty(id)){
			MysqlDBException e = new MysqlDBException("通过主键 查询对象，主键 id 不能为空");
			log.error("通过主键 查询对象，主键 id 不能为空",e);
			throw e;
		}
		return this.get(id);
	}
	
	/**
	 * 条件查询返回分页列表
	 * @param pageNo
	 * @param pageSize
	 * @param obj
	 * @return
	 * @throws MysqlDBException
	 */
	@SuppressWarnings("unchecked")
	public Paged<AnnouncementPO> queryPageTAnnouncement(Integer pageNo,Integer pageSize,
			AnnouncementPO obj) throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("查询条件对象为空 - 异常");
			log.error("查询条件对象为空 - 异常",e);
			throw e;
		}
        Query<AnnouncementPO> q = Query.build(AnnouncementPO.class);
		q.setPaged(pageNo, pageSize);
		
        if(!ObjectUtil.isEmpty(obj.getId()))q.addEq("id", obj.getId()); 
        if(!ObjectUtil.isEmpty(obj.getTitlle()))q.addEq("titlle", obj.getTitlle()); 
        if(!ObjectUtil.isEmpty(obj.getContent()))q.addEq("content", obj.getContent()); 
        if(!ObjectUtil.isEmpty(obj.getPictureId()))q.addEq("pictureId", obj.getPictureId()); 
		if (!ObjectUtil.isEmpty(obj.getCreatTime()))q.addEq("creatTime", obj.getCreatTime());
        
        if(!ObjectUtil.isEmpty(obj.getState()))q.addEq("state", obj.getState()); 
        
		//q.addOrder("createtime", DBOrder.DESC);
		Paged<AnnouncementPO> page = this.findPagedByQuery(q);
		return page;
	}
	
	/**
	 * 条件查询  返回列表
	 * @param obj
	 * @return
	 * @throws MysqlDBException
	 */
	@SuppressWarnings("unchecked")
	public List<AnnouncementPO> queryListTAnnouncementByParam(AnnouncementPO obj) throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("查询条件对象为空 - 异常");
			log.error("查询条件对象为空 - 异常",e);
			throw e;
		}
        Query<AnnouncementPO> q = Query.build(AnnouncementPO.class);
		
        if(!ObjectUtil.isEmpty(obj.getId()))q.addEq("id", obj.getId()); 
        if(!ObjectUtil.isEmpty(obj.getTitlle()))q.addEq("titlle", obj.getTitlle()); 
        if(!ObjectUtil.isEmpty(obj.getContent()))q.addEq("content", obj.getContent()); 
        if(!ObjectUtil.isEmpty(obj.getPictureId()))q.addEq("pictureId", obj.getPictureId()); 
        if (!ObjectUtil.isEmpty(obj.getCreatTime()))q.addEq("creatTime", obj.getCreatTime());
        
        if(!ObjectUtil.isEmpty(obj.getState()))q.addEq("state", obj.getState()); 
		return this.findByQuery(q);
	}
    
    /**
	 * 条件查询  返回对象实体
	 * @param obj
	 * @return
	 * @throws MysqlDBException
	 */
	@SuppressWarnings("unchecked")
	public AnnouncementPO getTAnnouncementByParam(AnnouncementPO obj) throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("查询条件对象为空 - 异常");
			log.error("查询条件对象为空 - 异常",e);
			throw e;
		}
        Query<AnnouncementPO> q = Query.build(AnnouncementPO.class);
		
        if(!ObjectUtil.isEmpty(obj.getId()))q.addEq("id", obj.getId()); 
        if(!ObjectUtil.isEmpty(obj.getTitlle()))q.addEq("titlle", obj.getTitlle()); 
        if(!ObjectUtil.isEmpty(obj.getContent()))q.addEq("content", obj.getContent()); 
        if(!ObjectUtil.isEmpty(obj.getPictureId()))q.addEq("pictureId", obj.getPictureId()); 
        if (!ObjectUtil.isEmpty(obj.getCreatTime()))q.addEq("creatTime", obj.getCreatTime());
        
        if(!ObjectUtil.isEmpty(obj.getState()))q.addEq("state", obj.getState()); 
		return this.get(q);
	}
	
	/**
	 * 导出excel 数据表
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<String[]> queryTAnnouncementForExl(AnnouncementPO obj)throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("查询条件对象为空 - 异常");
			log.error("查询条件对象为空 - 异常",e);
			throw e;
		}
        Query<AnnouncementPO> q = Query.build(AnnouncementPO.class);
		
        if(!ObjectUtil.isEmpty(obj.getId()))q.addEq("id", obj.getId()); 
        if(!ObjectUtil.isEmpty(obj.getTitlle()))q.addEq("titlle", obj.getTitlle()); 
        if(!ObjectUtil.isEmpty(obj.getContent()))q.addEq("content", obj.getContent()); 
        if(!ObjectUtil.isEmpty(obj.getPictureId()))q.addEq("pictureId", obj.getPictureId()); 
        if (!ObjectUtil.isEmpty(obj.getCreatTime()))q.addEq("creatTime", obj.getCreatTime());
        
        if(!ObjectUtil.isEmpty(obj.getState()))q.addEq("state", obj.getState()); 
		String[] columnProperty = {"id","titlle","content","pictureId","creatTime","state"};
		return this.findExpByQuery(q, columnProperty);
	}
	
	
	
}

