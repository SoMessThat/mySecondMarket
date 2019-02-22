package com.cjw.project.code.vo;

import com.cjw.project.code.po.CommodityPO;
import com.cjw.project.code.po.CommodityPictureRefPO;

public class CommiditionVO {
	private CommodityPO commodity;
	private CommodityPictureRefPO commodityPictureRef;
	public CommodityPO getCommodity() {
		return commodity;
	}
	public void setCommodity(CommodityPO commodity) {
		this.commodity = commodity;
	}
	public CommodityPictureRefPO getCommodityPictureRef() {
		return commodityPictureRef;
	}
	public void setCommodityPictureRef(CommodityPictureRefPO commodityPictureRef) {
		this.commodityPictureRef = commodityPictureRef;
	}
	
	
}
