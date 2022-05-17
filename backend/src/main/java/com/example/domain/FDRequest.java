package com.example.domain;

import lombok.Data;

@Data
public class FDRequest {
    private String bankName;
    private Integer durationInYear;
    private String fdInterestRate;
    public FDRequest(String bankName, Integer durationInYear) {
        this.bankName = bankName;
        this.durationInYear = durationInYear;
    }
}
