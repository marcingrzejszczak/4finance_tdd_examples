package com.blogspot.toomuchcoding.frauddetection
import com.blogspot.toomuchcoding.config.Versions
import com.blogspot.toomuchcoding.frauddetection.model.LoanApplication
import com.blogspot.toomuchcoding.frauddetection.model.LoanApplicationResult
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
@RequestMapping('/loanApplication')
@CompileStatic
class LoanApplicationController {

    private final LoanApplier loanApplier

    @Autowired
    LoanApplicationController(LoanApplier loanApplier) {
        this.loanApplier = loanApplier
    }

    @RequestMapping(
            method = PUT,
            consumes = Versions.LOAN_APPLICATION_SERVICE_JSON_VERSION_1,
            produces = Versions.LOAN_APPLICATION_SERVICE_JSON_VERSION_1)
    LoanApplicationResult applyForLoan(@RequestBody @NotNull LoanApplication loanApplication) {
        return loanApplier.applyForLoan(loanApplication)
    }

}
