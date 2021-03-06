package com.yc.wowo.product.service;

import java.util.List;
import java.util.Map;

import com.yc.wowo.product.bean.GoodsInfo;

public interface IGoodsInfoService {
	/**
	 * 根据商品编号查询商品详细
	 * @param gid
	 * @return
	 */
	public GoodsInfo findByGid(String gid);
	
	/**
	 * 分页查询可用的商品信息 -- 针对前端用户
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<GoodsInfo> finds(Map<String, Object> map);
	
	/**
	 * 返回在架的商品总数
	 * @return
	 */
	public int total();
}
