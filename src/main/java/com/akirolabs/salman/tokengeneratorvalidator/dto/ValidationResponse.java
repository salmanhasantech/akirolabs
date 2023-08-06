package com.akirolabs.salman.tokengeneratorvalidator.dto;

public class ValidationResponse {
    private final boolean isValid;

    public ValidationResponse(boolean isValid) {
        this.isValid = isValid;
    }

    public boolean isValid() {
        return isValid;
    }
}


