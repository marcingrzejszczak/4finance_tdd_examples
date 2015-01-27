package com.blogspot.toomuchcoding.frauddetection

import com.blogspot.toomuchcoding.frauddetection.model.FraudCheck
import com.blogspot.toomuchcoding.frauddetection.model.FraudCheckResult
import com.blogspot.toomuchcoding.frauddetection.model.FraudCheckStatus
import groovy.transform.PackageScope

@PackageScope
trait FraudChecker {
    @PackageScope abstract boolean conditionIsMet(FraudCheck fraudCheck)
    @PackageScope abstract String getRejectionReason()

    FraudCheckResult checkFraud(FraudCheck fraudCheck) {
        if (conditionIsMet(fraudCheck)) {
            return new FraudCheckResult(
                    rejectionReason: getRejectionReason(),
                    fraudCheckStatus: FraudCheckStatus.OK)
        }
        return new FraudCheckResult(fraudCheckStatus: FraudCheckStatus.OK)
    }
}