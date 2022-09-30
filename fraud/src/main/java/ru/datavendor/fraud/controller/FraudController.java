package ru.datavendor.fraud.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.datavendor.fraud.model.FraudCheckResponse;
import ru.datavendor.fraud.service.FraudCheckService;

@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
public class FraudController {

    private final FraudCheckService fraudCheckSevice;

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId) {
        boolean isFraudulentCostumer = fraudCheckSevice.isFraudulentCostumer(customerId);
        return new FraudCheckResponse(isFraudulentCostumer);
    }
}
