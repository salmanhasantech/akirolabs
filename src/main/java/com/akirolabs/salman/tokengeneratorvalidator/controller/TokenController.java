package com.akirolabs.salman.tokengeneratorvalidator.controller;

import com.akirolabs.salman.tokengeneratorvalidator.dto.TokenRequest;
import com.akirolabs.salman.tokengeneratorvalidator.dto.TokenResponse;
import com.akirolabs.salman.tokengeneratorvalidator.dto.ValidationRequest;
import com.akirolabs.salman.tokengeneratorvalidator.dto.ValidationResponse;
import com.akirolabs.salman.tokengeneratorvalidator.service.TokenService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController("/")
public class TokenController {
    final
    TokenService tokenService;

    public TokenController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping("/generate")
    public TokenResponse generateToken(@RequestBody TokenRequest request) {
        String availableDigits = request.getAvailableDigits();
        String token = tokenService.createToken(availableDigits);
        return new TokenResponse(token);
    }

    @PostMapping("/validate")
    public ValidationResponse validateToken(@RequestBody ValidationRequest request) {
        String token = request.getToken();
        boolean isValid = tokenService.isValidLuhn(token);
        return new ValidationResponse(isValid);
    }
}
