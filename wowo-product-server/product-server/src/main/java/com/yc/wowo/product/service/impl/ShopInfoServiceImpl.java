package com.yc.wowo.product.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.wowo.product.bean.ShopInfo;
import com.yc.wowo.product.mapper.IShopInfoMapper;
import com.yc.wowo.product.service.IShopInfoService;

@Service
public class ShopInfoServiceImpl implements IShopInfoService {
	@Autowired
	private IShopInfoMapper shopInfoMapper;
	
	@Override
	public List<ShopInfo> finds() {
		return shopInfoMapper.finds();
	}

	@Override
	public ShopInfo findBySid(String sid) {
		return shopInfoMapper.findBySid(sid);
	}
}
