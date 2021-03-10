package com.yc.wowo.zuul.exception;

/**
 * 流量异常
 * Company 源辰信息
 * @author navy
 * @date 2021年3月10日
 * Email haijunzhou@hnit.edu.cn
 */
public class RateLimitException extends RuntimeException {
	private static final long serialVersionUID = 414284778223216185L;
	
	public RateLimitException() {
		super("流量过大，访问受限，请晚点再来...");
	}
}
