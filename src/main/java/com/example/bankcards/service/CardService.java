package com.example.bankcards.service;

import com.example.bankcards.dto.CardMapping;
import com.example.bankcards.dto.DtoCard;
import com.example.bankcards.entity.Card;
import com.example.bankcards.entity.User;
import com.example.bankcards.repository.CardRepository;
import com.example.bankcards.util.CardStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class CardService {
    private final CardRepository cardRepository;
    private final CardMapping cardMapper;

    @Transactional
    public Card addCard(Card card) {
        return cardRepository.save(card);
    }

    public List<DtoCard> getAllCards() {
        return cardRepository.findAll().stream().map(cardMapper::map).collect(Collectors.toList());
    }

    public DtoCard getCardById(Long id) {
        Card card = cardRepository.findById(id).orElseThrow(() -> new RuntimeException("Карта не найдена"));
        return cardMapper.map(card);
    }

    @Transactional
    public String deleteCard(Long id) {
        cardRepository.deleteById(id);
        return "Карта с id: " + id + " удалена";
    }

    @Transactional
    public void deleteAllCards() {
        cardRepository.deleteAll();
    }


    private void validateCard(Card card) {
        if (card.getNumberCard().length() != 16 ) {
            throw new IllegalArgumentException("Номер карты должен содержать 16 цифр");
        }
    }
}