package com.kafka.provider;

import java.util.Date;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.kafka.entity.Message;

@Component
public class Sender
{
	static Logger log = LoggerFactory.getLogger(Sender.class);
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	// 发送消息方法
	public void send()
	{
		Message message = new Message();
		message.setId(System.currentTimeMillis());
		message.setMsg(UUID.randomUUID().toString());
		message.setSendTime(new Date());
		log.info("+++++++++++++++++++++  message = {}", JSON.toJSONString(message));
		kafkaTemplate.send("chok", JSON.toJSONString(message));
	}
}
