package me.sathish.loans;

import me.sathish.loans.config.ApplicationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableConfigurationProperties({ApplicationProperties.class})
public class LoanMSApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoanMSApplication.class, args);
    }
}
