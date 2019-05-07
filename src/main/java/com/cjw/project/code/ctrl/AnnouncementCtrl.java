
 
	
package com.cjw.project.code.ctrl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cjw.project.code.po.AnnouncementPO;
import com.cjw.project.code.service.AnnouncementService;
import com.cjw.project.tool.bean.Paged;
import com.cjw.project.tool.util.ObjectUtil;
import com.cjw.project.tool.util.UUIDUtil;
import com.cjw.project.tool.util.ajax.Response;
import com.cjw.project.tool.util.ajax.ResponseFactory;
import com.cjw.project.tool.web.MysqlDBException;


@Controller
@RequestMapping("/TAnnouncement") 
public class AnnouncementCtrl {

	@Autowired
	private AnnouncementService AnnouncementService;
	
	@RequestMapping(value ="/queryPageTAnnouncement")
	@ResponseBody
	public Response<List<AnnouncementPO>> queryPageTAnnouncement(Integer page,Integer limit,HttpServletRequest request){
		Response<List<AnnouncementPO>> response = ResponseFactory.getDefaultSuccessResponse();
		Paged<AnnouncementPO> tAnnouncements = null;
		
		AnnouncementPO condition=new AnnouncementPO();
        String id = request.getParameter("tAnnouncement_id");
		if(!ObjectUtil.isEmpty(id)) condition.setId(String.valueOf(id));
        String titlle = request.getParameter("tAnnouncement_titlle");
		if(!ObjectUtil.isEmpty(titlle)) condition.setTitlle(String.valueOf(titlle));
        String content = request.getParameter("tAnnouncement_content");
		if(!ObjectUtil.isEmpty(content)) condition.setContent(String.valueOf(content));
        String pictureId = request.getParameter("tAnnouncement_pictureId");
		if(!ObjectUtil.isEmpty(pictureId)) condition.setPictureId(String.valueOf(pictureId));
        String creatTime = request.getParameter("tAnnouncement_creatTime");
		if(!ObjectUtil.isEmpty(creatTime)) condition.setCreatTime(Long.valueOf(creatTime));
        String state = request.getParameter("tAnnouncement_state");
		if(!ObjectUtil.isEmpty(state)) condition.setState(String.valueOf(state));
	
		try {
			tAnnouncements = AnnouncementService.queryPageTAnnouncement(page,limit,condition);
		} catch (MysqlDBException e) {
			e.printStackTrace();
			response.setError("网络连接失败，请检查网络");
		}
		response.setData(tAnnouncements.getListData());
		response.setCount(AnnouncementService.findAll().size());
		response.setResult(Response.RESULT_SUCCESS);
		return response;
		
	}
	
	@RequestMapping(value="/delTAnnouncement")
	@ResponseBody
	public Response<AnnouncementPO> delTAnnouncement(String id){
		Response<AnnouncementPO> response = ResponseFactory.getDefaultSuccessResponse();

		if (ObjectUtil.isEmpty(id)) {
			response.setError("id不能为空");
			return response;
		}
		
		try {
			AnnouncementService.deleteTAnnouncementById(id);
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
	
	@RequestMapping(value="/findTAnnouncementById")
	@ResponseBody
	public Response<AnnouncementPO> findTAnnouncementById(String id){
		Response<AnnouncementPO> response =ResponseFactory.getDefaultSuccessResponse();
		if (ObjectUtil.isEmpty(id)) {
			response.setError("id不能为空");
			return response;
		}
		try {
			response.setData(AnnouncementService.getTAnnouncementById(id));
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
	
	@RequestMapping(value="/updateTAnnouncementById")
	@ResponseBody
	public Response<AnnouncementPO> updateTAnnouncementById(HttpServletRequest request){
		Response<AnnouncementPO> response =ResponseFactory.getDefaultSuccessResponse();
		AnnouncementPO condition=new AnnouncementPO();
        String id = request.getParameter("tAnnouncement_id");
		if(!ObjectUtil.isEmpty(id)) condition.setId(String.valueOf(id));
        String titlle = request.getParameter("tAnnouncement_titlle");
		if(!ObjectUtil.isEmpty(titlle)) condition.setTitlle(String.valueOf(titlle));
        String content = request.getParameter("tAnnouncement_content");
		if(!ObjectUtil.isEmpty(content)) condition.setContent(String.valueOf(content));
        String pictureId = request.getParameter("tAnnouncement_pictureId");
		if(!ObjectUtil.isEmpty(pictureId)) condition.setPictureId(String.valueOf(pictureId));
        String creatTime = request.getParameter("tAnnouncement_creatTime");
		if(!ObjectUtil.isEmpty(creatTime)) condition.setCreatTime(Long.valueOf(creatTime));
        String state = request.getParameter("tAnnouncement_state");
		if(!ObjectUtil.isEmpty(state)) condition.setState(String.valueOf(state));
		
		if (ObjectUtil.isEmpty(condition.getId())) {
			response.setError("id不能为空");
			return response;
		}

		try {
			AnnouncementService.updateTAnnouncement(condition);
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
	
	@RequestMapping(value="/addTAnnouncement")
	@ResponseBody
	public Response<AnnouncementPO> addTAnnouncement(HttpServletRequest request){
		Response<AnnouncementPO> response =ResponseFactory.getDefaultSuccessResponse();
		
		AnnouncementPO po=new AnnouncementPO();
		po.setId(UUIDUtil.getUUID());
        String id = request.getParameter("tAnnouncement_id");
		if(!ObjectUtil.isEmpty(id)) po.setId(String.valueOf(id));
        String titlle = request.getParameter("tAnnouncement_titlle");
		if(!ObjectUtil.isEmpty(titlle)) po.setTitlle(String.valueOf(titlle));
        String content = request.getParameter("tAnnouncement_content");
		if(!ObjectUtil.isEmpty(content)) po.setContent(String.valueOf(content));
        String pictureId = request.getParameter("tAnnouncement_pictureId");
		if(!ObjectUtil.isEmpty(pictureId)) po.setPictureId(String.valueOf(pictureId));
        String creatTime = request.getParameter("tAnnouncement_creatTime");
		if(!ObjectUtil.isEmpty(creatTime)) po.setCreatTime(Long.valueOf(creatTime));
        String state = request.getParameter("tAnnouncement_state");
		if(!ObjectUtil.isEmpty(state)) po.setState(String.valueOf(state));
		
		try {
			AnnouncementService.addTAnnouncement(po);
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
}
