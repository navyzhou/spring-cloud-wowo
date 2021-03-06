package com.yc.wowo.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.wowo.product.bean.ShopInfo;
import com.yc.wowo.product.enums.ResultEnum;
import com.yc.wowo.product.service.IShopInfoService;
import com.yc.wowo.product.vo.ResultVO;

@RestController
@RequestMapping("/shop")
public class ShopInfoController {
	@Autowired
	private IShopInfoService shopInfoServiceImpl;
	
	@RequestMapping("/finds")
	public List<ShopInfo> finds() {
		return shopInfoServiceImpl.finds();
	}

	@RequestMapping("/findBySid")	
	public ResultVO findBySid(String sid) {
		ShopInfo shopInfo = shopInfoServiceImpl.findBySid(sid);
		if (shopInfo == null) {
			return new ResultVO(ResultEnum.PRODUCT_NOT_EXIST);
		}
		return new ResultVO(ResultEnum.SUCCESS, shopInfo);
	}
}
