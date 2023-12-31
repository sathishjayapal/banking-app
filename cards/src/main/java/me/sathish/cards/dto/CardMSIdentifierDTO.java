package me.sathish.cards.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@ConfigurationProperties(prefix = "cards")
public record CardMSIdentifierDTO(
        String java_version,
        String build_number,
        Map<String, String> contactDetails) {}
