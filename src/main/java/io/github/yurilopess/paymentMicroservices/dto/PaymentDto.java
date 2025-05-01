package io.github.yurilopess.paymentMicroservices.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.UUID;

public class PaymentDto {

    private UUID id;
    private BigDecimal value;
    private String name;
    private String number;
    private String expiration;
    private String code;
    private String status;
    private String orderId;
    private String paymentTypeId;
}
