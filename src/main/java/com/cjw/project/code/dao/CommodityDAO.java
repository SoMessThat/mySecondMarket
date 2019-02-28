package com.cjw.project.code.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.cjw.project.code.po.CommodityPO;
import com.cjw.project.code.vo.CountCommiditionVO;


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
	List<CommodityPO> findPagedByQuery(@Param(value = "pageNo") Integer pageNo, @Param(value = "pageSize") Integer pageSize);

	/**
	 * 统计售卖商品数，收藏数等
	 * @param sellerId
	 * @return
	 */
	CountCommiditionVO countCommodity(String sellerId);
	

}






