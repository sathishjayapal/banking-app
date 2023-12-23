package me.sathish.cards.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CardMSReponseDTO {
    private String errorCode;
    private String errorString;
}
