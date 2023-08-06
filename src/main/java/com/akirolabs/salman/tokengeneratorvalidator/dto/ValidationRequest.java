package com.akirolabs.salman.tokengeneratorvalidator.dto;

import lombok.Getter;

@Getter
public class ValidationRequest {
    private String token;

    public void setToken(String token) {
        this.token = token;
    }
}

