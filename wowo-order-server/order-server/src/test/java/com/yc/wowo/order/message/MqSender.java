package com.yc.wowo.order.message;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.wowo.order.OrderServerStartApplication;

/**
 * 发送端
 * Company 源辰信息
 * @author navy
 * @date 2021年3月8日
 * Email haijunzhou@hnit.edu.cn
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes=OrderServerStartApplication.class)
public class MqSender {
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	@Test
	public void send() {
		amqpTemplate.convertAndSend("myQueue", "1-你好！");
		amqpTemplate.convertAndSend("myQueue", "2-你好！");
		amqpTemplate.convertAndSend("myQueue", "3-你好！");
		amqpTemplate.convertAndSend("myQueue", "4-你好！");
	}
	
	@Test
	public void send1() {
		amqpTemplate.convertAndSend("myOrder", "digital", "数码产品");
	}
	
	@Test
	public void send2() {
		amqpTemplate.convertAndSend("myOrder", "food", "美食");
	}
}
