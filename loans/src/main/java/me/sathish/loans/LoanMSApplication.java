package me.sathish.loans;

import me.sathish.loans.config.ApplicationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({ApplicationProperties.class})
public class LoanMSApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoanMSApplication.class, args);
    }
}
