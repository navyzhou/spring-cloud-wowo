package com.yc.wowo.order.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import com.yc.wowo.order.dto.OrderInfoDTO;

@Component
@EnableBinding(IStreamClient.class)
public class StreamReceiver {
	private final static Logger logger = LoggerFactory.getLogger(StreamReceiver.class);

	// 消费消息并给一个响应信息
	@StreamListener(IStreamClient.QUEUEINPUTSTREAM)
	@SendTo(IStreamClient.QUEUEOUTPUTSTREAM)
	public String process(OrderInfoDTO orderInfo) {
		logger.info("StreamReceiver: {}", orderInfo);
		return "我收到了...";
	}
	
	// 写一个消费者来消费回送的信息
	@StreamListener(IStreamClient.QUEUEOUTPUTSTREAM)
	public void process2(String msg) {
		logger.info("ReturnStreamReceiver: {}", msg);
	}
	
	
}
