package com.cjw.project.code.dao;

import org.springframework.stereotype.Component;

import com.cjw.project.code.po.MessagePO;
import com.cjw.project.code.vo.MessageCountVO;


/**
 * MessageDAO
 * Description:
 * @author:WuKaiBin
 * @email:842387850@qq.com
 */
@Component
public interface MessageDAO extends BaseDAO<MessagePO> {

	MessageCountVO countTMessage(String commodityId);
	

}






