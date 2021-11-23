package com.lynas.dto;

import java.util.Map;

public class ProviderDTO {
    private boolean success;
    private Map<String, String> rates;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Map<String, String> getRates() {
        return rates;
    }

    public void setRates(Map<String, String> rates) {
        this.rates = rates;
    }
}
