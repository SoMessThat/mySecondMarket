
 
	
package com.cjw.project.code.ctrl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cjw.project.code.po.OrderPO;
import com.cjw.project.code.service.OrderService;
import com.cjw.project.tool.bean.Paged;
import com.cjw.project.tool.util.ObjectUtil;
import com.cjw.project.tool.util.UUIDUtil;
import com.cjw.project.tool.util.ajax.Response;
import com.cjw.project.tool.util.ajax.ResponseFactory;
import com.cjw.project.tool.web.MysqlDBException;


@Controller
@RequestMapping("/TOrder") 
public class OrderCtrl {

	@Autowired
	private OrderService tOrderService;
	
	@RequestMapping(value ="/queryPageTOrder")
	@ResponseBody
	public Response<List<OrderPO>> queryPageTOrder(Integer page,Integer limit,HttpServletRequest request){
		Response<List<OrderPO>> response = ResponseFactory.getDefaultSuccessResponse();
		Paged<OrderPO> tOrders = null;
		
		OrderPO condition=new OrderPO();
        String id = request.getParameter("tOrder_id");
		if(!ObjectUtil.isEmpty(id)) condition.setId(String.valueOf(id));
        String commodityId = request.getParameter("tOrder_commodityId");
		if(!ObjectUtil.isEmpty(commodityId)) condition.setCommodityId(String.valueOf(commodityId));
        String pictureId = request.getParameter("tOrder_pictureId");
		if(!ObjectUtil.isEmpty(pictureId)) condition.setPictureId(String.valueOf(pictureId));
        String price = request.getParameter("tOrder_price");
		if(!ObjectUtil.isEmpty(price)) condition.setPrice(Double.valueOf(price));
        String num = request.getParameter("tOrder_num");
		if(!ObjectUtil.isEmpty(num)) condition.setNum(Integer.valueOf(num));
        String sellerId = request.getParameter("tOrder_sellerId");
		if(!ObjectUtil.isEmpty(sellerId)) condition.setSellerId(String.valueOf(sellerId));
        String buyerId = request.getParameter("tOrder_buyerId");
		if(!ObjectUtil.isEmpty(buyerId)) condition.setBuyerId(String.valueOf(buyerId));
        String creartTime = request.getParameter("tOrder_creartTime");
		if(!ObjectUtil.isEmpty(creartTime)) condition.setCreartTime(Long.valueOf(creartTime));
        String payTime = request.getParameter("tOrder_payTime");
		if(!ObjectUtil.isEmpty(payTime)) condition.setPayTime(Long.valueOf(payTime));
        String state = request.getParameter("tOrder_state");
		if(!ObjectUtil.isEmpty(state)) condition.setState(String.valueOf(state));
        String address = request.getParameter("tOrder_address");
		if(!ObjectUtil.isEmpty(address)) condition.setAddress(String.valueOf(address));
        String isSign = request.getParameter("tOrder_isSign");
		if(!ObjectUtil.isEmpty(isSign)) condition.setIsSign(Integer.valueOf(isSign));
        String isPay = request.getParameter("tOrder_isPay");
		if(!ObjectUtil.isEmpty(isPay)) condition.setIsPay(Integer.valueOf(isPay));
        String logisticsCode = request.getParameter("tOrder_logisticsCode");
		if(!ObjectUtil.isEmpty(logisticsCode)) condition.setLogisticsCode(String.valueOf(logisticsCode));
	
		try {
			tOrders = tOrderService.queryPageTOrder(page,limit,condition);
		} catch (MysqlDBException e) {
			e.printStackTrace();
			response.setError("网络连接失败，请检查网络");
		}
		response.setData(tOrders.getListData());
		response.setCount(tOrderService.findAll().size());
		response.setResult(Response.RESULT_SUCCESS);
		return response;
		
	}
	
