package me.sathish.bank;

import me.sathish.bank.config.ApplicationProperties;
import me.sathish.bank.dto.AccountCloudDTO;
import me.sathish.bank.dto.AccountMSIdentifierDTO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableConfigurationProperties({ApplicationProperties.class, AccountMSIdentifierDTO.class, AccountCloudDTO.class})
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class AccountMSBootApp {

    public static void main(String[] args) {
        SpringApplication.run(AccountMSBootApp.class, args);
    }
}
