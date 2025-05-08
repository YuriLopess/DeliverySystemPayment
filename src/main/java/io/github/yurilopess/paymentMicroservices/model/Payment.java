package io.github.yurilopess.paymentMicroservices.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "payment", schema = "public")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @NotNull
    @Positive
    @Column(name = "value")
    private BigDecimal value;

    @NotBlank
    @Size(max = 100)
    @Column(name = "name")
    private String name;

    @NotBlank
    @Size(max = 19 )
    @Column(name = "number")
    private String number;

    @NotBlank
    @Size(max = 7)
    @Column(name = "expiration")
    private String expiration;

    @NotBlank
    @Size(min = 3, max = 3)
    @Column(name = "code")
    private String code;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @NotNull
    @Column(name = "orderId")
    private String orderId;

    @NotNull
    @Column(name = "paymentTypeId")
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

    public Payment(UUID id, BigDecimal value, String number, String name, String expiration, String code, Status status, String orderId, String paymentTypeId) {
        this.id = id;
        this.value = value;
        this.number = number;
        this.name = name;
        this.expiration = expiration;
        this.code = code;
        this.status = status;
        this.orderId = orderId;
        this.paymentTypeId = paymentTypeId;
    }
}
