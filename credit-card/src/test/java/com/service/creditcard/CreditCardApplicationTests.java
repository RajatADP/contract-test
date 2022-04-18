package com.service.creditcard;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureStubRunner(ids = "com.service:credit-check:+:stubs:9000",
        stubsMode = StubRunnerProperties.StubsMode.LOCAL)
class CreditCardApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldGrantCreditCardWhenScoreIsHigh() throws Exception {
        mockMvc.perform(
                post("/credit-card")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"citizenNumber\": 1,\n" +
                                "    \"cardType\": \"Gold\"\n" +
                                "}")
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content()
                        .json("{\n" +
                                "\"status\": \"GRANTED\"\n" +
                                "}"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

}
