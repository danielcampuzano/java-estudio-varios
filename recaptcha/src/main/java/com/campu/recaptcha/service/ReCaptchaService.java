package com.campu.recaptcha.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ReCaptchaService {
    private ReCaptchaClient client;

    public ReCaptchaService(ReCaptchaClient client) {
        this.client = client;
    }

    public Mono<Boolean> validarReCaptcha(String key){
        return client.requestPost(key).flatMap(reCaptchaResponse -> {
           if(reCaptchaResponse.isSuccess() && reCaptchaResponse.getScore() >= 0.7 ){
               return Mono.just(true);
           }else{
               return Mono.just(false);
           }
        });
    }
}
