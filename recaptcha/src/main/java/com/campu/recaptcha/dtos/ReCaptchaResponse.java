package com.campu.recaptcha.dtos;

public class ReCaptchaResponse {

    Boolean isValidCaptcha;

    public ReCaptchaResponse(Boolean isValidCaptcha) {
        this.isValidCaptcha = isValidCaptcha;
    }

    public Boolean getValidCaptcha() {
        return isValidCaptcha;
    }

    public void setValidCaptcha(Boolean validCaptcha) {
        isValidCaptcha = validCaptcha;
    }
}
