package me.sathish.cards.repositories;

import me.sathish.cards.entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    Optional<Card> findByPhoneNumber(String phoneNumber);

    Optional<Card> findByCardNumber(String cardNumber);
}
