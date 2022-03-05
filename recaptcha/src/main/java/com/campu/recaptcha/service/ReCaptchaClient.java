package com.campu.recaptcha.service;

import com.campu.recaptcha.config.ReCaptchaConfig;
import com.campu.recaptcha.dtos.ReCaptchaClientResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class ReCaptchaClient {

    private static final String SECRET = "secret";
    private static final String RESPONSE = "response";

    private final WebClient webClient;
    private final ReCaptchaConfig config;

    public ReCaptchaClient(WebClient webClient, ReCaptchaConfig config) {
        this.webClient = webClient;
        this.config = config;
    }

    public Mono<ReCaptchaClientResponse> requestPost(String key){
        return this.webClient.post()
                .uri(uriBuilder -> uriBuilder.path(config.getUrlValidateCaptcha())
                        .queryParam(SECRET, config.getPrivateKey())
                        .queryParam(RESPONSE, key).build())
                .retrieve().bodyToMono(ReCaptchaClientResponse.class);
    }
}
