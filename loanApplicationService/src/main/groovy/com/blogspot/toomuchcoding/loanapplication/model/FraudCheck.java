package com.blogspot.toomuchcoding.loanapplication.model;

import java.math.BigDecimal;

public class FraudCheck {
    private String clientPesel;

    private BigDecimal loanAmount;

    public FraudCheck() {
    }

    public FraudCheck(LoanApplication loanApplication) {
        this.clientPesel = loanApplication.getClient().getPesel();
        this.loanAmount = loanApplication.getAmount();
    }

    public String getClientPesel() {
        return clientPesel;
    }

    public void setClientPesel(String clientPesel) {
        this.clientPesel = clientPesel;
    }

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }
}
