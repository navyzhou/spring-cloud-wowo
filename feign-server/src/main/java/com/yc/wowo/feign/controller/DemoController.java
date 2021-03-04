package com.yc.wowo.feign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.wowo.feign.remote.IRemoteClient;

@RestController
@RequestMapping("")
public class DemoController {
	@Autowired
	private IRemoteClient remoteClient;
	
	@RequestMapping("/info")
	public String getInfo() {
		return remoteClient.getInfo();
	}
}
