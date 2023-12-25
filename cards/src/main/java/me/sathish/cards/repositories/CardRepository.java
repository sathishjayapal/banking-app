package me.sathish.cards.repositories;

import java.util.Optional;
import me.sathish.cards.entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    Optional<Card> findByPhoneNumber(String phoneNumber);

    Optional<Card> findByCardNumber(String cardNumber);
}
