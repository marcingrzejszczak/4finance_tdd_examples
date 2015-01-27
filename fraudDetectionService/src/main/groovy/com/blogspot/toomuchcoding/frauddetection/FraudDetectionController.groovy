package com.blogspot.toomuchcoding.frauddetection

import com.blogspot.toomuchcoding.config.Versions
import com.blogspot.toomuchcoding.frauddetection.model.FraudCheck
import com.blogspot.toomuchcoding.frauddetection.model.FraudCheckResult
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import javax.validation.constraints.NotNull

import static org.springframework.web.bind.annotation.RequestMethod.PUT

@Slf4j
@RestController
@RequestMapping('/fraudcheck')
@CompileStatic
class FraudDetectionController {

    private final FraudDetector fraudDetector

    @Autowired
    FraudDetectionController(FraudDetector fraudDetector) {
        this.fraudDetector = fraudDetector
    }

    @RequestMapping(
            method = PUT,
            consumes = Versions.FRAUD_SERVICE_JSON_VERSION_1,
            produces = Versions.FRAUD_SERVICE_JSON_VERSION_1)
    FraudCheckResult checkForFraud(@RequestBody @NotNull FraudCheck fraudCheck) {
        return fraudDetector.checkFraud(fraudCheck)
    }

}
