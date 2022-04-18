package com.service.creditcard.controller;

import com.service.creditcard.model.CreditCardResponse;
import com.service.creditcard.model.CreditCheck;
import com.service.creditcard.model.CreditCheckRequest;
import com.service.creditcard.model.CreditCheckResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CreditCardController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/credit-card")
    public CreditCardResponse applyCC(@RequestBody CreditCheck creditCheck) {
        int citizenNumber = creditCheck.getCitizenNumber();
        CreditCheckResponse creditCheckResponse = restTemplate.postForObject("http://localhost:9000/credit-scores", new CreditCheckRequest(citizenNumber),
                CreditCheckResponse.class);

        if (creditCheckResponse.getScore().equals(CreditCheckResponse.Score.HIGH))
            return new CreditCardResponse(CreditCardResponse.Status.GRANTED);
        if (creditCheckResponse.getScore().equals(CreditCheckResponse.Score.LOW))
            return new CreditCardResponse(CreditCardResponse.Status.REJECTED);

        throw  new RuntimeException("Something went wrong");
    }
}
