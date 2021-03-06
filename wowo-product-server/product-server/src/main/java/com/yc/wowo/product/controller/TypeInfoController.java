package com.yc.wowo.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.wowo.product.bean.TypeInfo;
import com.yc.wowo.product.service.ITypeInfoService;

/**
 * 商品类型控制
 * company 源辰信息
 * @author navy
 * @date 2020年10月26日
 * Email haijunzhou@hnit.edu.cn
 */
@RestController
@RequestMapping("/type")
public class TypeInfoController{
	@Autowired
	private ITypeInfoService typeInfoServiceImpl;

	@RequestMapping("/finds")
	public List<TypeInfo> finds() {
		return typeInfoServiceImpl.finds();
	}
}
