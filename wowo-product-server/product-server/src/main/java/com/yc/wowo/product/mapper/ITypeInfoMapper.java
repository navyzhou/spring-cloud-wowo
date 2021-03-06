package com.yc.wowo.product.mapper;

import java.util.List;
import java.util.Map;

import com.yc.wowo.product.bean.TypeInfo;

/**
 * 商品类型数据模型层接口
 * company 源辰信息
 * @author navy
 * @date 2020年10月26日
 * Email haijunzhou@hnit.edu.cn
 */
public interface ITypeInfoMapper {
	/**
	 * 获取未下架的商品类型信息
	 * @return
	 */
	public List<TypeInfo> finds();
	
	/**
	 * 获取总记录数
	 * @return
	 */
	public int total();
	
	/**
	 * 分页查询
	 * @param page 查询第几页
	 * @param rows 每页显示多少行
	 * @return
	 */
	public List<TypeInfo> findByPage(Map<String, Object> map);
}
