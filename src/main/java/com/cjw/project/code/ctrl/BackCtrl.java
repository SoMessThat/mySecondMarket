package com.cjw.project.code.ctrl;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cjw.project.code.dao.SmartQueueTimesDAO;
import com.cjw.project.code.dao.testDAO;
import com.cjw.project.code.po.UserPO;
import com.cjw.project.code.po.testPO;
import com.cjw.project.code.service.UserService;
import com.cjw.project.tool.util.ObjectUtil;
import com.cjw.project.tool.util.code.MD5;
import com.cjw.project.tool.web.MysqlDBException;
import com.cjw.project.tool.web.WebContext;

 
@Controller
@RequestMapping(value = "login")
public class BackCtrl{

	@Autowired
	UserService TuserService;
	
	/**
	 * 登陆	
	 * @createTime: 2018年10月10日 上午9:29:48
	 * @author: wu.kaibin
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/index")
	public ModelAndView login(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		String account = request.getParameter("TPL_username");
		String password = request.getParameter("TPL_password");
//		Long loginTime = Long.parseLong(request.getParameter("loginTime"));
		if (ObjectUtil.isEmpty(account)) {
			mv.addObject("erro", "账号不能为空");
			mv.setViewName("login");
			return mv;
		}
		if (ObjectUtil.isEmpty(password)) {
			mv.addObject("erro", "密码不能为空");
			mv.setViewName("login");
			return mv;
		}
//		if (ObjectUtil.isEmpty(loginTime)) {
//			mv.addObject("erro", "网络错误，请重新登录");
//			mv.setViewName("../login");
//			return mv;
//		}
		UserPO user = new UserPO();
		user.setPassword(MD5.MD5Encode(password));
		System.out.println(MD5.MD5Encode(password));
		user.setAccount(account);
		//对比密码
		try {
			UserPO TUserPO=TuserService.getTUserByParam(user);
			if(!ObjectUtil.isEmpty(TUserPO)){
//				TUserPO.setLastTime(loginTime);
				TuserService.updateTUser(TUserPO);
//				if (TUserPO.getStatue()!=1) {
//					mv.addObject("erro", "网络错误，请重新登录");
//					mv.setViewName("../login");//img.alicdn.com/tfs/TB1AApbnxnaK1RjSZFBXXcW7VXa-140-140.png
//					return mv;
//				}
				if (TUserPO.getIsAdmin()==1) {
					mv.addObject("user", TUserPO);
					mv.setViewName("index");
				}
				else {
					mv.setViewName("usermain");
				}
				System.out.println(TUserPO);
				WebContext.setSessionAttribute("userInfo", TUserPO);
			}else{
				mv.addObject("erro", "账号或密码错误");
				mv.setViewName("login");
			}
		} catch (MysqlDBException e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	/**
	 * 登陆界面路口
	 * @createTime: 2018年10月10日 上午9:29:57
	 * @author: wu.kaibin
	 * @return
	 */
	@RequestMapping(value = "/main")
	public ModelAndView main() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}

	@Autowired testDAO testdao;
	@Autowired SmartQueueTimesDAO smart;
	@RequestMapping(value = "/test")
	public ModelAndView test() {
		ModelAndView mv = new ModelAndView();
		List<testPO> a = testdao.queryinhtime();
		if (a.size()>10) {
			mv.setViewName("index");
		}
		else
			mv.setViewName("login");
		Format f = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String oldtel="1532132132-929722";
		int i=0;
		Date oldate=new Date();
//		a.add(new testPO());
		for (testPO testPO : a) {
			//			//多一条数据
			if (testPO.getCallerno().equals(oldtel)) {
				i+=testPO.getTimes();
//				if (testPO.getDevicetype()==2) {
//					i=0;	
//				}
//				if (testPO.getDevicetype()==1) {
//					i+=testPO.getTimes();
//				}
//					i=0;
//					if (testPO.getCallidnum()!=-1) {
//						flag=true;
//					}
//				}
//				if (testPO.getDevicetype()==3) {
//					if (testPO.getCallidnum()==-1) {
//						//如果找到id相等并且有type有2得的就跳过；否则加1
//						if (flag) {
//							i=0;
//							flag=false;
//						}
//						else {
//							i++;
//						}
//					}
//					else
//						i++;
//				}
			}
			else {
				smart.modify(oldtel, i,f.format(oldate));
//				flag=false;
//				SmartQueueTimesPO po =new SmartQueueTimesPO();
//				po.setCallerno(oldtel);
//				po.setQueueTimes(i);
//				smart.insert(po);
//				
				oldtel=testPO.getCallerno();
				i=testPO.getTimes();
				oldate=testPO.getWaitbegin();
			}
		}
		return mv;
	}
	
}
