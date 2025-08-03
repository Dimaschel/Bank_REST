package com.example.bankcards.dto;

import com.example.bankcards.entity.Card;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface CardMapping {
    @Mapping(target = "numberCard", qualifiedByName = "maskCard")
    DtoCard map(Card card);


    @Named("maskCard")
    default String maskCardNumber(String number) {
        return "**** **** **** " + number.substring(number.length() - 4);
    }

}
