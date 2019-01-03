
 
	
package com.cjw.project.code.ctrl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cjw.project.code.po.CommodityPO;
import com.cjw.project.code.service.CommodityService;
import com.cjw.project.tool.bean.Paged;
import com.cjw.project.tool.util.ObjectUtil;
import com.cjw.project.tool.util.UUIDUtil;
import com.cjw.project.tool.util.ajax.Response;
import com.cjw.project.tool.util.ajax.ResponseFactory;
import com.cjw.project.tool.web.MysqlDBException;


@Controller
@RequestMapping("/TCommodity") 
public class CommodityCtrl {

	@Autowired
	private CommodityService tCommodityService;
	
	@RequestMapping(value ="/queryPageTCommodity")
	@ResponseBody
	public Response<List<CommodityPO>> queryPageTCommodity(Integer page,Integer limit,HttpServletRequest request){
		Response<List<CommodityPO>> response = ResponseFactory.getDefaultSuccessResponse();
		Paged<CommodityPO> tCommoditys = null;
		
		CommodityPO condition=new CommodityPO();
        String id = request.getParameter("tCommodity_id");
		if(!ObjectUtil.isEmpty(id)) condition.setId(String.valueOf(id));
        String name = request.getParameter("tCommodity_name");
		if(!ObjectUtil.isEmpty(name)) condition.setName(String.valueOf(name));
        String category = request.getParameter("tCommodity_category");
		if(!ObjectUtil.isEmpty(category)) condition.setCategory(String.valueOf(category));
        String info = request.getParameter("tCommodity_info");
		if(!ObjectUtil.isEmpty(info)) condition.setInfo(String.valueOf(info));
        String pop = request.getParameter("tCommodity_pop");
		if(!ObjectUtil.isEmpty(pop)) condition.setPop(Integer.valueOf(pop));
        String pictureId = request.getParameter("tCommodity_pictureId");
		if(!ObjectUtil.isEmpty(pictureId)) condition.setPictureId(String.valueOf(pictureId));
        String price = request.getParameter("tCommodity_price");
		if(!ObjectUtil.isEmpty(price)) condition.setPrice(Double.valueOf(price));
        String secprice = request.getParameter("tCommodity_secprice");
		if(!ObjectUtil.isEmpty(secprice)) condition.setSecprice(Double.valueOf(secprice));
        String conditions = request.getParameter("tCommodity_conditions");
		if(!ObjectUtil.isEmpty(conditions)) condition.setConditions(String.valueOf(conditions));
        String messageId = request.getParameter("tCommodity_messageId");
		if(!ObjectUtil.isEmpty(messageId)) condition.setMessageId(String.valueOf(messageId));
        String num = request.getParameter("tCommodity_num");
		if(!ObjectUtil.isEmpty(num)) condition.setNum(Integer.valueOf(num));
        String sellerId = request.getParameter("tCommodity_sellerId");
		if(!ObjectUtil.isEmpty(sellerId)) condition.setSellerId(String.valueOf(sellerId));
        String buyerId = request.getParameter("tCommodity_buyerId");
		if(!ObjectUtil.isEmpty(buyerId)) condition.setBuyerId(String.valueOf(buyerId));
        String creartTime = request.getParameter("tCommodity_creartTime");
		if(!ObjectUtil.isEmpty(creartTime)) condition.setCreartTime(Long.valueOf(creartTime));
        String closingTime = request.getParameter("tCommodity_closingTime");
		if(!ObjectUtil.isEmpty(closingTime)) condition.setClosingTime(Long.valueOf(closingTime));
        String state = request.getParameter("tCommodity_state");
		if(!ObjectUtil.isEmpty(state)) condition.setState(String.valueOf(state));
	
		try {
			tCommoditys = tCommodityService.queryPageTCommodity(page,limit,condition);
		} catch (MysqlDBException e) {
			e.printStackTrace();
			response.setError("网络连接失败，请检查网络");
		}
		response.setData(tCommoditys.getListData());
		response.setCount(tCommodityService.findAll().size());
		response.setResult(Response.RESULT_SUCCESS);
		return response;
		
	}
	
