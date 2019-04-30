package com.cjw.project.code.ctrl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cjw.project.code.po.CommodityPictureRefPO;
import com.cjw.project.code.service.CommodityPictureRefService;
import com.cjw.project.tool.bean.Paged;
import com.cjw.project.tool.util.ObjectUtil;
import com.cjw.project.tool.util.UUIDUtil;
import com.cjw.project.tool.util.ajax.Response;
import com.cjw.project.tool.util.ajax.ResponseFactory;
import com.cjw.project.tool.web.MysqlDBException;


@Controller
@RequestMapping("/CommodityPictureRef") 
public class CommodityPictureRefCtrl {

	@Autowired
	private CommodityPictureRefService commodityPictureRefService;
	
	@RequestMapping(value ="/queryPageCommodityPictureRef")
	@ResponseBody
	public Response<List<CommodityPictureRefPO>> queryPageCommodityPictureRef(Integer page,Integer limit,HttpServletRequest request){
		Response<List<CommodityPictureRefPO>> response = ResponseFactory.getDefaultSuccessResponse();
		Paged<CommodityPictureRefPO> commodityPictureRefs = null;
		
		CommodityPictureRefPO condition=new CommodityPictureRefPO();
        String cid = request.getParameter("commodityPictureRef_cid");
		if(!ObjectUtil.isEmpty(cid)) condition.setCid(String.valueOf(cid));
        String commodityId = request.getParameter("commodityPictureRef_commodityId");
		if(!ObjectUtil.isEmpty(commodityId)) condition.setCommodityId(String.valueOf(commodityId));
        String pictureAdress = request.getParameter("commodityPictureRef_pictureAdress");
		if(!ObjectUtil.isEmpty(pictureAdress)) condition.setPictureAdress(String.valueOf(pictureAdress));
	
		try {
			commodityPictureRefs = commodityPictureRefService.queryPageCommodityPictureRef(page,limit,condition);
		} catch (MysqlDBException e) {
			e.printStackTrace();
			response.setError("网络连接失败，请检查网络");
		}
		response.setData(commodityPictureRefs.getListData());
		response.setCount(commodityPictureRefs.getTotalHit());
		response.setResult(Response.RESULT_SUCCESS);
		return response;
		
	}
	
	@RequestMapping(value="/delCommodityPictureRef")
	@ResponseBody
	public Response<CommodityPictureRefPO> delCommodityPictureRef(String id){
		Response<CommodityPictureRefPO> response = ResponseFactory.getDefaultSuccessResponse();

		if (ObjectUtil.isEmpty(id)) {
			response.setError("id不能为空");
			return response;
		}
		
		try {
			commodityPictureRefService.deleteCommodityPictureRefById(id);
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
	
	@RequestMapping(value="/findCommodityPictureRefById")
	@ResponseBody
	public Response<CommodityPictureRefPO> findCommodityPictureRefById(String id){
		Response<CommodityPictureRefPO> response =ResponseFactory.getDefaultSuccessResponse();
		if (ObjectUtil.isEmpty(id)) {
			response.setError("id不能为空");
			return response;
		}
		try {
			response.setData(commodityPictureRefService.getCommodityPictureRefById(id));
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
	
	@RequestMapping(value="/updateCommodityPictureRefById")
	@ResponseBody
	public Response<CommodityPictureRefPO> updateCommodityPictureRefById(HttpServletRequest request){
		Response<CommodityPictureRefPO> response =ResponseFactory.getDefaultSuccessResponse();
		CommodityPictureRefPO condition=new CommodityPictureRefPO();
        String cid = request.getParameter("commodityPictureRef_cid");
		if(!ObjectUtil.isEmpty(cid)) condition.setCid(String.valueOf(cid));
        String commodityId = request.getParameter("commodityPictureRef_commodityId");
		if(!ObjectUtil.isEmpty(commodityId)) condition.setCommodityId(String.valueOf(commodityId));
        String pictureAdress = request.getParameter("commodityPictureRef_pictureAdress");
		if(!ObjectUtil.isEmpty(pictureAdress)) condition.setPictureAdress(String.valueOf(pictureAdress));
		
		if (ObjectUtil.isEmpty(condition.getCid())) {
			response.setError("id不能为空");
			return response;
		}

		try {
			commodityPictureRefService.updateCommodityPictureRef(condition);
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
	
	@RequestMapping(value="/addCommodityPictureRef")
	@ResponseBody
	public Response<CommodityPictureRefPO> addCommodityPictureRef(HttpServletRequest request){
		Response<CommodityPictureRefPO> response =ResponseFactory.getDefaultSuccessResponse();
		
		CommodityPictureRefPO po=new CommodityPictureRefPO();
		po.setCid(UUIDUtil.getUUID());
        String cid = request.getParameter("commodityPictureRef_cid");
		if(!ObjectUtil.isEmpty(cid)) po.setCid(String.valueOf(cid));
        String commodityId = request.getParameter("commodityPictureRef_commodityId");
		if(!ObjectUtil.isEmpty(commodityId)) po.setCommodityId(String.valueOf(commodityId));
        String pictureAdress = request.getParameter("commodityPictureRef_pictureAdress");
		if(!ObjectUtil.isEmpty(pictureAdress)) po.setPictureAdress(String.valueOf(pictureAdress));
		
		try {
			commodityPictureRefService.addCommodityPictureRef(po);
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
	
	@RequestMapping(value="/getPicsByCommodityId")
	@ResponseBody
	public Response<List<CommodityPictureRefPO>> getPicsByCommodityId(HttpServletRequest request){
		Response<List<CommodityPictureRefPO>> response =ResponseFactory.getDefaultSuccessResponse();
		
		CommodityPictureRefPO po=new CommodityPictureRefPO();
        String commodityId = request.getParameter("commodityPictureRef_commodityId");
		if(!ObjectUtil.isEmpty(commodityId)) po.setCommodityId(String.valueOf(commodityId));
		
		try {
			response.setData(commodityPictureRefService.queryListCommodityPictureRefByParam(po));;
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
}
