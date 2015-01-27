package com.blogspot.toomuchcoding.frauddetection
import com.blogspot.toomuchcoding.frauddetection.model.FraudCheckResult
import com.blogspot.toomuchcoding.frauddetection.model.FraudCheckStatus
import com.blogspot.toomuchcoding.frauddetection.model.LoanApplication
import com.blogspot.toomuchcoding.frauddetection.model.LoanApplicationResult
import com.blogspot.toomuchcoding.frauddetection.model.LoanApplicationStatus
import groovy.transform.CompileStatic
import groovy.transform.PackageScope

@PackageScope
@CompileStatic
class LoanApplier {

    private final FraudClient fraudClient

    LoanApplier(FraudClient fraudClient) {
        this.fraudClient = fraudClient
    }

    LoanApplicationResult applyForLoan(LoanApplication loanApplication) {
        FraudCheckResult checkResult = fraudClient.fraudCheckResult(loanApplication)
        LoanApplicationStatus loanApplicationStatus = LoanApplicationStatus.LOAN_APPLICATION_REJECTED
        if (FraudCheckStatus.OK == checkResult.fraudCheckStatus) {
            loanApplicationStatus = LoanApplicationStatus.LOAN_APPLIED
        }
        return new LoanApplicationResult(loanApplicationStatus: loanApplicationStatus,
                                         loanApplicationId: loanApplication.loanApplicationId)
    }

}
