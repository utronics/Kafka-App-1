package com.utronics.astradb.config;


import com.utronics.astradb.model.Employee;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate;
import reactor.kafka.sender.SenderOptions;


@Configuration
public class EmpKafkaProducerConfig {

    @Bean
    public SenderOptions<String, Employee> producerProps(KafkaProperties kafkaProperties) {
        return SenderOptions.create(kafkaProperties.buildProducerProperties());
    }
    @Bean
    public ReactiveKafkaProducerTemplate<String, Employee> reactiveKafkaProducerTemplate(
            SenderOptions<String, Employee> producerProps) {
        return new ReactiveKafkaProducerTemplate<>(producerProps);
    }
}
