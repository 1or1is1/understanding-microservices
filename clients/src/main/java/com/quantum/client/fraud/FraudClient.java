package com.quantum.client.fraud;

import com.quantum.client.fraud.model.FraudCheckHistoryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        value = "fraud",
        path = "api/v1/fraud-check"
)
public interface FraudClient {

    @GetMapping("{customerId}")
    FraudCheckHistoryResponse isFraudster(@PathVariable("customerId") Integer customerId);

}
