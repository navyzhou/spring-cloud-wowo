package com.yc.wowo.feign.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="product-server") // name：指定要调用的服务的名称
public interface IRemoteClient {
	@RequestMapping("/index")
	public String getInfo();
}
