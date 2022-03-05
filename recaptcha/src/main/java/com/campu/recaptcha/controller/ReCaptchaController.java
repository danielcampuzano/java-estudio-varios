package com.campu.recaptcha.controller;

import com.campu.recaptcha.dtos.ReCaptchaRequest;
import com.campu.recaptcha.dtos.ReCaptchaResponse;
import com.campu.recaptcha.service.ReCaptchaService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RequestMapping("/recaptcha")
@RestController
public class ReCaptchaController {

    private ReCaptchaService service;

    public ReCaptchaController(ReCaptchaService service) {
        this.service = service;
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/validar")
    public Mono<ReCaptchaResponse> validateReCaptcha(@RequestBody ReCaptchaRequest reCaptchaRequest){
        return service.validarReCaptcha(reCaptchaRequest.getToken())
                .map(ReCaptchaResponse::new);
    }

}