	@RequestMapping(value="/delTOrder")
	@ResponseBody
	public Response<OrderPO> delTOrder(String id){
		Response<OrderPO> response = ResponseFactory.getDefaultSuccessResponse();

		if (ObjectUtil.isEmpty(id)) {
			response.setError("id不能为空");
			return response;
		}
		
		try {
			tOrderService.deleteTOrderById(id);
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
	
	@RequestMapping(value="/findTOrderById")
	@ResponseBody
	public Response<OrderPO> findTOrderById(String id){
		Response<OrderPO> response =ResponseFactory.getDefaultSuccessResponse();
		if (ObjectUtil.isEmpty(id)) {
			response.setError("id不能为空");
			return response;
		}
		try {
			response.setData(tOrderService.getTOrderById(id));
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
	
	@RequestMapping(value="/updateTOrderById")
	@ResponseBody
	public Response<OrderPO> updateTOrderById(HttpServletRequest request){
		Response<OrderPO> response =ResponseFactory.getDefaultSuccessResponse();
		OrderPO condition=new OrderPO();
        String id = request.getParameter("id");
		if(!ObjectUtil.isEmpty(id)) condition.setId(String.valueOf(id));
        String commodityId = request.getParameter("commodityId");
		if(!ObjectUtil.isEmpty(commodityId)) condition.setCommodityId(String.valueOf(commodityId));
        String pictureId = request.getParameter("pictureId");
		if(!ObjectUtil.isEmpty(pictureId)) condition.setPictureId(String.valueOf(pictureId));
        String price = request.getParameter("price");
		if(!ObjectUtil.isEmpty(price)) condition.setPrice(Double.valueOf(price));
        String num = request.getParameter("num");
		if(!ObjectUtil.isEmpty(num)) condition.setNum(Integer.valueOf(num));
        String sellerId = request.getParameter("sellerId");
		if(!ObjectUtil.isEmpty(sellerId)) condition.setSellerId(String.valueOf(sellerId));
        String buyerId = request.getParameter("buyerId");
		if(!ObjectUtil.isEmpty(buyerId)) condition.setBuyerId(String.valueOf(buyerId));
        String creartTime = request.getParameter("creartTime");
		if(!ObjectUtil.isEmpty(creartTime)) condition.setCreartTime(Long.valueOf(creartTime));
        String payTime = request.getParameter("payTime");
		if(!ObjectUtil.isEmpty(payTime)) condition.setPayTime(Long.valueOf(payTime));
        String state = request.getParameter("state");
		if(!ObjectUtil.isEmpty(state)) condition.setState(String.valueOf(state));
        String address = request.getParameter("address");
		if(!ObjectUtil.isEmpty(address)) condition.setAddress(String.valueOf(address));
        String isSign = request.getParameter("isSign");
		if(!ObjectUtil.isEmpty(isSign)) condition.setIsSign(Integer.valueOf(isSign));
        String isPay = request.getParameter("isPay");
		if(!ObjectUtil.isEmpty(isPay)) condition.setIsPay(Integer.valueOf(isPay));
        String logisticsCode = request.getParameter("logisticsCode");
		if(!ObjectUtil.isEmpty(logisticsCode)) condition.setLogisticsCode(String.valueOf(logisticsCode));
		
		if (ObjectUtil.isEmpty(condition.getId())) {
			response.setError("id不能为空");
			return response;
		}

		try {
			tOrderService.updateTOrder(condition);
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
	
	@RequestMapping(value="/addTOrder")
	@ResponseBody
	public Response<OrderPO> addTOrder(HttpServletRequest request){
		Response<OrderPO> response =ResponseFactory.getDefaultSuccessResponse();
		
		OrderPO po=new OrderPO();
		po.setId(UUIDUtil.getUUID());
        String id = request.getParameter("tOrder_id");
		if(!ObjectUtil.isEmpty(id)) po.setId(String.valueOf(id));
        String commodityId = request.getParameter("tOrder_commodityId");
		if(!ObjectUtil.isEmpty(commodityId)) po.setCommodityId(String.valueOf(commodityId));
        String pictureId = request.getParameter("tOrder_pictureId");
		if(!ObjectUtil.isEmpty(pictureId)) po.setPictureId(String.valueOf(pictureId));
        String price = request.getParameter("tOrder_price");
		if(!ObjectUtil.isEmpty(price)) po.setPrice(Double.valueOf(price));
        String num = request.getParameter("tOrder_num");
		if(!ObjectUtil.isEmpty(num)) po.setNum(Integer.valueOf(num));
        String sellerId = request.getParameter("tOrder_sellerId");
		if(!ObjectUtil.isEmpty(sellerId)) po.setSellerId(String.valueOf(sellerId));
        String buyerId = request.getParameter("tOrder_buyerId");
		if(!ObjectUtil.isEmpty(buyerId)) po.setBuyerId(String.valueOf(buyerId));
        String creartTime = request.getParameter("tOrder_creartTime");
		if(!ObjectUtil.isEmpty(creartTime)) po.setCreartTime(Long.valueOf(creartTime));
        String payTime = request.getParameter("tOrder_payTime");
		if(!ObjectUtil.isEmpty(payTime)) po.setPayTime(Long.valueOf(payTime));
        String state = request.getParameter("tOrder_state");
		if(!ObjectUtil.isEmpty(state)) po.setState(String.valueOf(state));
        String address = request.getParameter("tOrder_address");
		if(!ObjectUtil.isEmpty(address)) po.setAddress(String.valueOf(address));
        String isSign = request.getParameter("tOrder_isSign");
		if(!ObjectUtil.isEmpty(isSign)) po.setIsSign(Integer.valueOf(isSign));
        String isPay = request.getParameter("tOrder_isPay");
		if(!ObjectUtil.isEmpty(isPay)) po.setIsPay(Integer.valueOf(isPay));
        String logisticsCode = request.getParameter("tOrder_logisticsCode");
		if(!ObjectUtil.isEmpty(logisticsCode)) po.setLogisticsCode(String.valueOf(logisticsCode));
		
		try {
			tOrderService.addTOrder(po);
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
}
