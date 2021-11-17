package com.KafkaProducer.Producer.application.controller;

import com.KafkaProducer.Producer.application.dto.MessageDto;
import com.KafkaProducer.Producer.service.MessageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/message")
@AllArgsConstructor(staticName = "of")
public class generateMessageController {

    private MessageService messageService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> createMessage(@RequestBody MessageDto requestBody) {
        return ResponseEntity.ok().body(messageService.createClaimCode(requestBody));
    }
}
