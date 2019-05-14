package com.cjw.project.code.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cjw.project.code.po.DemandPO;


/**
 * TDemandDAO
 * Description:
 * @author:ZhengChao
 * @email:zhengchao730@163.com
 */
@Component
public interface DemandDAO extends BaseDAO<DemandPO> {

	List<DemandPO> queryPageTDemand(DemandPO obj);

	DemandPO getTDemandById(String id);
	

}






