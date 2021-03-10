package com.yc.wowo.order.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//@Component
public class MqReceiver {
	private final static Logger logger = LoggerFactory.getLogger(MqReceiver.class);
	
	// @RabbitListener(queues = "myQueue") // 要监听的队列名称
	@RabbitListener(queuesToDeclare = @Queue("myQueue")) // 如果没有这个消息队列，则会自动创建
	//@RabbitListener(bindings = @QueueBinding(value=@Queue("myQueue"), exchange = @Exchange("myExchange"))) // 如果没有这个消息队列，则会自动创建
	public void process(String msg) {
		logger.info("1-MqReceiver {}", msg);
	}
	
	@RabbitListener(queuesToDeclare = @Queue("myQueue"))
	//@RabbitListener(bindings = @QueueBinding(value=@Queue("myQueue"), exchange = @Exchange("myExchange")))// 如果没有这个消息队列，则会自动创建
	public void process1(String msg) {
		logger.info("2-MqReceiver {}", msg);
	}
	
	/*@RabbitListener(bindings = @QueueBinding(
			exchange = @Exchange("myOrder"),
			key = "digital",
			value= @Queue("myQueue")
	))*
	public void processDigital(String msg) {
		logger.error("Digital MqReceiver {}", msg);
	}
	
	/*@RabbitListener(bindings = @QueueBinding(
			exchange = @Exchange("myOrder"),
			key = "food",
			value= @Queue("myQueue")
	))*/
	public void processFood(String msg) {
		logger.info("Food MqReceiver {}", msg);
	}
}
