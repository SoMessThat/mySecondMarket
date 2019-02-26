package com.cjw.project.code.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.cjw.project.code.po.CommodityPictureRefPO;
import com.cjw.project.tool.bean.Paged;
import com.cjw.project.tool.bean.Query;
import com.cjw.project.tool.util.ObjectUtil;
import com.cjw.project.tool.web.MysqlDBException; 

@Service("commodityPictureRefService")
public class CommodityPictureRefService extends BaseService<CommodityPictureRefPO>{
	
	Logger log = Logger.getLogger(this.getClass());
	
	/**
	 * 新增对象
	 * @param obj
	 * @throws MysqlDBException
	 */
	public void addCommodityPictureRef(CommodityPictureRefPO obj) throws MysqlDBException{
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
	public void updateCommodityPictureRef(CommodityPictureRefPO obj) throws MysqlDBException{
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
	public void deleteCommodityPictureRefById(String id) throws MysqlDBException{
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
	public void getCommodityPictureRefById(String id) throws MysqlDBException{
		if(ObjectUtil.isEmpty(id)){
			MysqlDBException e = new MysqlDBException("通过主键 查询对象，主键 id 不能为空");
			log.error("通过主键 查询对象，主键 id 不能为空",e);
			throw e;
		}
		this.get(id);
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
	public Paged<CommodityPictureRefPO> queryPageCommodityPictureRef(Integer pageNo,Integer pageSize,
			CommodityPictureRefPO obj) throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("查询条件对象为空 - 异常");
			log.error("查询条件对象为空 - 异常",e);
			throw e;
		}
        Query<CommodityPictureRefPO> q = Query.build(CommodityPictureRefPO.class);
		q.setPaged(pageNo, pageSize);
		
        if(!ObjectUtil.isEmpty(obj.getId()))q.addEq("id", obj.getId()); 
        if(!ObjectUtil.isEmpty(obj.getCommodityId()))q.addEq("commodityId", obj.getCommodityId()); 
        if(!ObjectUtil.isEmpty(obj.getPictureAdress()))q.addEq("pictureAdress", obj.getPictureAdress()); 
        
		//q.addOrder("createtime", DBOrder.DESC);
		Paged<CommodityPictureRefPO> page = this.findPagedByQuery(q);
		return page;
	}
	
	/**
	 * 条件查询  返回列表
	 * @param obj
	 * @return
	 * @throws MysqlDBException
	 */
	@SuppressWarnings("unchecked")
	public List<CommodityPictureRefPO> queryListCommodityPictureRefByParam(CommodityPictureRefPO obj) throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("查询条件对象为空 - 异常");
			log.error("查询条件对象为空 - 异常",e);
			throw e;
		}
        Query<CommodityPictureRefPO> q = Query.build(CommodityPictureRefPO.class);
		
        if(!ObjectUtil.isEmpty(obj.getId()))q.addEq("id", obj.getId()); 
        if(!ObjectUtil.isEmpty(obj.getCommodityId()))q.addEq("commodityId", obj.getCommodityId()); 
        if(!ObjectUtil.isEmpty(obj.getPictureAdress()))q.addEq("pictureAdress", obj.getPictureAdress()); 
		return this.findByQuery(q);
	}
    
    /**
	 * 条件查询  返回对象实体
	 * @param obj
	 * @return
	 * @throws MysqlDBException
	 */
	@SuppressWarnings("unchecked")
	public CommodityPictureRefPO getCommodityPictureRefByParam(CommodityPictureRefPO obj) throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("查询条件对象为空 - 异常");
			log.error("查询条件对象为空 - 异常",e);
			throw e;
		}
        Query<CommodityPictureRefPO> q = Query.build(CommodityPictureRefPO.class);
		
        if(!ObjectUtil.isEmpty(obj.getId()))q.addEq("id", obj.getId()); 
        if(!ObjectUtil.isEmpty(obj.getCommodityId()))q.addEq("commodityId", obj.getCommodityId()); 
        if(!ObjectUtil.isEmpty(obj.getPictureAdress()))q.addEq("pictureAdress", obj.getPictureAdress()); 
		return this.get(q);
	}
	
	/**
	 * 导出excel 数据表
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<String[]> queryCommodityPictureRefForExl(CommodityPictureRefPO obj)throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("查询条件对象为空 - 异常");
			log.error("查询条件对象为空 - 异常",e);
			throw e;
		}
        Query<CommodityPictureRefPO> q = Query.build(CommodityPictureRefPO.class);
		
        if(!ObjectUtil.isEmpty(obj.getId()))q.addEq("id", obj.getId()); 
        if(!ObjectUtil.isEmpty(obj.getCommodityId()))q.addEq("commodityId", obj.getCommodityId()); 
        if(!ObjectUtil.isEmpty(obj.getPictureAdress()))q.addEq("pictureAdress", obj.getPictureAdress()); 
		String[] columnProperty = {"id","commodityId","pictureAdress"};
		return this.findExpByQuery(q, columnProperty);
	}
	
	
	
}

