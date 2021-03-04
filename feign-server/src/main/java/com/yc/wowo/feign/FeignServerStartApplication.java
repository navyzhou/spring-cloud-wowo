package com.yc.wowo.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 声明式服务调用
 * Company 源辰信息
 * @author navy
 * @date 2021年3月4日
 * Email haijunzhou@hnit.edu.cn
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients // 启用Feign的声明式服务调用
public class FeignServerStartApplication  {
	public static void main(String[] args) {
		SpringApplication.run(FeignServerStartApplication.class, args);
	}
}