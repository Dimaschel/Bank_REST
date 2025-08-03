package com.example.bankcards.dto;

import com.example.bankcards.entity.Card;
import com.example.bankcards.util.CardStatus;
import lombok.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@Data
public class DtoCard {

    private long id;
    private String numberCard;
    private String Owner_Card;
    private BigDecimal Balance;
    private CardStatus Status_Card;
    private String Validity_period_Card;
}
