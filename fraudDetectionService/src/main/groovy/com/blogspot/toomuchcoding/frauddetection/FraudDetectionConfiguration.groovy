package com.blogspot.toomuchcoding.frauddetection

import groovy.transform.PackageScope
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@PackageScope
@Configuration
class FraudDetectionConfiguration {

    @Bean FraudDetector fraudDetector() {
        return new FraudDetector([new AmountChecker(), new PeselChecker()])
    }

}
