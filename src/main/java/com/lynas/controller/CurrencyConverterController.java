package com.lynas.controller;

import com.lynas.service.CurrencyConverterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/currency")
public class CurrencyConverterController {

    private final CurrencyConverterService service;

    public CurrencyConverterController(CurrencyConverterService service) {
        this.service = service;
    }

    @GetMapping("/covert/amount/{amount}/from/{fromCurrency}/to/{toCurrency}")
    public Mono<Double> convertCurrency (
            @PathVariable double amount,
            @PathVariable String fromCurrency,
            @PathVariable String toCurrency) {
        service.validateInput(amount, fromCurrency, toCurrency);
        return service.convertCurrency(amount, fromCurrency, toCurrency);
    }

}
