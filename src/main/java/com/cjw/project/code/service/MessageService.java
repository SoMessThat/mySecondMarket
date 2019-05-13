package com.cjw.project.code.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.cjw.project.code.po.MessagePO;
import com.cjw.project.tool.bean.Paged;
import com.cjw.project.tool.bean.Query;
import com.cjw.project.tool.util.ObjectUtil;
import com.cjw.project.tool.web.MysqlDBException;


@Service("MessageService")
public class MessageService extends BaseService<MessagePO>{
	
	Logger log = Logger.getLogger(this.getClass());
	
	/**
	 * 新增对象
	 * @param obj
	 * @throws MysqlDBException
	 */
	public void addTMessage(MessagePO obj) throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("新增对象为空");
			log.error("新增对象为空",e);
			throw e;
		}
		if(!ObjectUtil.isEmpty(obj.getAnswerId())){
			MessagePO answer = this.getTMessageById(obj.getAnswerId());
			obj.setOwnerId(answer.getPassersbyId());
			obj.setOwnerName(answer.getPassersbyName());
		}
		this.insert(obj);
	}
	
	/**
	 * 更新单个对象
	 * @param obj
	 * @throws MysqlDBException
	 */
	public void updateTMessage(MessagePO obj) throws MysqlDBException{
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
	public void deleteTMessageById(String id) throws MysqlDBException{
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
	public MessagePO getTMessageById(String id) throws MysqlDBException{
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
	public Paged<MessagePO> queryPageTMessage(Integer pageNo,Integer pageSize,
			MessagePO obj) throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("查询条件对象为空 - 异常");
			log.error("查询条件对象为空 - 异常",e);
			throw e;
		}
        Query<MessagePO> q = Query.build(MessagePO.class);
		q.setPaged(pageNo, pageSize);
		
        if(!ObjectUtil.isEmpty(obj.getId()))q.addEq("id", obj.getId()); 
        if(!ObjectUtil.isEmpty(obj.getOwnerId()))q.addEq("ownerId", obj.getOwnerId()); 
        if(!ObjectUtil.isEmpty(obj.getOwnerName()))q.addEq("ownerName", obj.getOwnerName()); 
        if(!ObjectUtil.isEmpty(obj.getPassersbyId()))q.addEq("passersbyId", obj.getPassersbyId()); 
        if(!ObjectUtil.isEmpty(obj.getAnswerId()))q.addEq("answerId", obj.getAnswerId()); 
        if(!ObjectUtil.isEmpty(obj.getCommodityId()))q.addEq("commodityId", obj.getCommodityId()); 
        if(!ObjectUtil.isEmpty(obj.getContent()))q.addEq("content", obj.getContent()); 
        if(!ObjectUtil.isEmpty(obj.getTime()))q.addEq("time", obj.getTime()); 
        if(!ObjectUtil.isEmpty(obj.getPassersbyName()))q.addEq("passersbyName", obj.getPassersbyName()); 
        
		//q.addOrder("createtime", DBOrder.DESC);
		Paged<MessagePO> page = this.findPagedByQuery(q);
		return page;
	}
	
	/**
	 * 条件查询  返回列表
	 * @param obj
	 * @return
	 * @throws MysqlDBException
	 */
	@SuppressWarnings("unchecked")
	public List<MessagePO> queryListTMessageByParam(MessagePO obj) throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("查询条件对象为空 - 异常");
			log.error("查询条件对象为空 - 异常",e);
			throw e;
		}
        Query<MessagePO> q = Query.build(MessagePO.class);
		
        if(!ObjectUtil.isEmpty(obj.getId()))q.addEq("id", obj.getId()); 
        if(!ObjectUtil.isEmpty(obj.getOwnerId()))q.addEq("ownerId", obj.getOwnerId()); 
        if(!ObjectUtil.isEmpty(obj.getOwnerName()))q.addEq("ownerName", obj.getOwnerName()); 
        if(!ObjectUtil.isEmpty(obj.getPassersbyId()))q.addEq("passersbyId", obj.getPassersbyId()); 
        if(!ObjectUtil.isEmpty(obj.getAnswerId()))q.addEq("answerId", obj.getAnswerId()); 
        if(!ObjectUtil.isEmpty(obj.getCommodityId()))q.addEq("commodityId", obj.getCommodityId()); 
        if(!ObjectUtil.isEmpty(obj.getContent()))q.addEq("content", obj.getContent()); 
        if(!ObjectUtil.isEmpty(obj.getTime()))q.addEq("time", obj.getTime()); 
        if(!ObjectUtil.isEmpty(obj.getPassersbyName()))q.addEq("passersbyName", obj.getPassersbyName()); 
		return this.findByQuery(q);
	}
    
    /**
	 * 条件查询  返回对象实体
	 * @param obj
	 * @return
	 * @throws MysqlDBException
	 */
	@SuppressWarnings("unchecked")
	public MessagePO getTMessageByParam(MessagePO obj) throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("查询条件对象为空 - 异常");
			log.error("查询条件对象为空 - 异常",e);
			throw e;
		}
        Query<MessagePO> q = Query.build(MessagePO.class);
		
        if(!ObjectUtil.isEmpty(obj.getId()))q.addEq("id", obj.getId()); 
        if(!ObjectUtil.isEmpty(obj.getOwnerId()))q.addEq("ownerId", obj.getOwnerId()); 
        if(!ObjectUtil.isEmpty(obj.getOwnerName()))q.addEq("ownerName", obj.getOwnerName()); 
        if(!ObjectUtil.isEmpty(obj.getPassersbyId()))q.addEq("passersbyId", obj.getPassersbyId()); 
        if(!ObjectUtil.isEmpty(obj.getAnswerId()))q.addEq("answerId", obj.getAnswerId()); 
        if(!ObjectUtil.isEmpty(obj.getCommodityId()))q.addEq("commodityId", obj.getCommodityId()); 
        if(!ObjectUtil.isEmpty(obj.getContent()))q.addEq("content", obj.getContent()); 
        if(!ObjectUtil.isEmpty(obj.getTime()))q.addEq("time", obj.getTime()); 
        if(!ObjectUtil.isEmpty(obj.getPassersbyName()))q.addEq("passersbyName", obj.getPassersbyName()); 
		return this.get(q);
	}
	
	/**
	 * 导出excel 数据表
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<String[]> queryTMessageForExl(MessagePO obj)throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("查询条件对象为空 - 异常");
			log.error("查询条件对象为空 - 异常",e);
			throw e;
		}
        Query<MessagePO> q = Query.build(MessagePO.class);
		
        if(!ObjectUtil.isEmpty(obj.getId()))q.addEq("id", obj.getId()); 
        if(!ObjectUtil.isEmpty(obj.getOwnerId()))q.addEq("ownerId", obj.getOwnerId()); 
        if(!ObjectUtil.isEmpty(obj.getOwnerName()))q.addEq("ownerName", obj.getOwnerName()); 
        if(!ObjectUtil.isEmpty(obj.getPassersbyId()))q.addEq("passersbyId", obj.getPassersbyId()); 
        if(!ObjectUtil.isEmpty(obj.getAnswerId()))q.addEq("answerId", obj.getAnswerId()); 
        if(!ObjectUtil.isEmpty(obj.getCommodityId()))q.addEq("commodityId", obj.getCommodityId()); 
        if(!ObjectUtil.isEmpty(obj.getContent()))q.addEq("content", obj.getContent()); 
        if(!ObjectUtil.isEmpty(obj.getTime()))q.addEq("time", obj.getTime()); 
        if(!ObjectUtil.isEmpty(obj.getPassersbyName()))q.addEq("passersbyName", obj.getPassersbyName()); 
		String[] columnProperty = {"id","ownerId","ownerName","passersbyId","answerId","commodityId","content","time","passersbyName"};
		return this.findExpByQuery(q, columnProperty);
	}
	
	
	
}

