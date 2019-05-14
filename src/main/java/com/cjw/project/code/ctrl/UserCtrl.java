
 
	
package com.cjw.project.code.ctrl;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cjw.project.code.po.UserPO;
import com.cjw.project.code.service.UserService;
import com.cjw.project.tool.bean.Paged;
import com.cjw.project.tool.util.ObjectUtil;
import com.cjw.project.tool.util.UUIDUtil;
import com.cjw.project.tool.util.ajax.Response;
import com.cjw.project.tool.util.ajax.ResponseFactory;
import com.cjw.project.tool.web.MysqlDBException;
import com.cjw.project.tool.web.WebContext;


@Controller
@RequestMapping("/TUser") 
public class UserCtrl {

	@Autowired
	private UserService tUserService;
	
	@RequestMapping(value ="/queryPageTUser")
	@ResponseBody
	public Response<List<UserPO>> queryPageTUser(Integer page,Integer limit,HttpServletRequest request){
		Response<List<UserPO>> response = ResponseFactory.getDefaultSuccessResponse();
		Paged<UserPO> tUsers = null;
		
		UserPO condition=new UserPO();
        String id = request.getParameter("tUser_id");
		if(!ObjectUtil.isEmpty(id)) condition.setId(String.valueOf(id));
        String account = request.getParameter("tUser_account");
		if(!ObjectUtil.isEmpty(account)) condition.setAccount(String.valueOf(account));
        String username = request.getParameter("tUser_username");
		if(!ObjectUtil.isEmpty(username)) condition.setUsername(String.valueOf(username));
        String password = request.getParameter("tUser_password");
		if(!ObjectUtil.isEmpty(password)) condition.setPassword(String.valueOf(password));
        String userEmail = request.getParameter("tUser_userEmail");
		if(!ObjectUtil.isEmpty(userEmail)) condition.setUserEmail(String.valueOf(userEmail));
        String avatar = request.getParameter("tUser_avatar");
		if(!ObjectUtil.isEmpty(avatar)) condition.setAvatar(String.valueOf(avatar));
        String tel = request.getParameter("tUser_tel");
		if(!ObjectUtil.isEmpty(tel)) condition.setTel(String.valueOf(tel));
        String sex = request.getParameter("tUser_sex");
		if(!ObjectUtil.isEmpty(sex)) condition.setSex(String.valueOf(sex));
        String school = request.getParameter("tUser_school");
		if(!ObjectUtil.isEmpty(school)) condition.setSchool(String.valueOf(school));
        String address = request.getParameter("tUser_address");
		if(!ObjectUtil.isEmpty(address)) condition.setAddress(String.valueOf(address));
        String creatTime = request.getParameter("tUser_creatTime");
		if(!ObjectUtil.isEmpty(creatTime)) condition.setCreatTime(Long.valueOf(creatTime));
        String lastTime = request.getParameter("tUser_lastTime");
		if(!ObjectUtil.isEmpty(lastTime)) condition.setLastTime(Long.valueOf(lastTime));
        String loginIp = request.getParameter("tUser_loginIp");
		if(!ObjectUtil.isEmpty(loginIp)) condition.setLoginIp(String.valueOf(loginIp));
        String isAdmin = request.getParameter("tUser_isAdmin");
		if(!ObjectUtil.isEmpty(isAdmin)) condition.setIsAdmin(Integer.valueOf(isAdmin));
        String state = request.getParameter("tUser_state");
		if(!ObjectUtil.isEmpty(state)) condition.setState(Integer.valueOf(state));
        String lng = request.getParameter("tUser_lng");
		if(!ObjectUtil.isEmpty(lng)) condition.setLng(Double.valueOf(lng));
        String lat = request.getParameter("tUser_lat");
		if(!ObjectUtil.isEmpty(lat)) condition.setLat(Double.valueOf(lat));
        String qq = request.getParameter("tUser_qq");
		if(!ObjectUtil.isEmpty(qq)) condition.setQq(String.valueOf(qq));
        String wechat = request.getParameter("tUser_wechat");
		if(!ObjectUtil.isEmpty(wechat)) condition.setWechat(String.valueOf(wechat));
        String alipay = request.getParameter("tUser_alipay");
		if(!ObjectUtil.isEmpty(alipay)) condition.setAlipay(String.valueOf(alipay));
	
		try {
			tUsers = tUserService.queryPageTUser(page,limit,condition);
		} catch (MysqlDBException e) {
			e.printStackTrace();
			response.setError("网络连接失败，请检查网络");
		}
		response.setData(tUsers.getListData());
		response.setCount(tUserService.findAll().size());
		response.setResult(Response.RESULT_SUCCESS);
		return response;
		
	}
	
