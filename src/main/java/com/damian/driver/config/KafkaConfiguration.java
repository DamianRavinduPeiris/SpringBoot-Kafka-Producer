package com.damian.driver.config;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import static com.damian.driver.constants.AppConstants.CAB_LOCATION;

@Configuration
public class KafkaConfiguration {



    @Bean
    public NewTopic topic1() {
     return TopicBuilder
             .name(CAB_LOCATION)
             .build();

    }
}
