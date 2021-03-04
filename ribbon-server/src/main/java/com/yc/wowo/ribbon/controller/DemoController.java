package com.yc.wowo.ribbon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("")
public class DemoController {
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	/**
	 * 面向服务调用
	 * 当客户端向负载均衡服务器发送index请求时，负载均衡服务器先从注册中心拿到product服务列表，注意，此时是通过服务名还获取服务列表
	 */
	@RequestMapping("/index")
	public String helloConsumer() {
		return restTemplate.getForEntity("http://product-server/index", String.class).getBody();
	}
	
	@RequestMapping("/info")
	public String info() {
		System.out.println("当前eureka中注册的服务器有：");
		List<String> list = discoveryClient.getServices();
		list.forEach(System.out::println);
		return "访问成功";
	} 
}
