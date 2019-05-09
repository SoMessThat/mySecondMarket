
 
	
package com.cjw.project.code.ctrl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cjw.project.code.po.DemandPO;
import com.cjw.project.code.po.UserPO;
import com.cjw.project.code.service.DemandService;
import com.cjw.project.tool.bean.Paged;
import com.cjw.project.tool.util.ObjectUtil;
import com.cjw.project.tool.util.ajax.Response;
import com.cjw.project.tool.util.ajax.ResponseFactory;
import com.cjw.project.tool.web.MysqlDBException;
import com.cjw.project.tool.web.WebContext;


@Controller
@RequestMapping("/TDemand") 
public class DemandCtrl {

	@Autowired
	private DemandService tDemandService;
	
	@RequestMapping(value ="/queryPageTDemand")
	@ResponseBody
	public Response<List<DemandPO>> queryPageTDemand(Integer page,Integer limit,HttpServletRequest request){
		Response<List<DemandPO>> response = ResponseFactory.getDefaultSuccessResponse();
		Paged<DemandPO> tDemands = null;
		
		DemandPO condition=new DemandPO();
        String id = request.getParameter("tDemand_id");
		if(!ObjectUtil.isEmpty(id)) condition.setId(Integer.valueOf(id));
        String sellerId = request.getParameter("tDemand_sellerId");
		if(!ObjectUtil.isEmpty(sellerId)) condition.setSellerId(String.valueOf(sellerId));
        String price = request.getParameter("tDemand_price");
		if(!ObjectUtil.isEmpty(price)) condition.setPrice(Integer.valueOf(price));
        String name = request.getParameter("tDemand_name");
		if(!ObjectUtil.isEmpty(name)) condition.setName(String.valueOf(name));
        String info = request.getParameter("tDemand_info");
		if(!ObjectUtil.isEmpty(info)) condition.setInfo(String.valueOf(info));
        String buyerId = request.getParameter("tDemand_buyerId");
		if(!ObjectUtil.isEmpty(buyerId)) condition.setBuyerId(String.valueOf(buyerId));
        String creartTime = request.getParameter("tDemand_creartTime");
		if(!ObjectUtil.isEmpty(creartTime)) condition.setCreartTime(String.valueOf(creartTime));
        String messageId = request.getParameter("tDemand_messageId");
		if(!ObjectUtil.isEmpty(messageId)) condition.setMessageId(String.valueOf(messageId));
        String state = request.getParameter("tDemand_state");
		if(!ObjectUtil.isEmpty(state)) condition.setState(String.valueOf(state));
	
		try {
			tDemands = tDemandService.queryPageTDemand(page,limit,condition);
		} catch (MysqlDBException e) {
			e.printStackTrace();
			response.setError("网络连接失败，请检查网络");
		}
		response.setData(tDemands.getListData());
		response.setCount(tDemandService.findAll().size());
		response.setResult(Response.RESULT_SUCCESS);
		return response;
		
	}
	
	@RequestMapping(value="/delTDemand")
	@ResponseBody
	public Response<DemandPO> delTDemand(String id){
		Response<DemandPO> response = ResponseFactory.getDefaultSuccessResponse();

		if (ObjectUtil.isEmpty(id)) {
			response.setError("id不能为空");
			return response;
		}
		
		try {
			tDemandService.deleteTDemandById(id);
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
	
	@RequestMapping(value="/findTDemandById")
	@ResponseBody
	public Response<DemandPO> findTDemandById(String id){
		Response<DemandPO> response =ResponseFactory.getDefaultSuccessResponse();
		if (ObjectUtil.isEmpty(id)) {
			response.setError("id不能为空");
			return response;
		}
		try {
			response.setData(tDemandService.getTDemandById(id));
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
	
	@RequestMapping(value="/updateTDemandById")
	@ResponseBody
	public Response<DemandPO> updateTDemandById(HttpServletRequest request){
		Response<DemandPO> response =ResponseFactory.getDefaultSuccessResponse();
		DemandPO condition=new DemandPO();
        String id = request.getParameter("tDemand_id");
		if(!ObjectUtil.isEmpty(id)) condition.setId(Integer.valueOf(id));
        String sellerId = request.getParameter("tDemand_sellerId");
		if(!ObjectUtil.isEmpty(sellerId)) condition.setSellerId(String.valueOf(sellerId));
        String price = request.getParameter("tDemand_price");
		if(!ObjectUtil.isEmpty(price)) condition.setPrice(Integer.valueOf(price));
        String name = request.getParameter("tDemand_name");
		if(!ObjectUtil.isEmpty(name)) condition.setName(String.valueOf(name));
        String info = request.getParameter("tDemand_info");
		if(!ObjectUtil.isEmpty(info)) condition.setInfo(String.valueOf(info));
        String buyerId = request.getParameter("tDemand_buyerId");
		if(!ObjectUtil.isEmpty(buyerId)) condition.setBuyerId(String.valueOf(buyerId));
        String creartTime = request.getParameter("tDemand_creartTime");
		if(!ObjectUtil.isEmpty(creartTime)) condition.setCreartTime(String.valueOf(creartTime));
        String messageId = request.getParameter("tDemand_messageId");
		if(!ObjectUtil.isEmpty(messageId)) condition.setMessageId(String.valueOf(messageId));
        String state = request.getParameter("tDemand_state");
		if(!ObjectUtil.isEmpty(state)) condition.setState(String.valueOf(state));
		
		if (ObjectUtil.isEmpty(condition.getId())) {
			response.setError("id不能为空");
			return response;
		}

		try {
			tDemandService.updateTDemand(condition);
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
	
	@RequestMapping(value="/addTDemand")
	@ResponseBody
	public Response<DemandPO> addTDemand(HttpServletRequest request){
		Response<DemandPO> response =ResponseFactory.getDefaultSuccessResponse();
		
		DemandPO po=new DemandPO();
		UserPO user = (UserPO) WebContext.getSessionAttribute("userInfo");
        po.setSellerId(user.getId());
        String price = request.getParameter("tDemand_price");
		if(!ObjectUtil.isEmpty(price)) po.setPrice(Integer.valueOf(price));
        String name = request.getParameter("tDemand_name");
		if(!ObjectUtil.isEmpty(name)) po.setName(String.valueOf(name));
        String info = request.getParameter("tDemand_info");
		if(!ObjectUtil.isEmpty(info)) po.setInfo(String.valueOf(info));
        po.setState(String.valueOf("发布成功"));
        DateFormat bf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        po.setCreartTime(bf.format(new Date()));
		
		try {
			tDemandService.addTDemand(po);
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
}
