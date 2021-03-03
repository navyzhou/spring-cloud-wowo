package com.yc.wowo.eureka;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Eureka
 * Company 源辰信息
 * @author navy
 * @date 2021年3月3日
 * Email haijunzhou@hnit.edu.cn
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerStartApplication {
	public static void main(String[] args) {
		SpringApplication.run(EurekaServerStartApplication.class, args);
	}
}
