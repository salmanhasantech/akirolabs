package com.akirolabs.salman.tokengeneratorvalidator.dto;

import lombok.Getter;

@Getter
public class TokenRequest {
    private String availableDigits;

    public void setAvailableDigits(String availableDigits) {
        this.availableDigits = availableDigits;
    }
}