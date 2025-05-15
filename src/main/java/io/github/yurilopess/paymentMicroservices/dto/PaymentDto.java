package io.github.yurilopess.paymentMicroservices.dto;

import io.github.yurilopess.paymentMicroservices.model.Status;

import java.math.BigDecimal;
import java.util.UUID;

public class PaymentDto {

    private UUID id;
    private BigDecimal value;
    private String name;
    private String number;
    private String expiration;
    private String code;
    private Status status;
    private String orderId;
    private String paymentTypeId;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(String paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    public PaymentDto(UUID id, BigDecimal value, String name, String number, String expiration, String code, Status status, String orderId, String paymentTypeId) {
        this.id = id;
        this.value = value;
        this.name = name;
        this.number = number;
        this.expiration = expiration;
        this.code = code;
        this.status = status;
        this.orderId = orderId;
        this.paymentTypeId = paymentTypeId;
    }

    public PaymentDto() {
    }
}
