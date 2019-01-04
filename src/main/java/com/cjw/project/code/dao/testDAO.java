package com.cjw.project.code.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cjw.project.code.po.testPO;


/**
 * UserDAO
 * Description:
 * @author:WuKaiBin
 * @email:842387850@qq.com
 */
@Component
public interface testDAO extends BaseDAO<testPO> {
	
	/**
	 * 查询入住信息
	 * @author:yqr
	 * @return
	 */
	public List<testPO> queryinhtime();
}

