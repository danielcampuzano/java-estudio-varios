package com.campu.recaptcha.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "recaptcha")
public class ReCaptchaConfig {
    private String urlValidateCaptcha;
    private String privateKey;
    private float score;

    public String getUrlValidateCaptcha() {
        return urlValidateCaptcha;
    }

    public void setUrlValidateCaptcha(String urlValidateCaptcha) {
        this.urlValidateCaptcha = urlValidateCaptcha;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}
