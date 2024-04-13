package com.example.controller;

import com.example.model.SMSSenderRequest;
import com.example.service.SMSService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api/v1")
public class SMSRestController {

    private final SMSService smsService;

    public SMSRestController(SMSService smsService) {
        this.smsService = smsService;
    }

    @PostMapping("/processSMS")
    public String processSMS(@RequestBody SMSSenderRequest senderRequest){

        log.info("processSMS Started sendRequest " +senderRequest.toString());

        return smsService.sendSMS(senderRequest.getDestination(),senderRequest.getMessage());
    }
}
