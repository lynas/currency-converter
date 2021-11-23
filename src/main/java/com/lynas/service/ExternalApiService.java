package com.lynas.service;

import com.lynas.dto.ConversionResponseDTO;
import com.lynas.dto.ProviderDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ExternalApiService {

    @Value("${app.api.baseUrl}")
    private String apiBaseUrl;
    @Value("${app.api.apiKey}")
    private String apiKey;

    private final WebClient webClient;

    public ExternalApiService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<ProviderDTO> getCurrencyList(){
        return this.webClient.get().uri(apiBaseUrl+"/latest?access_key="+apiKey+"&format=1")
                .retrieve().bodyToMono(ProviderDTO.class);
    }

    public Mono<ConversionResponseDTO> convertCurrency(double amount, String fromCurrency, String toCurrency){
        return this.webClient.get().uri(apiBaseUrl+"/convert?access_key="+apiKey+"&from="+fromCurrency+"&to="+toCurrency+"&amount="+amount)
                .retrieve().bodyToMono(ConversionResponseDTO.class);
    }

}
