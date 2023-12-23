package me.sathish.cards.services;

import me.sathish.cards.dto.CardDTO;
import me.sathish.cards.entities.Card;
import me.sathish.cards.exception.CardLoanExistsException;
import me.sathish.cards.exception.ResourceNotFoundException;
import me.sathish.cards.mapper.CardsMapper;
import me.sathish.cards.repositories.CardRepository;
import me.sathish.cards.response.PagedResult;
import me.sathish.cards.utils.CardMSConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class CardService {

    private final CardRepository cardRepository;

    @Autowired
    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public PagedResult<Card> findAllCards(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort =
            sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        // create Pageable instance
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Card> cardsPage = cardRepository.findAll(pageable);
        return new PagedResult<>(cardsPage);
    }

    public Optional<Card> findCardById(Long id) {
        return cardRepository.findById(id);
    }

    public CardDTO fetchCard(String phoneNumber) {
        Card cards = cardRepository.findByPhoneNumber(phoneNumber).orElseThrow(
            () -> new ResourceNotFoundException("Card", "phoneNumber", phoneNumber)
        );
        return CardsMapper.mapToCardsDto(cards, new CardDTO());
    }

    public Card saveCard(String phoneNumber) {
        Optional<Card> optionalCards = cardRepository.findByPhoneNumber(phoneNumber);
        if (optionalCards.isPresent()) {
            throw new CardLoanExistsException("Card already registered with given phoneNumber " + phoneNumber);
        }
        return cardRepository.save(createNewCard(phoneNumber));
    }

    /**
     * @param phoneNumber - Mobile Number of the Customer
     * @return the new card details
     */
    private Card createNewCard(String phoneNumber) {
        Card newCard = new Card();
        long randomCardNumber = 100000000000L + new Random().nextInt(900000000);
        newCard.setCardNumber(Long.toString(randomCardNumber));
        newCard.setPhoneNumber(phoneNumber);
        newCard.setCardType(CardMSConstants.CREDIT_CARD);
        newCard.setTotalLimit(CardMSConstants.NEW_CARD_LIMIT);
        newCard.setAmountUsed(0);
        newCard.setAvailableAmount(CardMSConstants.NEW_CARD_LIMIT);
        return newCard;
    }

    public boolean updateCard(CardDTO cardsDto) {
        Card card = cardRepository.findByCardNumber(cardsDto.getCardNumber()).orElseThrow(
            () -> new ResourceNotFoundException("Card", "CardNumber", cardsDto.getCardNumber()));
        CardsMapper.mapToCards(cardsDto, card);
        cardRepository.save(card);
        return true;
    }

    public boolean deleteCardByPhoneNumber(String phoneNumber) {
        Card cards = cardRepository.findByPhoneNumber(phoneNumber).orElseThrow(
            () -> new ResourceNotFoundException("Card", "mobileNumber", phoneNumber)
        );
        cardRepository.deleteById(cards.getId());
        return true;
    }
}
