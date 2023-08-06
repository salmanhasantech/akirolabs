package com.akirolabs.salman.tokengeneratorvalidator.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class TokenService {

    public String createToken(String availableDigits){

        StringBuilder tokenBuilder = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < 16; i++) {
            int index = random.nextInt(availableDigits.length());
            char digit = availableDigits.charAt(index);
            tokenBuilder.append(digit);
            if (i % 4 == 3 && i != 15) {
                tokenBuilder.append('-');
            }
        }

        return tokenBuilder.toString();
    }
    public boolean isValidLuhn(String token) {
        int sum = 0;
        boolean alternate = false;

        for (int i = token.length() - 1; i >= 0; i--) {
            int digit = token.charAt(i) - '0';
            if (alternate) {
                digit *= 2;
                if (digit > 9) {
                    digit -= 9;
                }
            }
            sum += digit;
            alternate = !alternate;
        }

        return sum % 10 == 0;
    }
}
