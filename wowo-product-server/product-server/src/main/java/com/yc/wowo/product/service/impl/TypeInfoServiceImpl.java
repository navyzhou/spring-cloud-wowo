package com.yc.wowo.product.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.wowo.product.bean.TypeInfo;
import com.yc.wowo.product.dao.IRedisDao;
import com.yc.wowo.product.mapper.ITypeInfoMapper;
import com.yc.wowo.product.service.ITypeInfoService;

/**
 * 商品类型业务模型层的实现
 * company 源辰信息
 * @author navy
 * @date 2020年10月26日
 * Email haijunzhou@hnit.edu.cn
 */
@Service
public class TypeInfoServiceImpl implements ITypeInfoService{
	@Autowired
	private ITypeInfoMapper typeInfoMapper;

	@Autowired
	private IRedisDao redisDao;

	@SuppressWarnings("unchecked")
	@Override
	public List<TypeInfo> finds() {
		// 从缓存服务器中获取所有类型，如果没有则查询数据库然后缓存到redis中
		Object obj = redisDao.get("types");
		
		if (obj == null) {
			List<TypeInfo> types = typeInfoMapper.finds();
			redisDao.set("types", types);
			return types;
		}
		
		return (List<TypeInfo>) obj;
	}
}
