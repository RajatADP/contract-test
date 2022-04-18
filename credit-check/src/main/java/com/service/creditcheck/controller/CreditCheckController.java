package com.service.creditcheck.controller;

import com.service.creditcheck.model.CreditCheckRequest;
import com.service.creditcheck.model.CreditCheckResponse;
import com.service.creditcheck.service.CreditCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreditCheckController {

    @Autowired
    private CreditCheckService creditCheckService;

    public CreditCheckController() {}

    @PostMapping(value = "/credit-scores", produces = "application/json", consumes = "application/json")
    public CreditCheckResponse doCreditCheck(@RequestBody CreditCheckRequest creditCheckRequest) {
        return creditCheckService.doCheck(creditCheckRequest);

    }
}
