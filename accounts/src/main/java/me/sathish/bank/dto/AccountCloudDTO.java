package me.sathish.bank.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "account-cloud")
@Getter
@Setter
public class AccountCloudDTO {
    List<String> supported_cloud_env;
}
