package com.service.creditcheck.contracts.creditcardservice;

import com.service.creditcheck.CreditCheckApplication;
import com.service.creditcheck.controller.CreditCheckController;
import com.service.creditcheck.model.CreditCheckRequest;
import com.service.creditcheck.model.CreditCheckResponse;
import com.service.creditcheck.service.CreditCheckService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.when;

@SpringBootTest(classes = CreditCheckApplication.class)
public class BaseContractTest {

    @MockBean
    private CreditCheckService creditCheckService;

    @Autowired
    private CreditCheckController creditCheckController;

    @BeforeEach
    void setup() {

        RestAssuredMockMvc.standaloneSetup(creditCheckController);
        CreditCheckRequest creditCheckRequest = new CreditCheckRequest(1);
        when(creditCheckService.doCheck(creditCheckRequest)).thenReturn(new CreditCheckResponse(CreditCheckResponse.Score.HIGH));
        //This will create mock environment using controller class. All tests will point to this mock


    }

    @Test
    void nothing() {

    }
}
