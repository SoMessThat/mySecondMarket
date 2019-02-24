package com.cjw.project.code.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.cjw.project.code.po.CommodityPO;


/**
 * CommodityDAO
 * Description:
 * @author:WuKaiBin
 * @email:842387850@qq.com
 */
@Component
public interface CommodityDAO extends BaseDAO<CommodityPO> {

	List<CommodityPO> findPagedByQuery(@Param(value = "pageNo") Integer pageNo, @Param(value = "pageSize") Integer pageSize);
	

}






