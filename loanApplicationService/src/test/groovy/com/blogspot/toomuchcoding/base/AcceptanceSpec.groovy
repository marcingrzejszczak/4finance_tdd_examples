package com.blogspot.toomuchcoding.base

import org.springframework.test.web.servlet.MvcResult

import static com.blogspot.toomuchcoding.config.Versions.LOAN_APPLICATION_SERVICE_JSON_VERSION_1
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put

class AcceptanceSpec extends MicroserviceMvcIntegrationSpec {

    def 'should return accepted loan application for non fraud loan application'() {
        given:
            String nonFraudLoanApplication = '''\
{
  "loanApplicationId": "123123",
  "client": {
    "pesel": "123456789"
  },
  "amount": 100.5
}
'''
        when:
            MvcResult mvcResult = mockMvc.perform(put('/loanApplication').
                    contentType(LOAN_APPLICATION_SERVICE_JSON_VERSION_1).
                    content(nonFraudLoanApplication)).
                    andReturn()

        then:
        '''{"loanApplicationStatus":"LOAN_APPLIED","loanApplicationId":"123123"}''' == mvcResult.response.contentAsString
    }
}
