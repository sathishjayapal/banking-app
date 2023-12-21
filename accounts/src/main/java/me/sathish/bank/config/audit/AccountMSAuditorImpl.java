package me.sathish.bank.config.audit;

import java.util.Optional;
import org.springframework.data.domain.AuditorAware;

public class AccountMSAuditorImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("ACCOUNTS_MS");
    }
}
