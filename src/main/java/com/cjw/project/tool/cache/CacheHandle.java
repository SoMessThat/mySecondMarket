package com.cjw.project.tool.cache;

import com.cjw.project.tool.util.SpringContextLoader;








/**
 * 缓存管理.
 * @author Aioria
 */
public class CacheHandle {

	/**
	 * 获取缓存代理.
	 * 
	 * @return
	 */
	public static ISimpleCacheProxy getCacheProxy() {
		return (ISimpleCacheProxy) SpringContextLoader.getBean("cacheProxy");
	}

}
