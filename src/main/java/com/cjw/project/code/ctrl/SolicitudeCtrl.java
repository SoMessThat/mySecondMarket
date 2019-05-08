package com.cjw.project.code.ctrl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cjw.project.code.po.SolicitudePO;
import com.cjw.project.code.service.SolicitudeService;
import com.cjw.project.tool.bean.Paged;
import com.cjw.project.tool.util.ObjectUtil;
import com.cjw.project.tool.util.UUIDUtil;
import com.cjw.project.tool.util.ajax.Response;
import com.cjw.project.tool.util.ajax.ResponseFactory;
import com.cjw.project.tool.web.MysqlDBException;


@Controller
@RequestMapping("/TSolicitude") 
public class SolicitudeCtrl {

	@Autowired
	private SolicitudeService tSolicitudeService;
	/**
	 * 收藏
	 * @param page
	 * @param limit
	 * @param request
	 * @return
	 */
	@RequestMapping(value ="/queryPageCollect")
	@ResponseBody
	public Response<List<SolicitudePO>> queryPageCollect(Integer page,Integer limit,HttpServletRequest request){
		Response<List<SolicitudePO>> response = ResponseFactory.getDefaultSuccessResponse();
		Paged<SolicitudePO> tSolicitudes = null;
		
		SolicitudePO condition=new SolicitudePO();
        String id = request.getParameter("tSolicitude_id");
		if(!ObjectUtil.isEmpty(id)) condition.setId(String.valueOf(id));
        String userId = request.getParameter("tSolicitude_userId");
		if(!ObjectUtil.isEmpty(userId)) condition.setUserId(String.valueOf(userId));
        String commodityId = request.getParameter("tSolicitude_commodityId");
		if(!ObjectUtil.isEmpty(commodityId)) condition.setCommodityId(String.valueOf(commodityId));
        String category = request.getParameter("tSolicitude_category");
		if(!ObjectUtil.isEmpty(category)) condition.setCategory(String.valueOf(category));
		condition.setType("收藏");
	
		try {
			tSolicitudes = tSolicitudeService.queryPageTSolicitude(page,limit,condition);
		} catch (MysqlDBException e) {
			e.printStackTrace();
			response.setError("网络连接失败，请检查网络");
		}
		response.setData(tSolicitudes.getListData());
		response.setCount(tSolicitudeService.findAll().size());
		response.setResult(Response.RESULT_SUCCESS);
		return response;
		
	}
	
	/**
	 * 关注
	 * @param page
	 * @param limit
	 * @param request
	 * @return
	 */
	@RequestMapping(value ="/queryPageAttention")
	@ResponseBody
	public Response<List<SolicitudePO>> queryPageAttention(Integer page,Integer limit,HttpServletRequest request){
		Response<List<SolicitudePO>> response = ResponseFactory.getDefaultSuccessResponse();
		Paged<SolicitudePO> tSolicitudes = null;
		
		SolicitudePO condition=new SolicitudePO();
        String id = request.getParameter("tSolicitude_id");
		if(!ObjectUtil.isEmpty(id)) condition.setId(String.valueOf(id));
        String userId = request.getParameter("tSolicitude_userId");
		if(!ObjectUtil.isEmpty(userId)) condition.setUserId(String.valueOf(userId));
        String commodityId = request.getParameter("tSolicitude_commodityId");
		if(!ObjectUtil.isEmpty(commodityId)) condition.setCommodityId(String.valueOf(commodityId));
        String category = request.getParameter("tSolicitude_category");
		if(!ObjectUtil.isEmpty(category)) condition.setCategory(String.valueOf(category));
		condition.setType("关注");
		
		try {
			tSolicitudes = tSolicitudeService.queryPageTSolicitude(page,limit,condition);
		} catch (MysqlDBException e) {
			e.printStackTrace();
			response.setError("网络连接失败，请检查网络");
		}
		response.setData(tSolicitudes.getListData());
		response.setCount(tSolicitudeService.findAll().size());
		response.setResult(Response.RESULT_SUCCESS);
		return response;
		
	}
	
	@RequestMapping(value="/delTSolicitude")
	@ResponseBody
	public Response<SolicitudePO> delTSolicitude(String id){
		Response<SolicitudePO> response = ResponseFactory.getDefaultSuccessResponse();

		if (ObjectUtil.isEmpty(id)) {
			response.setError("id不能为空");
			return response;
		}
		
		try {
			tSolicitudeService.deleteTSolicitudeById(id);
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
	
	@RequestMapping(value="/findTSolicitudeById")
	@ResponseBody
	public Response<SolicitudePO> findTSolicitudeById(String id){
		Response<SolicitudePO> response =ResponseFactory.getDefaultSuccessResponse();
		if (ObjectUtil.isEmpty(id)) {
			response.setError("id不能为空");
			return response;
		}
		try {
			response.setData(tSolicitudeService.getTSolicitudeById(id));
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
	
	@RequestMapping(value="/updateTSolicitudeById")
	@ResponseBody
	public Response<SolicitudePO> updateTSolicitudeById(HttpServletRequest request){
		Response<SolicitudePO> response =ResponseFactory.getDefaultSuccessResponse();
		SolicitudePO condition=new SolicitudePO();
        String id = request.getParameter("tSolicitude_id");
		if(!ObjectUtil.isEmpty(id)) condition.setId(String.valueOf(id));
        String userId = request.getParameter("tSolicitude_userId");
		if(!ObjectUtil.isEmpty(userId)) condition.setUserId(String.valueOf(userId));
        String commodityId = request.getParameter("tSolicitude_commodityId");
		if(!ObjectUtil.isEmpty(commodityId)) condition.setCommodityId(String.valueOf(commodityId));
        String category = request.getParameter("tSolicitude_category");
		if(!ObjectUtil.isEmpty(category)) condition.setCategory(String.valueOf(category));
        String type = request.getParameter("tSolicitude_type");
		if(!ObjectUtil.isEmpty(type)) condition.setType(String.valueOf(type));
		
		if (ObjectUtil.isEmpty(condition.getId())) {
			response.setError("id不能为空");
			return response;
		}

		try {
			tSolicitudeService.updateTSolicitude(condition);
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
	
	@RequestMapping(value="/addTSolicitude")
	@ResponseBody
	public Response<SolicitudePO> addTSolicitude(HttpServletRequest request){
		Response<SolicitudePO> response =ResponseFactory.getDefaultSuccessResponse();
		
		SolicitudePO po=new SolicitudePO();
		po.setId(UUIDUtil.getUUID());
        String id = request.getParameter("tSolicitude_id");
		if(!ObjectUtil.isEmpty(id)) po.setId(String.valueOf(id));
        String userId = request.getParameter("tSolicitude_userId");
		if(!ObjectUtil.isEmpty(userId)) po.setUserId(String.valueOf(userId));
        String commodityId = request.getParameter("tSolicitude_commodityId");
		if(!ObjectUtil.isEmpty(commodityId)) po.setCommodityId(String.valueOf(commodityId));
        String category = request.getParameter("tSolicitude_category");
		if(!ObjectUtil.isEmpty(category)) po.setCategory(String.valueOf(category));
        String type = request.getParameter("tSolicitude_type");
		if(!ObjectUtil.isEmpty(type)) po.setType(String.valueOf(type));
		
		try {
			tSolicitudeService.addTSolicitude(po);
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
}
