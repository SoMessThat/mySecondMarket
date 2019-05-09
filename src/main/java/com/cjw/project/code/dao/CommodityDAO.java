package com.cjw.project.code.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import com.cjw.project.code.po.CommodityPO;
import com.cjw.project.code.vo.CommiditionVO;
import com.cjw.project.code.vo.CountCommiditionVO;
import com.cjw.project.code.vo.MessageVO;
import com.cjw.project.code.vo.OrderVO;


/**
 * CommodityDAO
 * Description:
 * @author:WuKaiBin
 * @email:842387850@qq.com
 */
@Component
public interface CommodityDAO extends BaseDAO<CommodityPO> {

	/**
	 * 商品分页
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<CommodityPO> findPagedByQuery(@RequestParam Map<String, String> map);

	/**
	 * 统计售卖商品数，收藏数等
	 * @param sellerId
	 * @return
	 */
	CountCommiditionVO countCommodity(String sellerId);
	
	/**
	 * 统计售卖商品数，收藏数等
	 * @param sellerId
	 * @return
	 */
	List<MessageVO> queryMessage(String commodityId);

	CommodityPO getTCommodityById(String id);

	CommiditionVO queryCommodity(String commodityId);

	List<OrderVO> queryPageTCommodity();

	List<CommodityPO> queryAttendCommodity(String id);

	List<CommodityPO> searchByKey(String key);
}






