package com.blogspot.toomuchcoding.frauddetection
import com.blogspot.toomuchcoding.frauddetection.model.FraudCheck
import groovy.transform.CompileStatic
import groovy.transform.PackageScope

@CompileStatic
@PackageScope
class AmountChecker implements FraudChecker {

    private static final String REJECTION_REASON = 'Too high amount'
    private static final BigDecimal UPPER_AMOUNT = 500

    @Override
    boolean conditionIsMet(FraudCheck fraudCheck) {
        return fraudCheck.loanAmount > UPPER_AMOUNT
    }

    @Override
    String getRejectionReason() {
        return REJECTION_REASON
    }
}
