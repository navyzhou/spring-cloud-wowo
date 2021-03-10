package com.yc.wowo.order.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.wowo.order.dto.OrderInfoDTO;
import com.yc.wowo.order.message.IStreamClient;

@RestController
public class SendMessageController {
	@Autowired
	private IStreamClient streamClient;
	
	@GetMapping("/send")
	public void processObject() {
		OrderInfoDTO orderInfo = new OrderInfoDTO();
		orderInfo.setAno("1002");
		orderInfo.setMno(1001);
		orderInfo.setOno("O0001");
		orderInfo.setPrice(126.8);
		
		streamClient.input().send(MessageBuilder.withPayload(orderInfo).build());
	}
}
