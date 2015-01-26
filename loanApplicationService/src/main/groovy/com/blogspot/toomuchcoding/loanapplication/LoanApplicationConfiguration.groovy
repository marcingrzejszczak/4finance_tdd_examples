package com.blogspot.toomuchcoding.loanapplication

import com.nurkiewicz.asyncretry.AsyncRetryExecutor
import com.ofg.infrastructure.web.resttemplate.fluent.ServiceRestClient
import groovy.transform.CompileStatic
import groovy.transform.PackageScope
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

import java.util.concurrent.Executors

@PackageScope
@CompileStatic
@Configuration
class LoanApplicationConfiguration {

    @Bean LoanApplier loanApplier(FraudClient fraudClient) {
        return new LoanApplier(fraudClient)
    }

    @Bean FraudClient fraudClient(ServiceRestClient serviceRestClient) {
        AsyncRetryExecutor asyncRetryExecutor = new AsyncRetryExecutor(Executors.newScheduledThreadPool(4))
        return new FraudClient(serviceRestClient, asyncRetryExecutor)
    }
}
