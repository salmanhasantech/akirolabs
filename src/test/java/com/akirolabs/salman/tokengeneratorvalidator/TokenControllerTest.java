package com.akirolabs.salman.tokengeneratorvalidator;

import com.akirolabs.salman.tokengeneratorvalidator.service.TokenService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class TokenControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TokenService tokenService;


    @Test
    public void shouldReturnToken() throws Exception {

        String availableDigits = "12345";

        when(tokenService.createToken(availableDigits)).thenReturn("1234-5432-2345-1245");

        this.mockMvc.perform(post("/generate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"availableDigits\":\"12345\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("1234-5432-2345-1245")));
    }

    @Test
    public void shouldValidateToken() throws Exception{

        String token = "5531006517734657";

        when(tokenService.isValidLuhn(token)).thenReturn(true);

        this.mockMvc.perform(post("/validate")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"token\": \"5531006517734657\" }"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("true")));

    }

}
