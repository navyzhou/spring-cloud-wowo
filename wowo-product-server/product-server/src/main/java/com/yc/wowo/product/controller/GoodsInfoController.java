package com.yc.wowo.product.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yc.wowo.product.bean.GoodsInfo;
import com.yc.wowo.product.enums.ResultEnum;
import com.yc.wowo.product.service.IGoodsInfoService;
import com.yc.wowo.product.util.RequestParamUtil;
import com.yc.wowo.product.vo.ResultVO;


@RestController
@RequestMapping("/goods")
public class GoodsInfoController{
	@Autowired
	private IGoodsInfoService goodsInfoServiceImpl;
	
	@RequestMapping("/findByFirst")
	public Map<String,Object> findByFirst(@RequestParam Map<String, Object> map)  {
		// 要返回第一页的数据以及总记录数
		Map<String,Object> result = new HashMap<String, Object>();
		result.put("total", goodsInfoServiceImpl.total());
		result.put("rows", goodsInfoServiceImpl.finds(RequestParamUtil.findByPageUtil(map)));
		return result;
	}

	@RequestMapping("/finds")
	public List<GoodsInfo> finds(@RequestParam Map<String, Object> map) throws IOException {
		return goodsInfoServiceImpl.finds(RequestParamUtil.findByPageUtil(map));
	}


	@RequestMapping("/findByGid")
	public ResultVO findByGid(String gid){
		GoodsInfo goodsInfo = goodsInfoServiceImpl.findByGid(gid);
		if (goodsInfo == null) {
			return new ResultVO(ResultEnum.PRODUCT_NOT_EXIST);
		}
		return new ResultVO(ResultEnum.SUCCESS, goodsInfo);
	}
}
