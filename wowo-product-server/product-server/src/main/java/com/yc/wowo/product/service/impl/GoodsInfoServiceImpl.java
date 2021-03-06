package com.yc.wowo.product.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.wowo.product.bean.GoodsInfo;
import com.yc.wowo.product.mapper.IGoodsInfoMapper;
import com.yc.wowo.product.service.IGoodsInfoService;

@Service
public class GoodsInfoServiceImpl implements IGoodsInfoService {
	@Autowired
	private IGoodsInfoMapper goodsInfoMapper;
	
	@Override
	public GoodsInfo findByGid(String gid) {
		return goodsInfoMapper.findByGid(gid);
	}

	@Override
	public List<GoodsInfo> finds(Map<String, Object> map) {
		return goodsInfoMapper.finds(map);
	}

	@Override
	public int total() {
		return goodsInfoMapper.total(false);
	}
}
