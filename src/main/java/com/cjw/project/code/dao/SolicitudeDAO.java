package com.cjw.project.code.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.cjw.project.code.po.SolicitudePO;


/**
 * TSolicitudeDAO
 * Description:
 * @author:ZhengChao
 * @email:zhengchao730@163.com
 */
@Component
public interface SolicitudeDAO extends BaseDAO<SolicitudePO> {

	List<SolicitudePO> queryPageTSolicitude(Map<String, String> map);
	

}






