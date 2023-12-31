package me.sathish.loans.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "loans-cloud")
@Getter
@Setter
public class LoanCloudDTO {
    List<String> supported_cloud_env;
}
