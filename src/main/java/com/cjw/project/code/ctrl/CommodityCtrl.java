package com.cjw.project.code.ctrl;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.cjw.project.code.po.CommodityPO;
import com.cjw.project.code.po.UserPO;
import com.cjw.project.code.service.CommodityService;
import com.cjw.project.code.vo.CommiditionVO;
import com.cjw.project.code.vo.CountCommiditionVO;
import com.cjw.project.code.vo.MessageVO;
import com.cjw.project.tool.bean.Paged;
import com.cjw.project.tool.util.ObjectUtil;
import com.cjw.project.tool.util.UUIDUtil;
import com.cjw.project.tool.util.ajax.Response;
import com.cjw.project.tool.util.ajax.ResponseFactory;
import com.cjw.project.tool.util.alipay.AlipayConfig;
import com.cjw.project.tool.web.MysqlDBException;
import com.cjw.project.tool.web.WebContext;


@Controller
@RequestMapping("/TCommodity") 
public class CommodityCtrl {

	@Autowired
	private CommodityService tCommodityService;
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
				map.put("sellerId",user.getId());
				tCommoditys = tCommodityService.queryAttendCommodity(page,limit,user.getId());
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
	
	@RequestMapping(value ="/queryMyPageTCommodity")
	@ResponseBody
	public Response<List<CommodityPO>> queryMyPageTCommodity(Integer page,Integer limit,HttpServletRequest request){
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
		String buyerId = request.getParameter("tCommodity_buyerId");
		if(!ObjectUtil.isEmpty(buyerId)) map.put("buyerId",buyerId);
		String creartTime = request.getParameter("tCommodity_creartTime");
		if(!ObjectUtil.isEmpty(creartTime)) map.put("creartTime",creartTime);
		String closingTime = request.getParameter("tCommodity_closingTime");
		if(!ObjectUtil.isEmpty(closingTime)) map.put("closingTime",closingTime);
		String state = request.getParameter("tCommodity_state");
		if(!ObjectUtil.isEmpty(state)) map.put("state",state);
		try {
			UserPO user = (UserPO) WebContext.getSessionAttribute("userInfo");
			map.put("sellerId",user.getId());
			tCommoditys = tCommodityService.queryPageTCommodity(page,limit,map);
		} catch (MysqlDBException e) {
			e.printStackTrace();
			response.setError("网络连接失败，请检查网络");
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
	public Response<CommiditionVO> findTCommodityById(String id){
		Response<CommiditionVO> response =ResponseFactory.getDefaultSuccessResponse();
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
	public Response<CountCommiditionVO> countCommodity(){
		Response<CountCommiditionVO> response =ResponseFactory.getDefaultSuccessResponse();
		try {
			UserPO user = (UserPO) WebContext.getSessionAttribute("userInfo");
			response.setData(tCommodityService.countCommodity(user.getId()));
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
			CommiditionVO commodity = tCommodityService.getTCommodityById(id);
			mv.addObject("commodity", commodity);
			mv.addObject("seller", commodity.getSeller());
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

	
	@RequestMapping(value="/pay", method={RequestMethod.POST})
    public ModelAndView pay(ModelMap map,HttpServletRequest httpRequest,
            HttpServletResponse httpResponse,String rechargeMon) throws Exception{
        //获得初始化的AlipayClient
		ModelAndView mv = new ModelAndView();
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.URL, AlipayConfig.APPID, AlipayConfig.RSA_PRIVATE_KEY, "json", AlipayConfig.CHARSET, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.SIGNTYPE);
        AlipayTradeAppPayRequest alipayRequest=new AlipayTradeAppPayRequest();
        //设置同步回调地址    
      alipayRequest.setReturnUrl(AlipayConfig.return_url);
      //设置异步回调地址
      alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
      //公共回传参数，用于传值自定义信息，必须encode，不能带单双引号之类的之定义参数，否则会报错
      String passback_params   = "公用回传参数测试123#34！";
      String passback_params2 =URLEncoder.encode(passback_params,"UTF-8");

      //    alipayRequest.setBizContent("{\\"out_trade_no\\":\\"201809251015343222843\\"," 
//          + "\\"total_amount\\":\\"0.01\\"," 
//          + "\\"subject\\":\\"app支付测试\\"," 
//          + "\\"passback_params\\":\\""+ passback_params2 +"\\"," 
//          + "\\"product_code\\":\\"QUICK_MSECURITY_PAY\\"}");
       AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
       model.setOutTradeNo("20181012015343222843");
       model.setTotalAmount("0.01");
       model.setSubject("app支付subject测试");
       model.setPassbackParams(passback_params2);
       model.setProductCode("QUICK_MSECURITY_PAY");
       alipayRequest.setBizModel(model);
      AlipayTradeAppPayResponse response = alipayClient.sdkExecute(alipayRequest);
      
      if(response.isSuccess()){
        System.out.println("调用成功");
      } else {
        System.out.println("调用失败");
      }
      String form = response.getBody();
      mv.addObject("result",form);
      mv.setViewName("alipay");
      return mv;
    }
//	/**
//     * pc端同步通知
//     * @param
//     * @return  String
//     * @throws  Exception
//     * @author  zhangyn
//     * @date    2017年6月29日 下午9:45:30
//     */
//    @RequestMapping(value="/returnUrl")
//    public String returnUrl(ModelMap map, HttpServletRequest request, HttpServletResponse response) throws Exception{
//        System.err.println("------------------------------------pc同步通知-------------------------------------------");
//        //获取支付宝GET过来反馈信息
//        Map<String,String> params = new HashMap<String,String>();
//        Map<String,String[]> requestParams = request.getParameterMap();
//        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
//            String name = (String) iter.next();
//            String[] values = (String[]) requestParams.get(name);
//            String valueStr = "";
//            for (int i = 0; i < values.length; i++) {
//                valueStr = (i == values.length - 1) ? valueStr + values[i]
//                        : valueStr + values[i] + ",";
//            }
//            //乱码解决，这段代码在出现乱码时使用
//            //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
//            params.put(name, valueStr);
//        }
//        
//        boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.CHARSET, AlipayConfig.SIGNTYPE); //调用SDK验证签名
//
//        //——请在这里编写您的程序（以下代码仅作参考）——
//        if(signVerified) {
//            //商户订单号
//            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
//        
//            //支付宝交易号
//            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
//        
//            //付款金额
//            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"),"UTF-8");
//            response.setContentType("text/html;charset=" + .CHARSET); 
//            System.err.println("-----------------out_trade_no:"+out_trade_no+"trade_no:"+trade_no+"total_amount:"+total_amount+"---------------------");
//            map.put("alipayResult", "支付宝充值成功");
//        }else {
//            response.setContentType("text/html;charset=" + AlipayConfig.CHARSET); 
//            map.put("alipayResult", "支付宝充值失败");
//        }
//        //——请在这里编写您的程序（以上代码仅作参考）——
//         return "alipayResult";
//    }
//    
//    /**
//     * pc端异步通知
//     * @param
//     * @return  String
//     * @throws  Exception
//     * @author  zhangyn
//     * @date    2017年6月29日 下午9:45:17
//     */
//    @RequestMapping(value="/notifyUrl",method=RequestMethod.POST)
//    public void notifyUrl(ModelMap map, HttpServletRequest request, HttpServletResponse response) throws Exception{
//        try {
//            System.err.println("------------------------------------pc异步通知-------------------------------------------");
//            //获取支付宝POST过来反馈信息
//            Map<String,String> params = new HashMap<String,String>();
//            Map<String,String[]> requestParams = request.getParameterMap();
//            for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
//                String name = (String) iter.next();
//                String[] values = (String[]) requestParams.get(name);
//                String valueStr = "";
//                for (int i = 0; i < values.length; i++) {
//                    valueStr = (i == values.length - 1) ? valueStr + values[i]
//                            : valueStr + values[i] + ",";
//                }
//                //乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化。
//                //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "UTF-8");
//                params.put(name, valueStr);
//            }
//            //System.err.println("---------------------------------------------------------------params=========="+params);
//            //获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
//                //商户订单号
//
//                String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
//                //支付宝交易号
//
//                String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
//
//                //交易状态
//                String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");
//
//                //获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//
//                //计算得出通知验证结果
//                //boolean AlipaySignature.rsaCheckV1(Map<String, String> params, String publicKey, String charset, String sign_type)
//                boolean verify_result = AlipaySignature.rsaCheckV1(params, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.CHARSET, "RSA2");
//                System.err.println("------------------------------------------支付宝异步通知页面验证成功：trade_finished------------------------------verify_result="+verify_result);
//                if(verify_result){//验证成功
//                    //////////////////////////////////////////////////////////////////////////////////////////
//                    //请在这里加上商户的业务逻辑程序代码
//
//                    //——请根据您的业务逻辑来编写程序（以下代码仅作参考）——
//                    
//                    if(trade_status.equals("TRADE_FINISHED")){
//                        //判断该笔订单是否在商户网站中已经做过处理
//                            //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
//                            //请务必判断请求时的total_fee、seller_id与通知时获取的total_fee、seller_id为一致的
//                            //如果有做过处理，不执行商户的业务程序
//                        System.err.println("------------------------------------------支付宝异步通知页面验证成功：trade_finished------------------------------");
//                        //注意：
//                        //如果签约的是可退款协议，退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
//                        //如果没有签约可退款协议，那么付款完成后，支付宝系统发送该交易状态通知。
//                    } else if (trade_status.equals("TRADE_SUCCESS")){
//                        //判断该笔订单是否在商户网站中已经做过处理
//                            //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
//                            //请务必判断请求时的total_fee、seller_id与通知时获取的total_fee、seller_id为一致的
//                            //如果有做过处理，不执行商户的业务程序
//                        System.err.println("------------------------------------------支付宝异步通知页面验证成功：trade_success------------------------------");
//                        //注意：
//                        //如果签约的是可退款协议，那么付款完成后，支付宝系统发送该交易状态通知。
//                    }
//                    //——请根据您的业务逻辑来编写程序（以上代码仅作参考）——
//                    response.getWriter().println("success");
//                    response.getWriter().close();
//                    //////////////////////////////////////////////////////////////////////////////////////////
//                }else{//验证失败
//                    response.getWriter().println("fail");
//                    response.getWriter().close();
//                    System.err.println("-------------------------------fail-------------------------------");
//                }
//        } catch (Exception e) {
//            response.getWriter().println("fail");
//            response.getWriter().close();
//            System.err.println("跳转到pc网站支付宝支付-同步不通知-页面-error");
//            e.printStackTrace();
//        }
//    }
}