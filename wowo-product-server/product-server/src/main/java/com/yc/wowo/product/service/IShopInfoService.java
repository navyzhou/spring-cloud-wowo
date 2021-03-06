package com.yc.wowo.product.service;

import java.util.List;

import com.yc.wowo.product.bean.ShopInfo;

public interface IShopInfoService {
	/**
	 * 查询所有正常营业的店铺的编号和名称
	 * @return
	 */
	public List<ShopInfo> finds();
	
	/**
	 * 根据店铺编号查询店铺详细
	 * @param sid
	 * @return
	 */
	public ShopInfo findBySid(String sid);
}
