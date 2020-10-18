package lojacar.ms.employee.service;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sound.midi.Soundbank;

import org.apache.kafka.clients.consumer.ConsumerRecord;

import lojacar.ms.employee.entity.Activity;
import lojacar.ms.employee.entity.Employee;
import lojacar.ms.employee.entity.EmployeeActivity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ActivityEvents {

	@Autowired
	private IEmployee repository;

	@Autowired
	ObjectMapper objectMapper;

	private Logger log = LoggerFactory.getLogger(ActivityEvents.class);
	// 2
	public void processTransactionEvent(ConsumerRecord<Integer, String> consumerRecord)
			throws JsonMappingException, JsonProcessingException {

		EmployeeActivity empAc = new EmployeeActivity();
		Employee employee = new Employee();
		Activity event = objectMapper.readValue(consumerRecord.value(), Activity.class);
		employee = repository.findById(event.getEmployeeId());
		log.info("activityEvent: {} ", event.getEmployeeId());
		empAc.setActivityId(event.getId());

		if (event.getEmployeeId() == employee.getEmployeeId()) {
			repository.save(employee);
			empAc.setEmployee(employee);
			repository.saveEA(empAc);
		}

	}

}
