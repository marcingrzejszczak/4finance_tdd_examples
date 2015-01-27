package com.blogspot.toomuchcoding.frauddetection
import com.blogspot.toomuchcoding.frauddetection.model.FraudCheck
import groovy.transform.CompileStatic
import groovy.transform.PackageScope

import java.util.regex.Pattern

@CompileStatic
@PackageScope
class PeselChecker implements FraudChecker {

    private static final Pattern REGEXP = ~/[0-9]{9}/
    private static final String REJECTION_REASON = 'Wrong pesel'

    @Override
    boolean conditionIsMet(FraudCheck fraudCheck) {
        return fraudCheck.clientPesel != ~REGEXP
    }

    @Override
    String getRejectionReason() {
        return REJECTION_REASON
    }
}
