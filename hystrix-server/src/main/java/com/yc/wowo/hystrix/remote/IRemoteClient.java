package com.yc.wowo.hystrix.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="product-server") // name：指定要调用的服务的名称
public interface IRemoteClient {
	@RequestMapping("/info1")
	public String getInfo1();
	
	@RequestMapping("/info2")
	public String getInfo2();
}
