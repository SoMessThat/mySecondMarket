package com.cjw.project.code.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import com.cjw.project.code.po.OrderPO;
import com.cjw.project.code.vo.OrderVO;


/**
 * OrderDAO
 * Description:
 * @author:WuKaiBin
 * @email:842387850@qq.com
 */
@Component
public interface OrderDAO extends BaseDAO<OrderPO> {

	List<OrderVO> queryPageTOrder(@RequestParam Map<String, String> map);
	

}






