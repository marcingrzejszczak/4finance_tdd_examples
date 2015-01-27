package com.blogspot.toomuchcoding.base

import org.springframework.test.web.servlet.MvcResult

import static com.blogspot.toomuchcoding.config.Versions.FRAUD_SERVICE_JSON_VERSION_1
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put

class AcceptanceSpec extends MicroserviceMvcIntegrationSpec {

    def 'should return non fraud check'() {
        given:
            String nonFraudLoanApplication = '''\
{
    "clientPesel":"123456789",
    "loanAmount":100.5
}
'''
        when:
            MvcResult mvcResult = mockMvc.perform(put('/fraudcheck').
                    contentType(FRAUD_SERVICE_JSON_VERSION_1).
                    content(nonFraudLoanApplication)).
                    andReturn()

        then:
            '''{"fraudCheckStatus":"OK","rejectionReason":""}''' == mvcResult.response.contentAsString
    }
}
