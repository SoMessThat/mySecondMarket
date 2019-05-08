package com.cjw.project.code.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.cjw.project.code.po.SolicitudePO;
import com.cjw.project.tool.bean.Paged;
import com.cjw.project.tool.bean.Query;
import com.cjw.project.tool.util.ObjectUtil;
import com.cjw.project.tool.web.MysqlDBException;


@Service("tSolicitudeService")
public class SolicitudeService extends BaseService<SolicitudePO>{
	
	Logger log = Logger.getLogger(this.getClass());
	
	/**
	 * 新增对象
	 * @param obj
	 * @throws MysqlDBException
	 */
	public void addTSolicitude(SolicitudePO obj) throws MysqlDBException{
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
	public void updateTSolicitude(SolicitudePO obj) throws MysqlDBException{
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
	public void deleteTSolicitudeById(String id) throws MysqlDBException{
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
	public SolicitudePO getTSolicitudeById(String id) throws MysqlDBException{
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
	public Paged<SolicitudePO> queryPageTSolicitude(Integer pageNo,Integer pageSize,
			SolicitudePO obj) throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("查询条件对象为空 - 异常");
			log.error("查询条件对象为空 - 异常",e);
			throw e;
		}
        Query<SolicitudePO> q = Query.build(SolicitudePO.class);
		q.setPaged(pageNo, pageSize);
		
        if(!ObjectUtil.isEmpty(obj.getId()))q.addEq("id", obj.getId()); 
        if(!ObjectUtil.isEmpty(obj.getUserId()))q.addEq("userId", obj.getUserId()); 
        if(!ObjectUtil.isEmpty(obj.getCommodityId()))q.addEq("commodityId", obj.getCommodityId()); 
        if(!ObjectUtil.isEmpty(obj.getCategory()))q.addEq("category", obj.getCategory()); 
        if(!ObjectUtil.isEmpty(obj.getType()))q.addEq("type", obj.getType()); 
        
		//q.addOrder("createtime", DBOrder.DESC);
		Paged<SolicitudePO> page = this.findPagedByQuery(q);
		return page;
	}
	
	/**
	 * 条件查询  返回列表
	 * @param obj
	 * @return
	 * @throws MysqlDBException
	 */
	@SuppressWarnings("unchecked")
	public List<SolicitudePO> queryListTSolicitudeByParam(SolicitudePO obj) throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("查询条件对象为空 - 异常");
			log.error("查询条件对象为空 - 异常",e);
			throw e;
		}
        Query<SolicitudePO> q = Query.build(SolicitudePO.class);
		
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
        if(!ObjectUtil.isEmpty(obj.getUserId()))q.addEq("userId", obj.getUserId()); 
        if(!ObjectUtil.isEmpty(obj.getCommodityId()))q.addEq("commodityId", obj.getCommodityId()); 
        if(!ObjectUtil.isEmpty(obj.getCategory()))q.addEq("category", obj.getCategory()); 
        if(!ObjectUtil.isEmpty(obj.getType()))q.addEq("type", obj.getType()); 
		return this.findByQuery(q);
	}
    
    /**
	 * 条件查询  返回对象实体
	 * @param obj
	 * @return
	 * @throws MysqlDBException
	 */
	@SuppressWarnings("unchecked")
	public SolicitudePO getTSolicitudeByParam(SolicitudePO obj) throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("查询条件对象为空 - 异常");
			log.error("查询条件对象为空 - 异常",e);
			throw e;
		}
        Query<SolicitudePO> q = Query.build(SolicitudePO.class);
		
        if(!ObjectUtil.isEmpty(obj.getId()))q.addEq("id", obj.getId()); 
        if(!ObjectUtil.isEmpty(obj.getUserId()))q.addEq("userId", obj.getUserId()); 
        if(!ObjectUtil.isEmpty(obj.getCommodityId()))q.addEq("commodityId", obj.getCommodityId()); 
        if(!ObjectUtil.isEmpty(obj.getCategory()))q.addEq("category", obj.getCategory()); 
        if(!ObjectUtil.isEmpty(obj.getType()))q.addEq("type", obj.getType()); 
		return this.get(q);
	}
	
	/**
	 * 导出excel 数据表
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<String[]> queryTSolicitudeForExl(SolicitudePO obj)throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("查询条件对象为空 - 异常");
			log.error("查询条件对象为空 - 异常",e);
			throw e;
		}
        Query<SolicitudePO> q = Query.build(SolicitudePO.class);
		
        if(!ObjectUtil.isEmpty(obj.getId()))q.addEq("id", obj.getId()); 
        if(!ObjectUtil.isEmpty(obj.getUserId()))q.addEq("userId", obj.getUserId()); 
        if(!ObjectUtil.isEmpty(obj.getCommodityId()))q.addEq("commodityId", obj.getCommodityId()); 
        if(!ObjectUtil.isEmpty(obj.getCategory()))q.addEq("category", obj.getCategory()); 
        if(!ObjectUtil.isEmpty(obj.getType()))q.addEq("type", obj.getType()); 
		String[] columnProperty = {"id","userId","commodityId","category","type"};
		return this.findExpByQuery(q, columnProperty);
	}
	
	
	
}

