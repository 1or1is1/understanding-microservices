package com.quantum.fraud.controller;

import com.quantum.fraud.model.FraudCheckHistoryResponse;
import com.quantum.fraud.service.FraudCheckHistoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/fraud-check")
public record FraudCheckHistoryController(FraudCheckHistoryService fraudCheckHistoryService) {

    @GetMapping ("{customerId}")
    public FraudCheckHistoryResponse isFraudster(@PathVariable("customerId") Integer customerId) {
        Boolean isFraudCustomer = fraudCheckHistoryService.isFraudulentCustomer(customerId);
        return new FraudCheckHistoryResponse(isFraudCustomer);
    }

}
