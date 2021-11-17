package com.KafkaProducer.Producer.service;

import com.KafkaProducer.Producer.application.dto.MessageDto;

public interface MessageService {

    Object createClaimCode(MessageDto dataMessage);
}
