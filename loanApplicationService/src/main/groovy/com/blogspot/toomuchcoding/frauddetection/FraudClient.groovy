package com.blogspot.toomuchcoding.frauddetection

import com.blogspot.toomuchcoding.config.Collaborators
import com.blogspot.toomuchcoding.frauddetection.model.FraudCheck
import com.blogspot.toomuchcoding.frauddetection.model.FraudCheckResult
import com.blogspot.toomuchcoding.frauddetection.model.LoanApplication
import com.nurkiewicz.asyncretry.AsyncRetryExecutor
import com.ofg.infrastructure.web.resttemplate.fluent.ServiceRestClient
import groovy.transform.CompileStatic
import groovy.transform.PackageScope

@PackageScope
@CompileStatic
class FraudClient {

    private final ServiceRestClient serviceRestClient
    private final AsyncRetryExecutor executor

    FraudClient(ServiceRestClient serviceRestClient, AsyncRetryExecutor executor) {
        this.serviceRestClient = serviceRestClient
        this.executor = executor
    }

    FraudCheckResult fraudCheckResult(LoanApplication loanApplication) {
        serviceRestClient.forService(Collaborators.FRAUD)
                         .retryUsing(executor)
                         .put()
                         .onUrl('/fraudcheck')
                         .body(new FraudCheck(loanApplication))
                         .andExecuteFor()
                         .anObject()
                         .ofType(FraudCheckResult)
    }
}
