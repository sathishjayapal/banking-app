package me.sathish.bank.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@ConfigurationProperties(prefix = "accounts")
public record AccountMSIdentifierDTO(
        String java_version, String build_number, Map<String, String> contactDetails) {}
