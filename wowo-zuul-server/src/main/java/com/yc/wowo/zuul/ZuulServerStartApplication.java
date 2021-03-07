package com.yc.wowo.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;

/**
 * 路由网关
 * Company 源辰信息
 * @author navy
 * @date 2021年3月7日
 * Email haijunzhou@hnit.edu.cn
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class ZuulServerStartApplication {
	public static void main(String[] args) {
		SpringApplication.run(ZuulServerStartApplication.class, args);
	}
	
	@ConfigurationProperties("zuul")
	public ZuulProperties zuulProperties() {
		return new ZuulProperties();
	}
}
