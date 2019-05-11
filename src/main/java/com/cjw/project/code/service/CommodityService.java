package com.cjw.project.code.service;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjw.project.code.dao.CommodityDAO;
import com.cjw.project.code.dao.CommodityPictureRefDAO;
import com.cjw.project.code.po.CommodityPO;
import com.cjw.project.code.po.CommodityPictureRefPO;
import com.cjw.project.code.vo.CommiditionVO;
import com.cjw.project.code.vo.CountCommiditionVO;
import com.cjw.project.code.vo.MessageVO;
import com.cjw.project.tool.bean.Paged;
import com.cjw.project.tool.bean.Query;
import com.cjw.project.tool.util.ObjectUtil;
import com.cjw.project.tool.util.UUIDUtil;
import com.cjw.project.tool.web.MysqlDBException;


@Service("CommodityService")
public class CommodityService extends BaseService<CommodityPO>{
	
	Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	CommodityPictureRefDAO commodityPictureRefDAO;
	@Autowired
	CommodityDAO commodityDAO;
	/**
	 * 新增对象
	 * @param obj
	 * @throws MysqlDBException
	 */
	public void addTCommodity(CommodityPO obj, String address) throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("新增对象为空");
			log.error("新增对象为空",e);
			throw e;
		}
		String a []  = address.split(";");
		for(int i=0;i<a.length;i++){
			CommodityPictureRefPO po = new CommodityPictureRefPO();
			po.setCid(UUIDUtil.getSortUUID());
			po.setCommodityId(obj.getId());
			po.setPictureAdress(a[i]);
			commodityPictureRefDAO.insert(po);
		}
		obj.setPictureId(a[0]);
		this.insert(obj);
	}
	
	/**
	 * 更新单个对象
	 * @param obj
	 * @throws MysqlDBException
	 */
	public void updateTCommodity(CommodityPO obj) throws MysqlDBException{
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
	public void deleteTCommodityById(String id) throws MysqlDBException{
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
	public CommodityPO getTCommodityById(String id) throws MysqlDBException{
		if(ObjectUtil.isEmpty(id)){
			MysqlDBException e = new MysqlDBException("通过主键 查询对象，主键 id 不能为空");
			log.error("通过主键 查询对象，主键 id 不能为空",e);
			throw e;
		}
		commodityDAO.look(id);
		return commodityDAO.getTCommodityById(id);
	}
	
	/**
	 * 条件查询返回分页列表
	 * @param pageNo
	 * @param pageSize
	 * @param map
	 * @return
	 * @throws MysqlDBException
	 */
	public Paged<CommodityPO> queryPageTCommodity(Integer pageNo,Integer pageSize,
			Map<String, String> map) throws MysqlDBException{
		List<CommodityPO> list = commodityDAO.findPagedByQuery(map);
		Paged<CommodityPO> page = new Paged<CommodityPO>(list ,list.size() ,pageNo ,pageSize,true);
		return page;
	}
	
	/**
	 * 条件查询  返回列表
	 * @param obj
	 * @return
	 * @throws MysqlDBException
	 */
	@SuppressWarnings("unchecked")
	public List<CommodityPO> queryListTCommodityByParam(CommodityPO obj) throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("查询条件对象为空 - 异常");
			log.error("查询条件对象为空 - 异常",e);
			throw e;
		}
        Query<CommodityPO> q = Query.build(CommodityPO.class);
		
        if(!ObjectUtil.isEmpty(obj.getId()))q.addEq("id", obj.getId()); 
        if(!ObjectUtil.isEmpty(obj.getName()))q.addEq("name", obj.getName()); 
        if(!ObjectUtil.isEmpty(obj.getCategory()))q.addEq("category", obj.getCategory()); 
        if(!ObjectUtil.isEmpty(obj.getInfo()))q.addEq("info", obj.getInfo()); 
        if(!ObjectUtil.isEmpty(obj.getPop()))q.addEq("pop", obj.getPop()); 
        if(!ObjectUtil.isEmpty(obj.getPictureId()))q.addEq("pictureId", obj.getPictureId()); 
        if(!ObjectUtil.isEmpty(obj.getPrice()))q.addEq("price", obj.getPrice()); 
        if(!ObjectUtil.isEmpty(obj.getSecprice()))q.addEq("secprice", obj.getSecprice()); 
        if(!ObjectUtil.isEmpty(obj.getConditions()))q.addEq("conditions", obj.getConditions()); 
        if(!ObjectUtil.isEmpty(obj.getMessageId()))q.addEq("messageId", obj.getMessageId()); 
        if(!ObjectUtil.isEmpty(obj.getNum()))q.addEq("num", obj.getNum()); 
        if(!ObjectUtil.isEmpty(obj.getSellerId()))q.addEq("sellerId", obj.getSellerId()); 
        if(!ObjectUtil.isEmpty(obj.getBuyerId()))q.addEq("buyerId", obj.getBuyerId()); 
//        if(!ObjectUtil.isEmpty(obj.getCreartTimeBegin()) && !ObjectUtil.isEmpty(obj.getCreartTimeEnd())) {
//			q.addBetween("creartTime", obj.getCreartTimeBegin(), obj.getCreartTimeEnd());
//		}else{
//			if(!ObjectUtil.isEmpty(obj.getCreartTimeBegin())) q.addGt("creartTime", obj.getCreartTimeBegin());
//			if(!ObjectUtil.isEmpty(obj.getCreartTimeEnd()))   q.addLt("creartTime", obj.getCreartTimeEnd());
//		}
//        
//        if(!ObjectUtil.isEmpty(obj.getClosingTimeBegin()) && !ObjectUtil.isEmpty(obj.getClosingTimeEnd())) {
//			q.addBetween("closingTime", obj.getClosingTimeBegin(), obj.getClosingTimeEnd());
//		}else{
//			if(!ObjectUtil.isEmpty(obj.getClosingTimeBegin())) q.addGt("closingTime", obj.getClosingTimeBegin());
//			if(!ObjectUtil.isEmpty(obj.getClosingTimeEnd()))   q.addLt("closingTime", obj.getClosingTimeEnd());
//		}
        
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
	public CommodityPO getTCommodityByParam(CommodityPO obj) throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("查询条件对象为空 - 异常");
			log.error("查询条件对象为空 - 异常",e);
			throw e;
		}
        Query<CommodityPO> q = Query.build(CommodityPO.class);
		
        if(!ObjectUtil.isEmpty(obj.getId()))q.addEq("id", obj.getId()); 
        if(!ObjectUtil.isEmpty(obj.getName()))q.addEq("name", obj.getName()); 
        if(!ObjectUtil.isEmpty(obj.getCategory()))q.addEq("category", obj.getCategory()); 
        if(!ObjectUtil.isEmpty(obj.getInfo()))q.addEq("info", obj.getInfo()); 
        if(!ObjectUtil.isEmpty(obj.getPop()))q.addEq("pop", obj.getPop()); 
        if(!ObjectUtil.isEmpty(obj.getPictureId()))q.addEq("pictureId", obj.getPictureId()); 
        if(!ObjectUtil.isEmpty(obj.getPrice()))q.addEq("price", obj.getPrice()); 
        if(!ObjectUtil.isEmpty(obj.getSecprice()))q.addEq("secprice", obj.getSecprice()); 
        if(!ObjectUtil.isEmpty(obj.getConditions()))q.addEq("conditions", obj.getConditions()); 
        if(!ObjectUtil.isEmpty(obj.getMessageId()))q.addEq("messageId", obj.getMessageId()); 
        if(!ObjectUtil.isEmpty(obj.getNum()))q.addEq("num", obj.getNum()); 
        if(!ObjectUtil.isEmpty(obj.getSellerId()))q.addEq("sellerId", obj.getSellerId()); 
        if(!ObjectUtil.isEmpty(obj.getBuyerId()))q.addEq("buyerId", obj.getBuyerId()); 
