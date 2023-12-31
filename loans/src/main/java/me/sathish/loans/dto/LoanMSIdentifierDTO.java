package me.sathish.loans.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@ConfigurationProperties(prefix = "loans")
public record LoanMSIdentifierDTO(
        String java_version,
        String build_number,
        Map<String, String> contactDetails){}
