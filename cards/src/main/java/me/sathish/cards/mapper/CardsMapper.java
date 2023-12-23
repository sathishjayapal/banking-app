package me.sathish.cards.mapper;

import me.sathish.cards.dto.CardDTO;
import me.sathish.cards.entities.Card;

public class CardsMapper {
    public static CardDTO mapToCardsDto(Card cards, CardDTO cardsDto) {
        cardsDto.setCardNumber(cards.getCardNumber());
        cardsDto.setCardType(cards.getCardType());
        cardsDto.setPhoneNumber(cards.getPhoneNumber());
        cardsDto.setTotalLimit(cards.getTotalLimit());
        cardsDto.setAvailableAmount(cards.getAvailableAmount());
        cardsDto.setAmountUsed(cards.getAmountUsed());
        return cardsDto;
    }

    public static Card mapToCards(CardDTO cardsDto, Card cards) {
        cards.setCardNumber(cardsDto.getCardNumber());
        cards.setCardType(cardsDto.getCardType());
        cards.setPhoneNumber(cardsDto.getPhoneNumber());
        cards.setTotalLimit(cardsDto.getTotalLimit());
        cards.setAvailableAmount(cardsDto.getAvailableAmount());
        cards.setAmountUsed(cardsDto.getAmountUsed());
        return cards;
    }
}
