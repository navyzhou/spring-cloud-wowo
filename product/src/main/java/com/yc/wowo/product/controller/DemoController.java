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
	
	@RequestMapping("/info1")
	public String info1() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "info1";
	}
	
	@RequestMapping("/info2")
	public String info2() {
		return "info2";
	}
}
