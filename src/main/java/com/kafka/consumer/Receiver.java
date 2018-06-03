package com.kafka.consumer;

import java.util.Optional;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver
{
	static Logger log = LoggerFactory.getLogger(Receiver.class);

	@KafkaListener(topics = { "chok" })
	public void listen(ConsumerRecord<?, ?> record)
	{

		Optional<?> kafkaMessage = Optional.ofNullable(record.value());

		if (kafkaMessage.isPresent())
		{
			Object message = kafkaMessage.get();
			log.info("----------------- record =" + record);
			log.info("------------------ message =" + message);
		}

	}
}
