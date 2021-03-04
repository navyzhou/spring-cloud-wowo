package com.yc.wowo.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 商品服务
 * Company 源辰信息
 * @author navy
 * @date 2021年3月3日
 * Email haijunzhou@hnit.edu.cn
 */
@SpringBootApplication
@EnableEurekaClient
public class ProductStartApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProductStartApplication.class, args);
	}
}
