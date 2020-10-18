package lojacar.ms.employee.kafka.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import com.fasterxml.jackson.core.JsonProcessingException;


import lojacar.ms.employee.service.ActivityEvents;

@Component
public class ActivityEventsConsumer {

	@Autowired
	private ActivityEvents activityEvents;
	
	private Logger log = LoggerFactory.getLogger(ActivityEventsConsumer.class);
	
	@KafkaListener(topics = { "activity-events"})
	public void onMessage(ConsumerRecord<Integer, String> consumerRecord) throws JsonMappingException, JsonProcessingException {

		log.info("ConsumerRecord :{}", consumerRecord.value());
		activityEvents.processTransactionEvent(consumerRecord);
	}
}
