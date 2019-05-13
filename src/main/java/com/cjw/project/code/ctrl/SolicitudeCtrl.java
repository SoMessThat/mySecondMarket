package com.cjw.project.code.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cjw.project.code.po.SolicitudePO;
import com.cjw.project.code.po.UserPO;
import com.cjw.project.code.service.SolicitudeService;
import com.cjw.project.tool.bean.Paged;
import com.cjw.project.tool.util.ObjectUtil;
import com.cjw.project.tool.util.UUIDUtil;
import com.cjw.project.tool.util.ajax.Response;
import com.cjw.project.tool.util.ajax.ResponseFactory;
import com.cjw.project.tool.web.MysqlDBException;
import com.cjw.project.tool.web.WebContext;


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
		Paged<SolicitudePO> tCommoditys = new Paged<SolicitudePO>();
		
		Map<String, String> map = new HashMap<String, String>();
		String id = request.getParameter("tCommodity_id");
		if(!ObjectUtil.isEmpty(id)) map.put("id",id);
		String name = request.getParameter("tCommodity_name");
		if(!ObjectUtil.isEmpty(name)) map.put("name",name);
		String category = request.getParameter("tCommodity_category");
		if(!ObjectUtil.isEmpty(category)) map.put("category",category);
		String category2 = request.getParameter("category");
		if(!ObjectUtil.isEmpty(category2)) map.put("category",category2);
		String info = request.getParameter("tCommodity_info");
		if(!ObjectUtil.isEmpty(info)) map.put("info",info);
		String pop = request.getParameter("tCommodity_pop");
		if(!ObjectUtil.isEmpty(pop)) map.put("pop",pop);
		String pictureId = request.getParameter("tCommodity_pictureId");
		if(!ObjectUtil.isEmpty(pictureId)) map.put("pictureId",pictureId);
		String price = request.getParameter("tCommodity_price");
		if(!ObjectUtil.isEmpty(price)) map.put("price",price);
		String secprice = request.getParameter("tCommodity_secprice");
		if(!ObjectUtil.isEmpty(secprice)) map.put("secprice",secprice);
		String conditions = request.getParameter("tCommodity_conditions");
		if(!ObjectUtil.isEmpty(conditions)) map.put("conditions",conditions);
		String messageId = request.getParameter("tCommodity_messageId");
		if(!ObjectUtil.isEmpty(messageId)) map.put("messageId",messageId);
		String num = request.getParameter("tCommodity_num");
		if(!ObjectUtil.isEmpty(num)) map.put("num",num);
		String sellerId = request.getParameter("tCommodity_sellerId");
		if(!ObjectUtil.isEmpty(sellerId)) map.put("sellerId",sellerId);
		String buyerId = request.getParameter("tCommodity_buyerId");
		if(!ObjectUtil.isEmpty(buyerId)) map.put("buyerId",buyerId);
		String creartTime = request.getParameter("tCommodity_creartTime");
		if(!ObjectUtil.isEmpty(creartTime)) map.put("creartTime",creartTime);
		String closingTime = request.getParameter("tCommodity_closingTime");
		if(!ObjectUtil.isEmpty(closingTime)) map.put("closingTime",closingTime);
		String state = request.getParameter("tCommodity_state");
		if(!ObjectUtil.isEmpty(state)) map.put("state",state);
		String type = "收藏";
		map.put("type", type);
		UserPO userPO = (UserPO) WebContext.getSessionAttribute("userInfo");
		map.put("userId", userPO.getId());
		try {
			tCommoditys = tSolicitudeService.queryPageTSolicitude(page,limit,map);
		} catch (MysqlDBException e) {
			e.printStackTrace();
			response.setError("网络连接失败，请检查网络");
		}
		response.setData(tCommoditys.getListData());
		response.setCount(tCommoditys.getTotalHit());
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
		Paged<SolicitudePO> tCommoditys = new Paged<SolicitudePO>();
		
		Map<String, String> map = new HashMap<String, String>();
		String id = request.getParameter("tCommodity_id");
		if(!ObjectUtil.isEmpty(id)) map.put("id",id);
		String name = request.getParameter("tCommodity_name");
		if(!ObjectUtil.isEmpty(name)) map.put("name",name);
		String category = request.getParameter("tCommodity_category");
		if(!ObjectUtil.isEmpty(category)) map.put("category",category);
		String category2 = request.getParameter("category");
		if(!ObjectUtil.isEmpty(category2)) map.put("category",category2);
		String info = request.getParameter("tCommodity_info");
		if(!ObjectUtil.isEmpty(info)) map.put("info",info);
		String pop = request.getParameter("tCommodity_pop");
		if(!ObjectUtil.isEmpty(pop)) map.put("pop",pop);
		String pictureId = request.getParameter("tCommodity_pictureId");
		if(!ObjectUtil.isEmpty(pictureId)) map.put("pictureId",pictureId);
		String price = request.getParameter("tCommodity_price");
		if(!ObjectUtil.isEmpty(price)) map.put("price",price);
		String secprice = request.getParameter("tCommodity_secprice");
		if(!ObjectUtil.isEmpty(secprice)) map.put("secprice",secprice);
		String conditions = request.getParameter("tCommodity_conditions");
		if(!ObjectUtil.isEmpty(conditions)) map.put("conditions",conditions);
		String messageId = request.getParameter("tCommodity_messageId");
		if(!ObjectUtil.isEmpty(messageId)) map.put("messageId",messageId);
		String num = request.getParameter("tCommodity_num");
		if(!ObjectUtil.isEmpty(num)) map.put("num",num);
		String sellerId = request.getParameter("tCommodity_sellerId");
		if(!ObjectUtil.isEmpty(sellerId)) map.put("sellerId",sellerId);
		String buyerId = request.getParameter("tCommodity_buyerId");
		if(!ObjectUtil.isEmpty(buyerId)) map.put("buyerId",buyerId);
		String creartTime = request.getParameter("tCommodity_creartTime");
		if(!ObjectUtil.isEmpty(creartTime)) map.put("creartTime",creartTime);
		String closingTime = request.getParameter("tCommodity_closingTime");
		if(!ObjectUtil.isEmpty(closingTime)) map.put("closingTime",closingTime);
		String state = request.getParameter("tCommodity_state");
		if(!ObjectUtil.isEmpty(state)) map.put("state",state);
		String type = "关注";
		map.put("type", type);
		UserPO userPO = (UserPO) WebContext.getSessionAttribute("userInfo");
		map.put("userId", userPO.getId());
		try {
			tCommoditys = tSolicitudeService.queryPageTSolicitude(page,limit,map);
		} catch (MysqlDBException e) {
			e.printStackTrace();
			response.setError("网络连接失败，请检查网络");
		}
		response.setData(tCommoditys.getListData());
		response.setCount(tCommoditys.getTotalHit());
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
