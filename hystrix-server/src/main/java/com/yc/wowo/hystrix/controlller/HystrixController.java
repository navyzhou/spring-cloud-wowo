package com.yc.wowo.hystrix.controlller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
@DefaultProperties(defaultFallback = "defaultFallback")
public class HystrixController {
	// 第一种方式：直接写对方服务的ip
	@RequestMapping("/info1")
	// @HystrixCommand(fallbackMethod = "fallback") // 降级之后要调用的方法，默认是1秒钟，也就是说1秒后请求还没回来，则直接降级
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value="3000") // 设置超时时间为3秒
	})
	public String info() {
		// com.netflix.hystrix.HystrixCommandProperties
		RestTemplate restTemplate = new RestTemplate();
		String response = restTemplate.getForEntity("http://127.0.0.1:7700/info1", String.class).getBody();
		return response;
	}
	
	@RequestMapping("/info2")
	@HystrixCommand(fallbackMethod = "fallback") // 降级之后要调用的方法
	public String info2() {
		RestTemplate restTemplate = new RestTemplate();
		String response = restTemplate.getForEntity("http://127.0.0.1:7700/info2", String.class).getBody();
		return response;
	}

	@RequestMapping("/info3")
	@HystrixCommand // 如果不指定降级的方法，则会调用类上面配置的降级方法
	public String info3() {
		RestTemplate restTemplate = new RestTemplate();
		String response = restTemplate.getForEntity("http://127.0.0.1:7700/info1", String.class).getBody();
		return response;
	}
	
	/**
	 * 上面是降级和超时设置，那么接下来我们来看一下熔断
	 * 
	 * @return
	 */
	@HystrixCommand(commandProperties = {
			@HystrixProperty(name="circuitBreaker.enabled", value="true"), // 是否允许熔断
			@HystrixProperty(name="circuitBreaker.requestVolumeThreshold", value="10"), 
			// 窗口期 10秒
			@HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds", value="10000"),
			// 设置断路器打开的错误百分比，即10次调用中，如果有6次以上发生异常，则熔断
			@HystrixProperty(name="circuitBreaker.errorThresholdPercentage", value="60")
	})
	@RequestMapping("/find")
	public String find(Integer num) {
		if (num % 2 == 0) {
			return "success";
		}
		
		RestTemplate restTemplate = new RestTemplate();
		String response = restTemplate.getForEntity("http://127.0.0.1:7700/info1", String.class).getBody();
		return response;
	}
	
	public String fallback() {
		return "哎呀，服务器被挤爆了，等一下再来吧...";
	}
	
	public String defaultFallback() {
		return "网络开小差了...";
	}
}
