package me.sathish.cards.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "cards-cloud")
@Getter
@Setter
public class CardCloudDTO {
    List<String> supported_cloud_env;
}
