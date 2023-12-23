package me.sathish.cards.controllers;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.extern.slf4j.Slf4j;
import me.sathish.cards.dto.CardDTO;
import me.sathish.cards.dto.CardMSReponseDTO;
import me.sathish.cards.entities.Card;
import me.sathish.cards.response.PagedResult;
import me.sathish.cards.services.CardService;
import me.sathish.cards.utils.CardMSConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cards")
@Validated
@Slf4j
public class CardController {

    private final CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping
    public PagedResult<Card> getAllCards(
            @RequestParam(
                            value = "pageNo",
                            defaultValue = CardMSConstants.DEFAULT_PAGE_NUMBER,
                            required = false)
                    int pageNo,
            @RequestParam(
                            value = "pageSize",
                            defaultValue = CardMSConstants.DEFAULT_PAGE_SIZE,
                            required = false)
                    int pageSize,
            @RequestParam(
                            value = "sortBy",
                            defaultValue = CardMSConstants.DEFAULT_SORT_BY,
                            required = false)
                    String sortBy,
            @RequestParam(
                            value = "sortDir",
                            defaultValue = CardMSConstants.DEFAULT_SORT_DIRECTION,
                            required = false)
                    String sortDir) {
        return cardService.findAllCards(pageNo, pageSize, sortBy, sortDir);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Card> getCardById(@PathVariable Long id) {
        return cardService
                .findCardById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create/{phoneNumber}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CardMSReponseDTO> createCard(
            @Valid
                    @PathVariable
                    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
                    String phoneNumber) {
        cardService.saveCard(phoneNumber);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        new CardMSReponseDTO(
                                CardMSConstants.STATUS_201, CardMSConstants.MESSAGE_201));
    }

    @PutMapping("/update")
    public ResponseEntity<CardMSReponseDTO> updateCard(@Valid @RequestBody CardDTO cardsDto) {
        boolean isUpdated = cardService.updateCard(cardsDto);
        if (isUpdated) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(
                            new CardMSReponseDTO(
                                    CardMSConstants.STATUS_200, CardMSConstants.MESSAGE_200));
        } else {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                    .body(
                            new CardMSReponseDTO(
                                    CardMSConstants.STATUS_417,
                                    CardMSConstants.MESSAGE_417_UPDATE));
        }
    }

    @DeleteMapping("/delete/{phoneNumber}")
    public ResponseEntity<CardMSReponseDTO> deleteCard(
            @PathVariable
                    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
                    String phoneNumber) {
        boolean isDeleted = cardService.deleteCardByPhoneNumber(phoneNumber);
        if (isDeleted) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(
                            new CardMSReponseDTO(
                                    CardMSConstants.STATUS_200, CardMSConstants.MESSAGE_200));
        } else {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                    .body(
                            new CardMSReponseDTO(
                                    CardMSConstants.STATUS_417,
                                    CardMSConstants.MESSAGE_417_DELETE));
        }
    }
}
