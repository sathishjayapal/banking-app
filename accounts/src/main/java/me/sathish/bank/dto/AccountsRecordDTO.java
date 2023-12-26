package me.sathish.bank.dto;

import java.util.List;
import java.util.Map;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "accounts")
public record AccountsRecordDTO(
        String java_version,
        String build_number,
        Map<String, String> contactDetails,
        List<String> supported_cloud_env) {}
