package me.sathish.cards;

import me.sathish.cards.config.ApplicationProperties;
import me.sathish.cards.dto.CardMSIdentifierDTO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableConfigurationProperties({ApplicationProperties.class, CardMSIdentifierDTO.class})
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class CardMSApplication {

    public static void main(String[] args) {
        SpringApplication.run(CardMSApplication.class, args);
    }
}
