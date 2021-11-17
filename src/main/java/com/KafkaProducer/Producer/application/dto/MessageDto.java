package com.KafkaProducer.Producer.application.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MessageDto {

    private String type;
    private String uri;
    private String topic;
    private String payloadversion;
    private Object messagebody;

}
