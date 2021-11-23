package com.lynas.dto;

public class ConversionResponseDTO {
    private boolean success;
    private ConversionInfoDTO info;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public ConversionInfoDTO getInfo() {
        return info;
    }

    public void setInfo(ConversionInfoDTO info) {
        this.info = info;
    }
}

