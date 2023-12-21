package me.sathish.bank;

import me.sathish.bank.config.ApplicationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({ApplicationProperties.class})
public class AccountMSBootApp {

    public static void main(String[] args) {
        SpringApplication.run(AccountMSBootApp.class, args);
    }
}
