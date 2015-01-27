package com.blogspot.toomuchcoding.frauddetection
import com.blogspot.toomuchcoding.frauddetection.model.FraudCheck
import com.blogspot.toomuchcoding.frauddetection.model.FraudCheckResult
import com.blogspot.toomuchcoding.frauddetection.model.FraudCheckStatus
import groovy.transform.PackageScope

@PackageScope
class FraudDetector {

    private final List<FraudChecker> fraudCheckers

    FraudDetector(List<FraudChecker> fraudCheckers) {
        this.fraudCheckers = fraudCheckers
    }

    FraudCheckResult checkFraud(FraudCheck fraudCheck) {
        return fraudCheckers.findResult { it.checkFraud(fraudCheck) } ?: new FraudCheckResult(fraudCheckStatus: FraudCheckStatus.OK)
    }
}
