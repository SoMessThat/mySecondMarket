
 
	
package com.cjw.project.code.ctrl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cjw.project.code.po.MessagePO;
import com.cjw.project.code.service.MessageService;
import com.cjw.project.code.vo.MessageCountVO;
import com.cjw.project.tool.bean.Paged;
import com.cjw.project.tool.util.ObjectUtil;
import com.cjw.project.tool.util.UUIDUtil;
import com.cjw.project.tool.util.ajax.Response;
import com.cjw.project.tool.util.ajax.ResponseFactory;
import com.cjw.project.tool.web.MysqlDBException;


@Controller
@RequestMapping("/TMessage") 
public class MessageCtrl {

	@Autowired
	private MessageService tMessageService;
	
	@RequestMapping(value ="/queryPageTMessage")
	@ResponseBody
	public Response<List<MessagePO>> queryPageTMessage(Integer page,Integer limit,HttpServletRequest request){
		Response<List<MessagePO>> response = ResponseFactory.getDefaultSuccessResponse();
		Paged<MessagePO> tMessages = null;
		
		MessagePO condition=new MessagePO();
        String id = request.getParameter("tMessage_id");
		if(!ObjectUtil.isEmpty(id)) condition.setId(String.valueOf(id));
        String ownerId = request.getParameter("tMessage_ownerId");
		if(!ObjectUtil.isEmpty(ownerId)) condition.setOwnerId(String.valueOf(ownerId));
        String ownerName = request.getParameter("tMessage_ownerName");
		if(!ObjectUtil.isEmpty(ownerName)) condition.setOwnerName(String.valueOf(ownerName));
        String passersbyId = request.getParameter("tMessage_passersbyId");
		if(!ObjectUtil.isEmpty(passersbyId)) condition.setPassersbyId(String.valueOf(passersbyId));
        String answerId = request.getParameter("tMessage_answerId");
		if(!ObjectUtil.isEmpty(answerId)) condition.setAnswerId(String.valueOf(answerId));
        String commodityId = request.getParameter("tMessage_commodityId");
		if(!ObjectUtil.isEmpty(commodityId)) condition.setCommodityId(String.valueOf(commodityId));
        String content = request.getParameter("tMessage_content");
		if(!ObjectUtil.isEmpty(content)) condition.setContent(String.valueOf(content));
        String time = request.getParameter("tMessage_time");
		if(!ObjectUtil.isEmpty(time)) condition.setTime(Long.valueOf(time));
        String passersbyName = request.getParameter("tMessage_passersbyName");
		if(!ObjectUtil.isEmpty(passersbyName)) condition.setPassersbyName(String.valueOf(passersbyName));
	
		try {
			tMessages = tMessageService.queryPageTMessage(page,limit,condition);
		} catch (MysqlDBException e) {
			e.printStackTrace();
			response.setError("网络连接失败，请检查网络");
		}
		response.setData(tMessages.getListData());
		response.setCount(tMessageService.findAll().size());
		response.setResult(Response.RESULT_SUCCESS);
		return response;
		
	}
	
