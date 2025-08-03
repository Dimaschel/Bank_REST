package com.example.bankcards.dto;

import com.example.bankcards.entity.Card;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-31T00:27:43+0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.16 (Eclipse Adoptium)"
)
@Component
public class CardMappingImpl implements CardMapping {

    @Override
    public DtoCard map(Card card) {
        if ( card == null ) {
            return null;
        }

        DtoCard dtoCard = new DtoCard();

        dtoCard.setNumberCard( maskCardNumber( card.getNumberCard() ) );
        if ( card.getId() != null ) {
            dtoCard.setId( card.getId() );
        }
        dtoCard.setOwner_Card( card.getOwner_Card() );
        dtoCard.setStatus_Card( card.getStatus_Card() );
        dtoCard.setValidity_period_Card( card.getValidity_period_Card() );

        return dtoCard;
    }
}
