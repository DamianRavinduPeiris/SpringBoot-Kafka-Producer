package com.damian.driver.service;

import com.damian.driver.constants.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class CabLocationService {
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public boolean updateLocation(String location) {
        CompletableFuture<SendResult<String, Object>> result = kafkaTemplate.send(AppConstants.CAB_LOCATION, location);
        return true;
    }
}
