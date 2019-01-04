package com.cjw.project.code.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.cjw.project.code.po.SmartQueueTimesPO;


/**
 * UserDAO
 * Description:
 * @author:WuKaiBin
 * @email:842387850@qq.com
 */
@Component
public interface SmartQueueTimesDAO extends BaseDAO<SmartQueueTimesPO> {
	public void modify(@Param("callid")String callid,@Param("times")int times,@Param("waitbegin")String waitbegin);
}

