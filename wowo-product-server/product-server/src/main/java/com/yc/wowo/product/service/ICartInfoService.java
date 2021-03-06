package com.yc.wowo.product.service;

import java.util.List;
import java.util.Map;

import com.yc.wowo.product.bean.CartInfo;

public interface ICartInfoService {
	public int add(Map<String, Object> map);
	
	public List<CartInfo> findByMid(Integer mid); 
	
	public int update(Map<String, Object> map);
	
	public int del(String cid);
}
