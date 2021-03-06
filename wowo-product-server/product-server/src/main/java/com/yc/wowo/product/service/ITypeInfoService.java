package com.yc.wowo.product.service;

import java.util.List;

import com.yc.wowo.product.bean.TypeInfo;

public interface ITypeInfoService {
	/**
	 * 获取未下架的商品类型信息
	 * @return
	 */
	public List<TypeInfo> finds();
}
