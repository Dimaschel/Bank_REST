package com.example.bankcards.entity;

import com.example.bankcards.util.CardStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

import static com.example.bankcards.util.CardTermUtil.getExpiryDate;

@Entity
@Table(name = "cards")
@Data
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Number", nullable = false, unique = true)
    @JsonProperty("numberCard")
    private String numberCard;

    @Column(name = "Owner", nullable = false)
    @JsonProperty("Owner_Card")
    private String Owner_Card;

    @Column(name = "Balance", nullable = false)
    private BigDecimal Balance_Card = BigDecimal.ZERO;

    @Enumerated(EnumType.STRING)
    @Column(name = "Status", nullable = false)
    private CardStatus Status_Card = CardStatus.ACTIVE;

    @Setter(AccessLevel.NONE)
    @Column(name = "Term", nullable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String Validity_period_Card = getExpiryDate(); //Срок - текущий месяц и год + 5 лет



    public Card(String numberCard, String Owner_Card, BigDecimal Balance_Card, CardStatus Status_Card) {
        this.numberCard = numberCard;
        this.Owner_Card = Owner_Card;
        this.Balance_Card = Balance_Card;
        this.Status_Card = Status_Card;
    }

    public Card() {
    }
}

