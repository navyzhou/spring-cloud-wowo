package com.yc.wowo.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;

/**
 * 
 * Company 源辰信息
 * @author navy
 * @date 2021年3月5日
 * Email haijunzhou@hnit.edu.cn
 */
// @SpringBootApplication
// @EnableDiscoveryClient
// @EnableCircuitBreaker // 开启熔断和降级
@SpringCloudApplication
@EnableFeignClients // 开启声明式接口调用
@EnableHystrixDashboard // 开启仪表盘
public class HystrixServerStartApplication  {
	public static void main(String[] args) {
		SpringApplication.run(HystrixServerStartApplication.class, args);
	}

	@Bean
	public ServletRegistrationBean getServlet() {
		HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
		ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
		registrationBean.setLoadOnStartup(1);
		registrationBean.addUrlMappings("/hystrix.stream");
		registrationBean.setName("HystrixMetricsStreamServlet");
		return registrationBean;
	}
}
