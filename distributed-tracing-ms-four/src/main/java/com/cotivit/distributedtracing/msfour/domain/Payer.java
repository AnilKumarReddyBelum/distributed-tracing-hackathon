package com.cotivit.distributedtracing.msfour.domain;

import lombok.Data;

@Data
public class Payer {
    private Long id;
    private Long clientId;
    private String name;
    private String payerShort;
}
