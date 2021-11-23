package com.lynas.service;

import com.lynas.dto.ConversionInfoDTO;
import com.lynas.dto.ConversionResponseDTO;
import com.lynas.exception.ApiRequestException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class CurrencyConverterService {

    private List<String> currencyList;

    private final ExternalApiService apiService;

    public CurrencyConverterService(ExternalApiService apiService) {
        this.apiService = apiService;
    }

    @PostConstruct
    public void init() {
        apiService.getCurrencyList().subscribe(s -> currencyList = new ArrayList<>(s.getRates().keySet()));
    }

    public Mono<Double> convertCurrency(double amount, String fromCurrency, String toCurrency) {
        return apiService.convertCurrency(amount, fromCurrency, toCurrency)
                .map(ConversionResponseDTO::getInfo)
                // API call does not return converted value multiply by amount
                // That is why the following map is used
                .map(it -> it.getRate() * amount);
    }

    public void validateInput(double amount, String fromCurrency, String toCurrency) {
        if (amount < 0) {
            throw new ApiRequestException("Amount must be a positive number : " + amount);
        }
        if (!currencyList.contains(fromCurrency)) {
            throw new ApiRequestException("Invalid fromCurrency : " + fromCurrency);
        }
        if (!currencyList.contains(toCurrency)) {
            throw new ApiRequestException("Invalid toCurrency : " + toCurrency);
        }

    }
}

