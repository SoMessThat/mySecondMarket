package com.cjw.project.code.ctrl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
import org.springframework.web.servlet.ModelAndView;

import com.cjw.project.code.po.CommodityPO;
import com.cjw.project.code.po.DemandPO;
import com.cjw.project.code.po.UserPO;
import com.cjw.project.code.service.CommodityService;
import com.cjw.project.code.service.DemandService;
import com.cjw.project.code.service.UserService;
import com.cjw.project.code.vo.CommiditionVO;
import com.cjw.project.code.vo.CountCommiditionVO;
import com.cjw.project.code.vo.MessageVO;
import com.cjw.project.tool.bean.Paged;
import com.cjw.project.tool.util.ObjectUtil;
import com.cjw.project.tool.util.UUIDUtil;
import com.cjw.project.tool.util.ajax.Response;
import com.cjw.project.tool.util.ajax.ResponseFactory;
import com.cjw.project.tool.web.MysqlDBException;
import com.cjw.project.tool.web.WebContext;


@Controller
@RequestMapping("/TCommodity") 
public class CommodityCtrl {

	@Autowired
	private CommodityService tCommodityService;
	@Autowired
	private UserService userService;
	@Autowired
	private DemandService demandService;
	@RequestMapping(value ="/queryPageTCommodity")
	@ResponseBody
	public Response<List<CommodityPO>> queryPageTCommodity(Integer page,Integer limit,HttpServletRequest request){
		Response<List<CommodityPO>> response = ResponseFactory.getDefaultSuccessResponse();
		Paged<CommodityPO> tCommoditys = new Paged<CommodityPO>();
		
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
		String type = request.getParameter("type");
		if(!ObjectUtil.isEmpty(type)){
			if ("关注".equals(type)) {
				UserPO user = (UserPO) WebContext.getSessionAttribute("userInfo");
				tCommoditys = tCommodityService.queryAttendCommodity(page,limit,user.getId());
			}else if ("收购".equals(type)) {
				try {
					Paged<DemandPO> demand = demandService.queryPageTDemand(page, limit, new DemandPO());
//					ObjectUtil.copyPorperties(demand, tCommoditys);
					List<CommodityPO> a = new ArrayList<CommodityPO>();
					for (DemandPO po : demand.getListData()) {
						CommodityPO com =new CommodityPO();
						com.setInfo(po.getInfo());
						com.setName(po.getName());
						com.setPrice(Double.parseDouble(po.getPrice()+""));
						a.add(com);
					}
					tCommoditys.setListData(a);
				} catch (MysqlDBException e) {
					e.printStackTrace();
				}
			}else if ("搜索".equals(type)) {
				String key = request.getParameter("key");
				tCommoditys = tCommodityService.searchByKey(page,limit,key);
			}
			else {
				map.put("type", type);
				try {
					tCommoditys = tCommodityService.queryPageTCommodity(page,limit,map);
				} catch (MysqlDBException e) {
					e.printStackTrace();
					response.setError("网络连接失败，请检查网络");
				}
			}
		}else {
			try {
				tCommoditys = tCommodityService.queryPageTCommodity(page,limit,map);
			} catch (MysqlDBException e) {
				e.printStackTrace();
				response.setError("网络连接失败，请检查网络");
			}
		}
		response.setData(tCommoditys.getListData());
		response.setCount(tCommoditys.getTotalHit());
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
        String id = request.getParameter("id");
		if(!ObjectUtil.isEmpty(id)) condition.setId(String.valueOf(id));
        String name = request.getParameter("name");
		if(!ObjectUtil.isEmpty(name)) condition.setName(String.valueOf(name));
        String category = request.getParameter("category");
		if(!ObjectUtil.isEmpty(category)) condition.setCategory(String.valueOf(category));
        String info = request.getParameter("info");
		if(!ObjectUtil.isEmpty(info)) condition.setInfo(String.valueOf(info));
        String pop = request.getParameter("pop");
		if(!ObjectUtil.isEmpty(pop)) condition.setPop(Integer.valueOf(pop));
        String pictureId = request.getParameter("pictureId");
		if(!ObjectUtil.isEmpty(pictureId)) condition.setPictureId(String.valueOf(pictureId));
        String price = request.getParameter("price");
		if(!ObjectUtil.isEmpty(price)) condition.setPrice(Double.valueOf(price));
        String secprice = request.getParameter("secprice");
		if(!ObjectUtil.isEmpty(secprice)) condition.setSecprice(Double.valueOf(secprice));
        String conditions = request.getParameter("conditions");
		if(!ObjectUtil.isEmpty(conditions)) condition.setConditions(String.valueOf(conditions));
        String messageId = request.getParameter("messageId");
		if(!ObjectUtil.isEmpty(messageId)) condition.setMessageId(String.valueOf(messageId));
        String num = request.getParameter("num");
		if(!ObjectUtil.isEmpty(num)) condition.setNum(Integer.valueOf(num));
        String sellerId = request.getParameter("sellerId");
		if(!ObjectUtil.isEmpty(sellerId)) condition.setSellerId(String.valueOf(sellerId));
        String buyerId = request.getParameter("buyerId");
		if(!ObjectUtil.isEmpty(buyerId)) condition.setBuyerId(String.valueOf(buyerId));
        String creartTime = request.getParameter("creartTime");
		if(!ObjectUtil.isEmpty(creartTime)) condition.setCreartTime(Long.valueOf(creartTime));
        String closingTime = request.getParameter("closingTime");
		if(!ObjectUtil.isEmpty(closingTime)) condition.setClosingTime(Long.valueOf(closingTime));
        String state = request.getParameter("state");
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
        String name = request.getParameter("name");
		if(!ObjectUtil.isEmpty(name)) po.setName(String.valueOf(name));
        String category = request.getParameter("category");
		if(!ObjectUtil.isEmpty(category)) po.setCategory(String.valueOf(category));
        String info = request.getParameter("info");
		if(!ObjectUtil.isEmpty(info)) po.setInfo(String.valueOf(info));
        po.setPop(0);
        po.setPictureId(UUIDUtil.getUUID());
        String price = request.getParameter("price");
		if(!ObjectUtil.isEmpty(price)) po.setPrice(Double.valueOf(price));
        String secprice = request.getParameter("secprice");
		if(!ObjectUtil.isEmpty(secprice)) po.setSecprice(Double.valueOf(secprice));
        String conditions = request.getParameter("conditions");
		if(!ObjectUtil.isEmpty(conditions)) po.setConditions(String.valueOf(conditions));
        String messageId = request.getParameter("messageId");
		if(!ObjectUtil.isEmpty(messageId)) po.setMessageId(String.valueOf(messageId));
        String num = request.getParameter("num");
		if(!ObjectUtil.isEmpty(num)) po.setNum(Integer.valueOf(num));
        String sellerId = request.getParameter("sellerId");
		if(!ObjectUtil.isEmpty(sellerId)) po.setSellerId(String.valueOf(sellerId));
        String buyerId = request.getParameter("buyerId");
		if(!ObjectUtil.isEmpty(buyerId)) po.setBuyerId(String.valueOf(buyerId));
        String creartTime = request.getParameter("creartTime");
		if(!ObjectUtil.isEmpty(creartTime)) po.setCreartTime(Long.valueOf(creartTime));
        String closingTime = request.getParameter("closingTime");
		if(!ObjectUtil.isEmpty(closingTime)) po.setClosingTime(Long.valueOf(closingTime));
        String state = request.getParameter("state");
		if(!ObjectUtil.isEmpty(state)) po.setState(String.valueOf(state));
		String address = request.getParameter("address");
		try {
			tCommodityService.addTCommodity(po,address);
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
	
	/**
	 * 上传图片
	 * @param file
	 * @param request
	 * @return
	 */
	@RequestMapping("/upload")
	@ResponseBody
	public Response<CommodityPO> uplpad(@RequestParam MultipartFile file, HttpServletRequest request) {
		Response<CommodityPO> response =ResponseFactory.getDefaultSuccessResponse();
		CommodityPO po = new CommodityPO();
		String desFilePath = "";
		String oriName = "";
		Map<String, String> dataMap = new HashMap<>();
		try {
			// 1.获取原文件名
			oriName = file.getOriginalFilename();
			// 2.获取原文件图片后缀，以最后的.作为截取(.jpg)
			String extName = oriName.substring(oriName.lastIndexOf("."));
			// 3.生成自定义的新文件名，这里以UUID.jpg|png|xxx作为格式（可选操作，也可以不自定义新文件名）
			String uuid = UUIDUtil.getUUID();
			String newName = uuid + extName;
			// 4.获取要保存的路径文件夹
			String realPath = "E:/images";
//			String realPath = "/secondImages";
			// 5.保存图片
			desFilePath = realPath + "/" + newName;
			File desFile = new File(desFilePath);
			file.transferTo(desFile);
			System.out.println(desFilePath);
			po.setName("/" + newName);
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

	/**
	 * 统计售卖商品数，收藏数等
	 * @createTime: 2018年10月10日 上午9:29:57
	 * @author: wu.kaibin
	 * @param sellerId
	 * @return
	 */
	@RequestMapping(value="/countCommodity")
	@ResponseBody
	public Response<CountCommiditionVO> countCommodity(String sellerId){
		Response<CountCommiditionVO> response =ResponseFactory.getDefaultSuccessResponse();
		if (ObjectUtil.isEmpty(sellerId)) {
			response.setError("id不能为空");
			return response;
		}
		try {
			response.setData(tCommodityService.countCommodity(sellerId));
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
	
	/**
	 * 查看商品详细信息
	 * @createTime: 2018年10月10日 上午9:29:57
	 * @author: wu.kaibin
	 * @return
	 */
	@RequestMapping(value = "/info")
	public ModelAndView info(String id) {
		ModelAndView mv = new ModelAndView();
		if (ObjectUtil.isEmpty(id)) {
			mv.setViewName("commoditionInfo");
			return mv;
		}
		try {
			CommodityPO commodity = tCommodityService.getTCommodityById(id);
			mv.addObject("commodity", commodity);
			mv.addObject("seller", userService.getTUserById(commodity.getSellerId()));
		} catch (MysqlDBException e) {
			e.printStackTrace();
		}
		UserPO userPO = (UserPO) WebContext.getSessionAttribute("userInfo");
		mv.addObject("user", userPO);
		mv.setViewName("commoditionInfo");
		return mv;
		
	}
	
	/**
	 * 留言信息
	 * @createTime: 2018年10月10日 上午9:29:57
	 * @author: wu.kaibin
	 * @param sellerId
	 * @return
	 */
	@RequestMapping(value="/queryMessage")
	@ResponseBody
	public Response<List<MessageVO>> queryMessage(HttpServletRequest request){
		Response<List<MessageVO>> response =ResponseFactory.getDefaultSuccessResponse();
		String commodityId= request.getParameter("commodityId");
		try {
			List<MessageVO> a = tCommodityService.queryMessage(commodityId);
			response.setData(a);	
//			return a;
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
//			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
//		return null;
	}
	
	/**
	 * 商品信息
	 * @createTime: 2018年10月10日 上午9:29:57
	 * @author: wu.kaibin
	 * @param sellerId
	 * @return
	 */
	@RequestMapping(value="/queryCommodity")
	@ResponseBody
	public Response<CommiditionVO> queryCommodity(HttpServletRequest request){
		Response<CommiditionVO> response =ResponseFactory.getDefaultSuccessResponse();
		String commodityId= request.getParameter("commodityId");
		CommiditionVO a = tCommodityService.queryCommodity(commodityId);
		response.setData(a);	
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}

}