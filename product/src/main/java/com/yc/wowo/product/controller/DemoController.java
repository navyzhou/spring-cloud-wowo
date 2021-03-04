package com.yc.wowo.product.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class DemoController {
	@Value("${server.port}")
	private Integer port;
	
	@RequestMapping("/index")
	public String hello() {
		return "product-" + port;
	}
}
