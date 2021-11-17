package com.KafkaProducer.Producer.service.impl;

import com.KafkaProducer.Producer.application.dto.MessageDto;
import com.KafkaProducer.Producer.service.MessageService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cloudevents.CloudEvent;
import io.cloudevents.core.builder.CloudEventBuilder;
import io.cloudevents.core.data.PojoCloudEventData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final KafkaTemplate<String, CloudEvent> kafkaTemplate;
    private final ObjectMapper objectMapper;

    @Override
    public Object createClaimCode(MessageDto message) {
        return publish(message);
    }

    public Object publish(MessageDto specialCodeClaimedEvent) {
        CloudEvent cloudEvent = CloudEventBuilder.v1()
                .withExtension("payloadversion", specialCodeClaimedEvent.getPayloadversion())
                .withId(UUID.randomUUID().toString())
                .withType(specialCodeClaimedEvent.getType())
                .withSource(URI.create(specialCodeClaimedEvent.getUri()))
                .withDataContentType("application/json")
                .withTime(Instant.now().atOffset(ZoneOffset.UTC))
                .withData(PojoCloudEventData.wrap(specialCodeClaimedEvent.getMessagebody(), objectMapper::writeValueAsBytes))
                .build();
        kafkaTemplate.send(specialCodeClaimedEvent.getTopic(), cloudEvent);
        return "OK";
    }
}
