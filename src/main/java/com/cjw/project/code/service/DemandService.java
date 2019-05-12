package com.cjw.project.code.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjw.project.code.dao.DemandDAO;
import com.cjw.project.code.po.DemandPO;
import com.cjw.project.tool.bean.Paged;
import com.cjw.project.tool.bean.Query;
import com.cjw.project.tool.util.ObjectUtil;
import com.cjw.project.tool.web.MysqlDBException;


@Service("tDemandService")
public class DemandService extends BaseService<DemandPO>{
	
	Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	DemandDAO demandDAO;
	
	/**
	 * 新增对象
	 * @param obj
	 * @throws MysqlDBException
	 */
	public void addTDemand(DemandPO obj) throws MysqlDBException{
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
	public void updateTDemand(DemandPO obj) throws MysqlDBException{
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
	public void deleteTDemandById(String id) throws MysqlDBException{
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
	public DemandPO getTDemandById(String id) throws MysqlDBException{
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
	public Paged<DemandPO> queryPageTDemand(Integer pageNo,Integer pageSize,
			DemandPO obj) throws MysqlDBException{
        Query<DemandPO> q = Query.build(DemandPO.class);
		q.setPaged(pageNo, pageSize);
		
		List<DemandPO> list = demandDAO.queryPageTDemand(obj);
		Paged<DemandPO> page = new Paged<DemandPO>(list ,list.size() ,pageNo ,pageSize,true);
		return page;
	}
	
	/**
	 * 条件查询  返回列表
	 * @param obj
	 * @return
	 * @throws MysqlDBException
	 */
	@SuppressWarnings("unchecked")
	public List<DemandPO> queryListTDemandByParam(DemandPO obj) throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("查询条件对象为空 - 异常");
			log.error("查询条件对象为空 - 异常",e);
			throw e;
		}
        Query<DemandPO> q = Query.build(DemandPO.class);
		
		//< %foreach(ColumnSchema t1 in SrcTable.Columns){%>
        //< %if(IsDataColumn(t1)){ %>
        //if(!ObjectUtil.isEmpty(obj.< %=getPropertiesXXXname(t1.Name,"get")%>Begin()) && !ObjectUtil.isEmpty(obj.< %=getPropertiesXXXname(t1.Name,"get")%>End())) {
		//	q.addBetween("< %=getPropertiesName(t1.Name)%>", obj.< %=getPropertiesXXXname(t1.Name,"get")%>Begin(), obj.< %=getPropertiesXXXname(t1.Name,"get")%>End());
		//}else{
		//	if(!ObjectUtil.isEmpty(obj.< %=getPropertiesXXXname(t1.Name,"get")%>Begin())) q.addGt("< %=getPropertiesName(t1.Name)%>", obj.< %=getPropertiesXXXname(t1.Name,"get")%>Begin());
		//	if(!ObjectUtil.isEmpty(obj.< %=getPropertiesXXXname(t1.Name,"get")%>End()))   q.addLt("< %=getPropertiesName(t1.Name)%>", obj.< %=getPropertiesXXXname(t1.Name,"get")%>End());
		//}
        //
        //< %}else{%>
        //if(!ObjectUtil.isEmpty(obj.< %=getPropertiesXXXname(t1.Name,"get")%>()))q.addEq("< %=getPropertiesName(t1.Name)%>", obj.< %=getPropertiesXXXname(t1.Name,"get")%>()); 
        //< %}%>
		//< %}%>
        if(!ObjectUtil.isEmpty(obj.getId()))q.addEq("id", obj.getId()); 
        if(!ObjectUtil.isEmpty(obj.getSellerId()))q.addEq("sellerId", obj.getSellerId()); 
        if(!ObjectUtil.isEmpty(obj.getPrice()))q.addEq("price", obj.getPrice()); 
        if(!ObjectUtil.isEmpty(obj.getName()))q.addEq("name", obj.getName()); 
        if(!ObjectUtil.isEmpty(obj.getInfo()))q.addEq("info", obj.getInfo()); 
        if(!ObjectUtil.isEmpty(obj.getBuyerId()))q.addEq("buyerId", obj.getBuyerId()); 
        if(!ObjectUtil.isEmpty(obj.getCreartTime()))q.addEq("creartTime", obj.getCreartTime()); 
        if(!ObjectUtil.isEmpty(obj.getMessageId()))q.addEq("messageId", obj.getMessageId()); 
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
	public DemandPO getTDemandByParam(DemandPO obj) throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("查询条件对象为空 - 异常");
			log.error("查询条件对象为空 - 异常",e);
			throw e;
		}
        Query<DemandPO> q = Query.build(DemandPO.class);
		
        if(!ObjectUtil.isEmpty(obj.getId()))q.addEq("id", obj.getId()); 
        if(!ObjectUtil.isEmpty(obj.getSellerId()))q.addEq("sellerId", obj.getSellerId()); 
        if(!ObjectUtil.isEmpty(obj.getPrice()))q.addEq("price", obj.getPrice()); 
        if(!ObjectUtil.isEmpty(obj.getName()))q.addEq("name", obj.getName()); 
        if(!ObjectUtil.isEmpty(obj.getInfo()))q.addEq("info", obj.getInfo()); 
        if(!ObjectUtil.isEmpty(obj.getBuyerId()))q.addEq("buyerId", obj.getBuyerId()); 
        if(!ObjectUtil.isEmpty(obj.getCreartTime()))q.addEq("creartTime", obj.getCreartTime()); 
        if(!ObjectUtil.isEmpty(obj.getMessageId()))q.addEq("messageId", obj.getMessageId()); 
        if(!ObjectUtil.isEmpty(obj.getState()))q.addEq("state", obj.getState()); 
		return this.get(q);
	}
	
	/**
	 * 导出excel 数据表
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<String[]> queryTDemandForExl(DemandPO obj)throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("查询条件对象为空 - 异常");
			log.error("查询条件对象为空 - 异常",e);
			throw e;
		}
        Query<DemandPO> q = Query.build(DemandPO.class);
		
        if(!ObjectUtil.isEmpty(obj.getId()))q.addEq("id", obj.getId()); 
        if(!ObjectUtil.isEmpty(obj.getSellerId()))q.addEq("sellerId", obj.getSellerId()); 
        if(!ObjectUtil.isEmpty(obj.getPrice()))q.addEq("price", obj.getPrice()); 
        if(!ObjectUtil.isEmpty(obj.getName()))q.addEq("name", obj.getName()); 
        if(!ObjectUtil.isEmpty(obj.getInfo()))q.addEq("info", obj.getInfo()); 
        if(!ObjectUtil.isEmpty(obj.getBuyerId()))q.addEq("buyerId", obj.getBuyerId()); 
        if(!ObjectUtil.isEmpty(obj.getCreartTime()))q.addEq("creartTime", obj.getCreartTime()); 
        if(!ObjectUtil.isEmpty(obj.getMessageId()))q.addEq("messageId", obj.getMessageId()); 
        if(!ObjectUtil.isEmpty(obj.getState()))q.addEq("state", obj.getState()); 
		String[] columnProperty = {"id","sellerId","price","name","info","buyerId","creartTime","messageId","state"};
		return this.findExpByQuery(q, columnProperty);
	}
	
	
	
}

