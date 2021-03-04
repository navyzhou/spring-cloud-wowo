package com.yc.wowo.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;

/**
 * 负载均衡服务器
 * Company 源辰信息
 * @author navy
 * @date 2021年3月4日
 * Email haijunzhou@hnit.edu.cn
 */
@SpringBootApplication
@EnableDiscoveryClient
public class RibbonServerStartApplication {
    public static void main( String[] args ) {
    	SpringApplication.run(RibbonServerStartApplication.class, args);
    }
    
    /**
     * Spring cloud中自带7中
     * 1、RoundRobinRule: 轮询
     * 2、RandomRule: 随机
     * 3、AvailabilityFilteringRule
     * 4、WeightedResponseTimeRule
     * 5、RetryRule
     * 6、BestAvailableRule
     * 7、ZoneAvoidanceRule
     * @return
     */
    @Bean
    public IRule ribbonRule() {
    	return new RoundRobinRule(); // 采用轮询机制
    }
    
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
    	return new RestTemplate();
    }
}