	@RequestMapping(value="/delTUser")
	@ResponseBody
	public Response<UserPO> delTUser(String id){
		Response<UserPO> response = ResponseFactory.getDefaultSuccessResponse();

		if (ObjectUtil.isEmpty(id)) {
			response.setError("id不能为空");
			return response;
		}
		
		try {
			tUserService.deleteTUserById(id);
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
	
	@RequestMapping(value="/findTUserById")
	@ResponseBody
	public Response<UserPO> findTUserById(){
		Response<UserPO> response =ResponseFactory.getDefaultSuccessResponse();
		UserPO userPO = (UserPO) WebContext.getSessionAttribute("userInfo");
		String id = userPO.getId();
		if (ObjectUtil.isEmpty(id)) {
			response.setError("id不能为空");
			return response;
		}
		try {
			response.setData(tUserService.getTUserById(id));
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
	
	@RequestMapping(value="/findTUser")
	@ResponseBody
	public Response<UserPO> findTUser(String id){
		Response<UserPO> response =ResponseFactory.getDefaultSuccessResponse();
		if (ObjectUtil.isEmpty(id)) {
			response.setError("id不能为空");
			return response;
		}
		try {
			response.setData(tUserService.getTUserById(id));
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
	
	@RequestMapping(value="/updateTUserById")
	@ResponseBody
	public Response<UserPO> updateTUserById(HttpServletRequest request){
		Response<UserPO> response =ResponseFactory.getDefaultSuccessResponse();
		UserPO condition=new UserPO();
        String id = request.getParameter("tUser_id");
		if(!ObjectUtil.isEmpty(id)) condition.setId(String.valueOf(id));
        String account = request.getParameter("tUser_account");
		if(!ObjectUtil.isEmpty(account)) condition.setAccount(String.valueOf(account));
        String username = request.getParameter("tUser_username");
		if(!ObjectUtil.isEmpty(username)) condition.setUsername(String.valueOf(username));
        String password = request.getParameter("tUser_password");
		if(!ObjectUtil.isEmpty(password)) condition.setPassword(String.valueOf(password));
        String userEmail = request.getParameter("tUser_userEmail");
		if(!ObjectUtil.isEmpty(userEmail)) condition.setUserEmail(String.valueOf(userEmail));
        String avatar = request.getParameter("tUser_avatar");
		if(!ObjectUtil.isEmpty(avatar)) condition.setAvatar(String.valueOf(avatar));
        String tel = request.getParameter("tUser_tel");
		if(!ObjectUtil.isEmpty(tel)) condition.setTel(String.valueOf(tel));
        String sex = request.getParameter("tUser_sex");
		if(!ObjectUtil.isEmpty(sex)) condition.setSex(String.valueOf(sex));
        String school = request.getParameter("tUser_school");
		if(!ObjectUtil.isEmpty(school)) condition.setSchool(String.valueOf(school));
        String address = request.getParameter("tUser_address");
		if(!ObjectUtil.isEmpty(address)) condition.setAddress(String.valueOf(address));
        String creatTime = request.getParameter("tUser_creatTime");
		if(!ObjectUtil.isEmpty(creatTime)) condition.setCreatTime(Long.valueOf(creatTime));
        String lastTime = request.getParameter("tUser_lastTime");
		if(!ObjectUtil.isEmpty(lastTime)) condition.setLastTime(Long.valueOf(lastTime));
        String loginIp = request.getParameter("tUser_loginIp");
		if(!ObjectUtil.isEmpty(loginIp)) condition.setLoginIp(String.valueOf(loginIp));
        String isAdmin = request.getParameter("tUser_isAdmin");
		if(!ObjectUtil.isEmpty(isAdmin)) condition.setIsAdmin(Integer.valueOf(isAdmin));
        String state = request.getParameter("tUser_state");
		if(!ObjectUtil.isEmpty(state)) condition.setState(Integer.valueOf(state));
        String lng = request.getParameter("tUser_lng");
		if(!ObjectUtil.isEmpty(lng)) condition.setLng(Double.valueOf(lng));
        String lat = request.getParameter("tUser_lat");
		if(!ObjectUtil.isEmpty(lat)) condition.setLat(Double.valueOf(lat));
        String qq = request.getParameter("tUser_qq");
		if(!ObjectUtil.isEmpty(qq)) condition.setQq(String.valueOf(qq));
        String wechat = request.getParameter("tUser_wechat");
		if(!ObjectUtil.isEmpty(wechat)) condition.setWechat(String.valueOf(wechat));
        String alipay = request.getParameter("tUser_alipay");
		if(!ObjectUtil.isEmpty(alipay)) condition.setAlipay(String.valueOf(alipay));
		
		if (ObjectUtil.isEmpty(condition.getId())) {
			response.setError("id不能为空");
			return response;
		}

		try {
			tUserService.updateTUser(condition);
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
	
	@RequestMapping(value="/addTUser")
	@ResponseBody
	public Response<UserPO> addTUser(HttpServletRequest request){
		Response<UserPO> response =ResponseFactory.getDefaultSuccessResponse();
		
		UserPO po=new UserPO();
		po.setId(UUIDUtil.getUUID());
        String id = request.getParameter("tUser_id");
		if(!ObjectUtil.isEmpty(id)) po.setId(String.valueOf(id));
        String account = request.getParameter("tUser_account");
		if(!ObjectUtil.isEmpty(account)) po.setAccount(String.valueOf(account));
        String username = request.getParameter("tUser_username");
		if(!ObjectUtil.isEmpty(username)) po.setUsername(String.valueOf(username));
        String password = request.getParameter("tUser_password");
		if(!ObjectUtil.isEmpty(password)) po.setPassword(String.valueOf(password));
        String userEmail = request.getParameter("tUser_userEmail");
		if(!ObjectUtil.isEmpty(userEmail)) po.setUserEmail(String.valueOf(userEmail));
        String avatar = request.getParameter("tUser_avatar");
		if(!ObjectUtil.isEmpty(avatar)) po.setAvatar(String.valueOf(avatar));
        String tel = request.getParameter("tUser_tel");
		if(!ObjectUtil.isEmpty(tel)) po.setTel(String.valueOf(tel));
        String sex = request.getParameter("tUser_sex");
		if(!ObjectUtil.isEmpty(sex)) po.setSex(String.valueOf(sex));
        String school = request.getParameter("tUser_school");
		if(!ObjectUtil.isEmpty(school)) po.setSchool(String.valueOf(school));
        String address = request.getParameter("tUser_address");
		if(!ObjectUtil.isEmpty(address)) po.setAddress(String.valueOf(address));
        String creatTime = request.getParameter("tUser_creatTime");
		if(!ObjectUtil.isEmpty(creatTime)) po.setCreatTime(Long.valueOf(creatTime));
        String lastTime = request.getParameter("tUser_lastTime");
		if(!ObjectUtil.isEmpty(lastTime)) po.setLastTime(Long.valueOf(lastTime));
        String loginIp = request.getParameter("tUser_loginIp");
		if(!ObjectUtil.isEmpty(loginIp)) po.setLoginIp(String.valueOf(loginIp));
        String isAdmin = request.getParameter("tUser_isAdmin");
		if(!ObjectUtil.isEmpty(isAdmin)) po.setIsAdmin(Integer.valueOf(isAdmin));
        String state = request.getParameter("tUser_state");
		if(!ObjectUtil.isEmpty(state)) po.setState(Integer.valueOf(state));
        String lng = request.getParameter("tUser_lng");
		if(!ObjectUtil.isEmpty(lng)) po.setLng(Double.valueOf(lng));
        String lat = request.getParameter("tUser_lat");
		if(!ObjectUtil.isEmpty(lat)) po.setLat(Double.valueOf(lat));
        String qq = request.getParameter("tUser_qq");
		if(!ObjectUtil.isEmpty(qq)) po.setQq(String.valueOf(qq));
        String wechat = request.getParameter("tUser_wechat");
		if(!ObjectUtil.isEmpty(wechat)) po.setWechat(String.valueOf(wechat));
        String alipay = request.getParameter("tUser_alipay");
		if(!ObjectUtil.isEmpty(alipay)) po.setAlipay(String.valueOf(alipay));
		
		try {
			tUserService.addTUser(po);
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
	
	/**
	 * 上传头像
	 * @param file
	 * @param request
	 * @return
	 */
	@RequestMapping("/upload")
	@ResponseBody
	public Response<UserPO> uplpad(@RequestParam MultipartFile file, HttpServletRequest request) {
		Response<UserPO> response =ResponseFactory.getDefaultSuccessResponse();
		UserPO po = new UserPO();
		String desFilePath = "";
		String oriName = "";
		Map<String, String> dataMap = new HashMap<>();
		try {
			// 1.获取原文件名
			oriName = file.getOriginalFilename();
			// 2.获取原文件图片后缀，以最后的.作为截取(.jpg)
			String extName = oriName.substring(oriName.lastIndexOf("."));
			// 3.生成自定义的新文件名，这里以UUID.jpg|png|xxx作为格式（可选操作，也可以不自定义新文件名）
			String uuid = UUIDUtil.getSortUUID();
			String newName = uuid + extName;
			// 4.获取要保存的路径文件夹
			String realPath = "E:/images";
//			String realPath = "/secondImages";
			// 5.保存图片
			desFilePath = realPath + "/" + newName;
			File desFile = new File(desFilePath);
			file.transferTo(desFile);
			System.out.println(desFilePath);
			po.setAvatar("/" + newName);
			// 6.返回保存结果信息
			dataMap = new HashMap<>();
			dataMap.put("src", "resources/imgs/" + newName);
		} catch (IllegalStateException e) {
			System.out.println(desFilePath + "图片保存失败");
		} catch (IOException e) {
			System.out.println(desFilePath + "图片保存失败--IO异常");
		}
		response.setData(po);
		return response;
	}
}