//        if(!ObjectUtil.isEmpty(obj.getCreartTimeBegin()) && !ObjectUtil.isEmpty(obj.getCreartTimeEnd())) {
//			q.addBetween("creartTime", obj.getCreartTimeBegin(), obj.getCreartTimeEnd());
//		}else{
//			if(!ObjectUtil.isEmpty(obj.getCreartTimeBegin())) q.addGt("creartTime", obj.getCreartTimeBegin());
//			if(!ObjectUtil.isEmpty(obj.getCreartTimeEnd()))   q.addLt("creartTime", obj.getCreartTimeEnd());
//		}
//        
//        if(!ObjectUtil.isEmpty(obj.getClosingTimeBegin()) && !ObjectUtil.isEmpty(obj.getClosingTimeEnd())) {
//			q.addBetween("closingTime", obj.getClosingTimeBegin(), obj.getClosingTimeEnd());
//		}else{
//			if(!ObjectUtil.isEmpty(obj.getClosingTimeBegin())) q.addGt("closingTime", obj.getClosingTimeBegin());
//			if(!ObjectUtil.isEmpty(obj.getClosingTimeEnd()))   q.addLt("closingTime", obj.getClosingTimeEnd());
//		}
        
        if(!ObjectUtil.isEmpty(obj.getState()))q.addEq("state", obj.getState()); 
		return this.get(q);
	}
	
	/**
	 * 导出excel 数据表
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<String[]> queryTCommodityForExl(CommodityPO obj)throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("查询条件对象为空 - 异常");
			log.error("查询条件对象为空 - 异常",e);
			throw e;
		}
        Query<CommodityPO> q = Query.build(CommodityPO.class);
		
        if(!ObjectUtil.isEmpty(obj.getId()))q.addEq("id", obj.getId()); 
        if(!ObjectUtil.isEmpty(obj.getName()))q.addEq("name", obj.getName()); 
        if(!ObjectUtil.isEmpty(obj.getCategory()))q.addEq("category", obj.getCategory()); 
        if(!ObjectUtil.isEmpty(obj.getInfo()))q.addEq("info", obj.getInfo()); 
        if(!ObjectUtil.isEmpty(obj.getPop()))q.addEq("pop", obj.getPop()); 
        if(!ObjectUtil.isEmpty(obj.getPictureId()))q.addEq("pictureId", obj.getPictureId()); 
        if(!ObjectUtil.isEmpty(obj.getPrice()))q.addEq("price", obj.getPrice()); 
        if(!ObjectUtil.isEmpty(obj.getSecprice()))q.addEq("secprice", obj.getSecprice()); 
        if(!ObjectUtil.isEmpty(obj.getConditions()))q.addEq("conditions", obj.getConditions()); 
        if(!ObjectUtil.isEmpty(obj.getMessageId()))q.addEq("messageId", obj.getMessageId()); 
        if(!ObjectUtil.isEmpty(obj.getNum()))q.addEq("num", obj.getNum()); 
        if(!ObjectUtil.isEmpty(obj.getSellerId()))q.addEq("sellerId", obj.getSellerId()); 
        if(!ObjectUtil.isEmpty(obj.getBuyerId()))q.addEq("buyerId", obj.getBuyerId()); 
//        if(!ObjectUtil.isEmpty(obj.getCreartTimeBegin()) && !ObjectUtil.isEmpty(obj.getCreartTimeEnd())) {
//			q.addBetween("creartTime", obj.getCreartTimeBegin(), obj.getCreartTimeEnd());
//		}else{
//			if(!ObjectUtil.isEmpty(obj.getCreartTimeBegin())) q.addGt("creartTime", obj.getCreartTimeBegin());
//			if(!ObjectUtil.isEmpty(obj.getCreartTimeEnd()))   q.addLt("creartTime", obj.getCreartTimeEnd());
//		}
//        
//        if(!ObjectUtil.isEmpty(obj.getClosingTimeBegin()) && !ObjectUtil.isEmpty(obj.getClosingTimeEnd())) {
//			q.addBetween("closingTime", obj.getClosingTimeBegin(), obj.getClosingTimeEnd());
//		}else{
//			if(!ObjectUtil.isEmpty(obj.getClosingTimeBegin())) q.addGt("closingTime", obj.getClosingTimeBegin());
//			if(!ObjectUtil.isEmpty(obj.getClosingTimeEnd()))   q.addLt("closingTime", obj.getClosingTimeEnd());
//		}
        
        if(!ObjectUtil.isEmpty(obj.getState()))q.addEq("state", obj.getState()); 
		String[] columnProperty = {"id","name","category","info","pop","pictureId","price","secprice","conditions","messageId","num","sellerId","buyerId","creartTime","closingTime","state"};
		return this.findExpByQuery(q, columnProperty);
	}

	/**
	 * 统计售卖商品数，收藏数等
	 * @param sellerId
	 * @return
	 * @throws MysqlDBException
	 */
	public CountCommiditionVO countCommodity(String sellerId)throws MysqlDBException {
		if(ObjectUtil.isEmpty(sellerId)){
			MysqlDBException e = new MysqlDBException("查询条件对象为空 - 异常");
			log.error("查询条件对象为空 - 异常",e);
			throw e;
		}
		return commodityDAO.countCommodity(sellerId);
	}
	
	/**
	 * 统计售卖商品数，收藏数等
	 * @param sellerId
	 * @return
	 * @throws MysqlDBException
	 */
	public List<MessageVO> queryMessage(String commodityId)throws MysqlDBException {
		if(ObjectUtil.isEmpty(commodityId)){
			MysqlDBException e = new MysqlDBException("查询条件对象为空 - 异常");
			log.error("查询条件对象为空 - 异常",e);
			throw e;
		}
		return commodityDAO.queryMessage(commodityId);
	}

	/**
	 * 商品信息
	 * @createTime: 2018年10月10日 上午9:29:57
	 * @author: wu.kaibin
	 * @param sellerId
	 * @return
	 */
	public CommiditionVO queryCommodity(String commodityId) {
		return commodityDAO.queryCommodity(commodityId);
	}

	/**
	 * 我的关注商品
	 * @param pageNo
	 * @param pageSize
	 * @param id
	 * @return
	 */
	public Paged<CommodityPO> queryAttendCommodity(Integer pageNo, Integer pageSize, String id) {
		List<CommodityPO> list = commodityDAO.queryAttendCommodity(id);
		Paged<CommodityPO> page = new Paged<CommodityPO>(list ,list.size() ,pageNo ,pageSize,true);
		return page;
	}
	
	/**
	 * 根据关键字搜索
	 * @param pageNo
	 * @param pageSize
	 * @param id
	 * @return
	 */
	public Paged<CommodityPO> searchByKey(Integer pageNo, Integer pageSize, String key) {
		List<CommodityPO> list = commodityDAO.searchByKey(key);
		Paged<CommodityPO> page = new Paged<CommodityPO>(list ,list.size() ,pageNo ,pageSize,true);
		return page;
	}
}

