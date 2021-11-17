package com.KafkaProducer.Producer.service.dto;

import lombok.*;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Claims {

    private Long id;
    private String claimedByUserId;
    private String referralUserId;
    private String referralCode;
    private Date claimedAt;
    private Long specialCodeId;
}
