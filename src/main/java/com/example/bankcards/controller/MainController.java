package com.example.bankcards.controller;

import com.example.bankcards.dto.DtoCard;
import com.example.bankcards.entity.Card;
import com.example.bankcards.service.CardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/cards")
public class MainController {
    private final CardService cardService;

    @PostMapping("/add")
    public Card addCard(@RequestBody Card card) {
        log.info("Добавление новой карты: {}", card);
        Card savedCard = cardService.addCard(card);
        log.info("Карта успешно добавлена: ID={}", savedCard.getId());
        return savedCard;
    }

    @GetMapping("/all")
    public List<DtoCard> getCards() {
        return cardService.getAllCards();
    }

    @GetMapping("/{id}")
    public DtoCard getCard(@PathVariable Long id) {
        return cardService.getCardById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteCard(@PathVariable Long id) {
        return cardService.deleteCard(id);
    }

    @DeleteMapping("/all")
    public void deleteCards() {
        cardService.deleteAllCards();
    }
}