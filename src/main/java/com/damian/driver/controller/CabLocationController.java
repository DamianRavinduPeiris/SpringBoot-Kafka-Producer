package com.damian.driver.controller;

import com.damian.driver.response.Response;
import com.damian.driver.service.CabLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/location")
public class CabLocationController {
    @Autowired
    private CabLocationService cabLocationService;
    @Autowired
    private Response response;
    @PutMapping(path = "/update")
    public ResponseEntity<Response> updateLocation() throws InterruptedException {
        int range = 100;
        while (range>0){
            cabLocationService.updateLocation(range+" "+range);
            Thread.sleep(1000);
            range--;
        }
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Location updated successfully!");
        response.setData(null);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

}