	@RequestMapping(value="/delTCommodity")
	@ResponseBody
	public Response<CommodityPO> delTCommodity(String id){
		Response<CommodityPO> response = ResponseFactory.getDefaultSuccessResponse();

		if (ObjectUtil.isEmpty(id)) {
			response.setError("id不能为空");
			return response;
		}
		
		try {
			tCommodityService.deleteTCommodityById(id);
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
	
	@RequestMapping(value="/findTCommodityById")
	@ResponseBody
	public Response<CommodityPO> findTCommodityById(String id){
		Response<CommodityPO> response =ResponseFactory.getDefaultSuccessResponse();
		if (ObjectUtil.isEmpty(id)) {
			response.setError("id不能为空");
			return response;
		}
		try {
			response.setData(tCommodityService.getTCommodityById(id));
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
	
	@RequestMapping(value="/updateTCommodityById")
	@ResponseBody
	public Response<CommodityPO> updateTCommodityById(HttpServletRequest request){
		Response<CommodityPO> response =ResponseFactory.getDefaultSuccessResponse();
		CommodityPO condition=new CommodityPO();
        String id = request.getParameter("tCommodity_id");
		if(!ObjectUtil.isEmpty(id)) condition.setId(String.valueOf(id));
        String name = request.getParameter("tCommodity_name");
		if(!ObjectUtil.isEmpty(name)) condition.setName(String.valueOf(name));
        String category = request.getParameter("tCommodity_category");
		if(!ObjectUtil.isEmpty(category)) condition.setCategory(String.valueOf(category));
        String info = request.getParameter("tCommodity_info");
		if(!ObjectUtil.isEmpty(info)) condition.setInfo(String.valueOf(info));
        String pop = request.getParameter("tCommodity_pop");
		if(!ObjectUtil.isEmpty(pop)) condition.setPop(Integer.valueOf(pop));
        String pictureId = request.getParameter("tCommodity_pictureId");
		if(!ObjectUtil.isEmpty(pictureId)) condition.setPictureId(String.valueOf(pictureId));
        String price = request.getParameter("tCommodity_price");
		if(!ObjectUtil.isEmpty(price)) condition.setPrice(Double.valueOf(price));
        String secprice = request.getParameter("tCommodity_secprice");
		if(!ObjectUtil.isEmpty(secprice)) condition.setSecprice(Double.valueOf(secprice));
        String conditions = request.getParameter("tCommodity_conditions");
		if(!ObjectUtil.isEmpty(conditions)) condition.setConditions(String.valueOf(conditions));
        String messageId = request.getParameter("tCommodity_messageId");
		if(!ObjectUtil.isEmpty(messageId)) condition.setMessageId(String.valueOf(messageId));
        String num = request.getParameter("tCommodity_num");
		if(!ObjectUtil.isEmpty(num)) condition.setNum(Integer.valueOf(num));
        String sellerId = request.getParameter("tCommodity_sellerId");
		if(!ObjectUtil.isEmpty(sellerId)) condition.setSellerId(String.valueOf(sellerId));
        String buyerId = request.getParameter("tCommodity_buyerId");
		if(!ObjectUtil.isEmpty(buyerId)) condition.setBuyerId(String.valueOf(buyerId));
        String creartTime = request.getParameter("tCommodity_creartTime");
		if(!ObjectUtil.isEmpty(creartTime)) condition.setCreartTime(Long.valueOf(creartTime));
        String closingTime = request.getParameter("tCommodity_closingTime");
		if(!ObjectUtil.isEmpty(closingTime)) condition.setClosingTime(Long.valueOf(closingTime));
        String state = request.getParameter("tCommodity_state");
		if(!ObjectUtil.isEmpty(state)) condition.setState(String.valueOf(state));
		
		if (ObjectUtil.isEmpty(condition.getId())) {
			response.setError("id不能为空");
			return response;
		}

		try {
			tCommodityService.updateTCommodity(condition);
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
	
	@RequestMapping(value="/addTCommodity")
	@ResponseBody
	public Response<CommodityPO> addTCommodity(HttpServletRequest request){
		Response<CommodityPO> response =ResponseFactory.getDefaultSuccessResponse();
		
		CommodityPO po=new CommodityPO();
		po.setId(UUIDUtil.getUUID());
        String id = request.getParameter("tCommodity_id");
		if(!ObjectUtil.isEmpty(id)) po.setId(String.valueOf(id));
        String name = request.getParameter("tCommodity_name");
		if(!ObjectUtil.isEmpty(name)) po.setName(String.valueOf(name));
        String category = request.getParameter("tCommodity_category");
		if(!ObjectUtil.isEmpty(category)) po.setCategory(String.valueOf(category));
        String info = request.getParameter("tCommodity_info");
		if(!ObjectUtil.isEmpty(info)) po.setInfo(String.valueOf(info));
        String pop = request.getParameter("tCommodity_pop");
		if(!ObjectUtil.isEmpty(pop)) po.setPop(Integer.valueOf(pop));
        String pictureId = request.getParameter("tCommodity_pictureId");
		if(!ObjectUtil.isEmpty(pictureId)) po.setPictureId(String.valueOf(pictureId));
        String price = request.getParameter("tCommodity_price");
		if(!ObjectUtil.isEmpty(price)) po.setPrice(Double.valueOf(price));
        String secprice = request.getParameter("tCommodity_secprice");
		if(!ObjectUtil.isEmpty(secprice)) po.setSecprice(Double.valueOf(secprice));
        String conditions = request.getParameter("tCommodity_conditions");
		if(!ObjectUtil.isEmpty(conditions)) po.setConditions(String.valueOf(conditions));
        String messageId = request.getParameter("tCommodity_messageId");
		if(!ObjectUtil.isEmpty(messageId)) po.setMessageId(String.valueOf(messageId));
        String num = request.getParameter("tCommodity_num");
		if(!ObjectUtil.isEmpty(num)) po.setNum(Integer.valueOf(num));
        String sellerId = request.getParameter("tCommodity_sellerId");
		if(!ObjectUtil.isEmpty(sellerId)) po.setSellerId(String.valueOf(sellerId));
        String buyerId = request.getParameter("tCommodity_buyerId");
		if(!ObjectUtil.isEmpty(buyerId)) po.setBuyerId(String.valueOf(buyerId));
        String creartTime = request.getParameter("tCommodity_creartTime");
		if(!ObjectUtil.isEmpty(creartTime)) po.setCreartTime(Long.valueOf(creartTime));
        String closingTime = request.getParameter("tCommodity_closingTime");
		if(!ObjectUtil.isEmpty(closingTime)) po.setClosingTime(Long.valueOf(closingTime));
        String state = request.getParameter("tCommodity_state");
		if(!ObjectUtil.isEmpty(state)) po.setState(String.valueOf(state));
		
		try {
			tCommodityService.addTCommodity(po);
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
}
