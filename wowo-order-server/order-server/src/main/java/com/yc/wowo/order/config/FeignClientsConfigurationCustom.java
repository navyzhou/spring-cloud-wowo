package com.yc.wowo.order.config;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * 解决feign之后session丢失的问题
 * Company 源辰信息
 * @author navy
 * @date 2021年3月7日
 * Email haijunzhou@hnit.edu.cn
 */
@Configuration  
@EnableFeignClients(basePackages = {"com.yc.wowo.user.client", "com.yc.wowo.product.client"})
public class FeignClientsConfigurationCustom implements RequestInterceptor {  
	@Override  
	public void apply(RequestTemplate template) {  
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();  
		if (requestAttributes == null) {  
			return;  
		}  

		HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();  
		Enumeration<String> headerNames = request.getHeaderNames();  
		if (headerNames != null) {  
			while (headerNames.hasMoreElements()) {  
				String name = headerNames.nextElement();  
				Enumeration<String> values = request.getHeaders(name);  
				while (values.hasMoreElements()) {  
					String value = values.nextElement();  
					template.header(name, value);  
				}  
			}  
		}  
	}

	@Bean
	public FeignHystrixConcurrencyStrategy feignHystrixConcurrencyStrategy() {
		return new FeignHystrixConcurrencyStrategy();
	}
} 