	@RequestMapping(value="/delTMessage")
	@ResponseBody
	public Response<MessagePO> delTMessage(String id){
		Response<MessagePO> response = ResponseFactory.getDefaultSuccessResponse();

		if (ObjectUtil.isEmpty(id)) {
			response.setError("id不能为空");
			return response;
		}
		
		try {
			tMessageService.deleteTMessageById(id);
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
	
	@RequestMapping(value="/findTMessageById")
	@ResponseBody
	public Response<MessagePO> findTMessageById(String id){
		Response<MessagePO> response =ResponseFactory.getDefaultSuccessResponse();
		if (ObjectUtil.isEmpty(id)) {
			response.setError("id不能为空");
			return response;
		}
		try {
			response.setData(tMessageService.getTMessageById(id));
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
	
	@RequestMapping(value="/updateTMessageById")
	@ResponseBody
	public Response<MessagePO> updateTMessageById(HttpServletRequest request){
		Response<MessagePO> response =ResponseFactory.getDefaultSuccessResponse();
		MessagePO condition=new MessagePO();
        String id = request.getParameter("tMessage_id");
		if(!ObjectUtil.isEmpty(id)) condition.setId(String.valueOf(id));
        String ownerId = request.getParameter("tMessage_ownerId");
		if(!ObjectUtil.isEmpty(ownerId)) condition.setOwnerId(String.valueOf(ownerId));
        String ownerName = request.getParameter("tMessage_ownerName");
		if(!ObjectUtil.isEmpty(ownerName)) condition.setOwnerName(String.valueOf(ownerName));
        String passersbyId = request.getParameter("tMessage_passersbyId");
		if(!ObjectUtil.isEmpty(passersbyId)) condition.setPassersbyId(String.valueOf(passersbyId));
        String answerId = request.getParameter("tMessage_answerId");
		if(!ObjectUtil.isEmpty(answerId)) condition.setAnswerId(String.valueOf(answerId));
        String commodityId = request.getParameter("tMessage_commodityId");
		if(!ObjectUtil.isEmpty(commodityId)) condition.setCommodityId(String.valueOf(commodityId));
        String content = request.getParameter("tMessage_content");
		if(!ObjectUtil.isEmpty(content)) condition.setContent(String.valueOf(content));
        String time = request.getParameter("tMessage_time");
		if(!ObjectUtil.isEmpty(time)) condition.setTime(Long.valueOf(time));
        String passersbyName = request.getParameter("tMessage_passersbyName");
		if(!ObjectUtil.isEmpty(passersbyName)) condition.setPassersbyName(String.valueOf(passersbyName));
		
		if (ObjectUtil.isEmpty(condition.getId())) {
			response.setError("id不能为空");
			return response;
		}

		try {
			tMessageService.updateTMessage(condition);
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
	
	@RequestMapping(value="/addTMessage")
	@ResponseBody
	public Response<MessagePO> addTMessage(HttpServletRequest request){
		Response<MessagePO> response =ResponseFactory.getDefaultSuccessResponse();
		
		MessagePO po=new MessagePO();
		po.setId(UUIDUtil.getUUID());
        String id = request.getParameter("tMessage_id");
		if(!ObjectUtil.isEmpty(id)) po.setId(String.valueOf(id));
        String ownerId = request.getParameter("tMessage_ownerId");
		if(!ObjectUtil.isEmpty(ownerId)) po.setOwnerId(String.valueOf(ownerId));
        String ownerName = request.getParameter("tMessage_ownerName");
		if(!ObjectUtil.isEmpty(ownerName)) po.setOwnerName(String.valueOf(ownerName));
        String passersbyId = request.getParameter("tMessage_passersbyId");
		if(!ObjectUtil.isEmpty(passersbyId)) po.setPassersbyId(String.valueOf(passersbyId));
        String answerId = request.getParameter("tMessage_answerId");
		if(!ObjectUtil.isEmpty(answerId)) po.setAnswerId(String.valueOf(answerId));
        String commodityId = request.getParameter("tMessage_commodityId");
		if(!ObjectUtil.isEmpty(commodityId)) po.setCommodityId(String.valueOf(commodityId));
        String content = request.getParameter("tMessage_content");
		if(!ObjectUtil.isEmpty(content)) po.setContent(String.valueOf(content));
        po.setTime(new Date().getTime()/1000);
        String passersbyName = request.getParameter("tMessage_passersbyName");
		if(!ObjectUtil.isEmpty(passersbyName)) po.setPassersbyName(String.valueOf(passersbyName));
		
		try {
			tMessageService.addTMessage(po);
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
	
	@RequestMapping(value="/countTMessage")
	@ResponseBody
	public Response<MessageCountVO> countTMessage(HttpServletRequest request){
		Response<MessageCountVO> response =ResponseFactory.getDefaultSuccessResponse();
		
        String commodityId = request.getParameter("commodityId");
		if(ObjectUtil.isEmpty(commodityId)) 
		{
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		MessageCountVO map = tMessageService.countTMessage(commodityId);
		response.setData(map);
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
}
