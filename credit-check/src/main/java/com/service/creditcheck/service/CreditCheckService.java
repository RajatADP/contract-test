package com.service.creditcheck.service;

import com.service.creditcheck.model.CreditCheckRequest;
import com.service.creditcheck.model.CreditCheckResponse;
import org.springframework.stereotype.Service;

@Service
public class CreditCheckService {
    public CreditCheckResponse doCheck(CreditCheckRequest creditCheckRequest) {
        CreditCheckResponse creditCheckResponse = null;
        if (creditCheckRequest.getCitizenNumber() == 1)
            creditCheckResponse = new CreditCheckResponse(CreditCheckResponse.Score.HIGH);
        if (creditCheckRequest.getCitizenNumber() == 2)
            creditCheckResponse = new CreditCheckResponse(CreditCheckResponse.Score.LOW);

        return creditCheckResponse;
        //return null;
    }
}
