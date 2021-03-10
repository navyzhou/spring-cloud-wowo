package com.yc.wowo.zuul.filter;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.*;

import org.springframework.stereotype.Component;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import com.yc.wowo.zuul.exception.RateLimitException;

/**
 * 限流过滤器
 * 时机：在请求被转发之前调用，所有它应该放在前置过滤器最靠前的地方
 * 限流的方式很多，我们最常用的一种限流方式就是 令牌桶，原理就是一一定的速度往令牌桶中投放令牌，当令牌桶满了，则丢弃放不进取的令牌
 * 请求过来时，先从令牌桶里面获取令牌，拿到令牌的则放行，拿不到令牌的则拒绝
 * Company 源辰信息
 * @author navy
 * @date 2021年3月10日
 * Email haijunzhou@hnit.edu.cn
 */
@Component
public class RateLimitFilter extends ZuulFilter{
	private static final RateLimiter RATE_LIMITER = RateLimiter.create(100); // 这个值是每秒往令牌桶中放多少个令牌
	
	/**
	 * 过滤器类型
	 */
	@Override
	public String filterType() {
		return PRE_TYPE;
	}
	
	/**
	 * 过滤器的顺序，限流过滤器要求在最前面。
	 * 这个方法指定过滤器的顺序，数值越小越靠前
	 * 此时，我们要返回比目前这个组件里面优先级最高的值还要小
	 * 此时，这个组件中已知的最小是值：SERVLET_DETECTION_FILTER_ORDER = -3
	 */
	@Override
	public int filterOrder() {
		return SERVLET_DETECTION_FILTER_ORDER - 10;
	}
	
	/**
	 * 控制过滤器是否生效，这里面可以根据各自的业务需求，做一些逻辑判断，符合条件才启用，不符合条件就返回false禁用
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}

	/**
	 * 执行过滤的逻辑
	 */
	@Override
	public Object run() throws ZuulException {
		if (!RATE_LIMITER.tryAcquire()) { // 先去获取一个令牌，如果没有拿到，则抛出异常
			throw new RateLimitException();
		}
		return null;
	}
}
