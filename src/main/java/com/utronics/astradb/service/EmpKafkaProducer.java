package com.utronics.astradb.service;


import com.utronics.astradb.model.Employee;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EmpKafkaProducer {

    @Value(value = "${PRODUCER_TOPIC}")
    private String topic;
    @Autowired
    private ReactiveKafkaProducerTemplate<String, Employee> reactiveKafkaProducerTemplate;

    public void sendMessages(Employee employee) {
        log.info("send to topic={}, {}={},", topic, Employee.class.getSimpleName(), employee);
        reactiveKafkaProducerTemplate.send(topic, String.valueOf(employee.getId()), employee)
                .doOnSuccess(senderResult -> log.info("sent {} offset : {}",
                        employee,
                        senderResult.recordMetadata().offset()))
                .subscribe();
    }

}
