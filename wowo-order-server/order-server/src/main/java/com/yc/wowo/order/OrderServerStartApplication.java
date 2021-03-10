package com.yc.wowo.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;

/**
 * 订单服务
 * Company 源辰信息
 * @author navy
 * @date 2021年3月8日
 * Email haijunzhou@hnit.edu.cn
 */
@MapperScan("com.yc.wowo.order.mapper")
@SpringCloudApplication
@EnableRedisHttpSession
@EnableHystrixDashboard
@ComponentScan(basePackages = "com.yc.wowo")
public class OrderServerStartApplication {
	public static void main(String[] args) {
		SpringApplication.run(OrderServerStartApplication.class, args);
	}
	
	@SuppressWarnings("rawtypes")
	@Bean
	public ServletRegistrationBean getServlet() {
		HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
		@SuppressWarnings("unchecked")
		ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
		registrationBean.setLoadOnStartup(1);
		registrationBean.addUrlMappings("/hystrix.stream");
		registrationBean.setName("HystrixMetricsStreamServlet");
		return registrationBean;
	}
}
