package com.yc.wowo.product;

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
 * 商品服务启动类
 * Company 源辰信息
 * @author navy
 * @date 2021年3月6日
 * Email haijunzhou@hnit.edu.cn
 */
@MapperScan("com.yc.wowo.product.mapper") // 指定mapper文件对应的接口的包路径
@SpringCloudApplication
@EnableRedisHttpSession
@EnableHystrixDashboard
@ComponentScan("com.yc.wowo")
public class ProductServerStartApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProductServerStartApplication.class, args);
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
