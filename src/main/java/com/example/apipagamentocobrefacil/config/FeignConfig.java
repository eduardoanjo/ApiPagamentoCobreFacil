package com.example.apipagamentocobrefacil.config;

import com.example.apipagamentocobrefacil.gateway.cobrefacil.CobreFacilClientAuthenticate;
import com.example.apipagamentocobrefacil.gateway.cobrefacil.dto.request.CobreFacilAuthenticateRequestDTO;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.Retryer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

@RequiredArgsConstructor
public class FeignConfig implements RequestInterceptor {

    @Value("${microservice.sandbox.cobrefacil.app_id}")
    public String appId;

    @Value("${microservice.sandbox.cobrefacil.secret}")
    public String secret;

    private final CobreFacilClientAuthenticate cobreFacilClientAuthenticate;

    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("Authorization", "Bearer " + getJWT());
    }

    private String getJWT() {
        var cobreFacilAuthenticateRequestDTO = CobreFacilAuthenticateRequestDTO.builder()
                .appId(appId)
                .secret(secret)
                .build();

        var response = cobreFacilClientAuthenticate.authenticate(cobreFacilAuthenticateRequestDTO);

        return response.getData().getToken();
    }

    @Bean
    public Retryer retryer() {
        return new Retryer.Default(
                1000, // Tempo inicial de espera em milissegundos
                10000, // Tempo máximo de espera em milissegundos
                3 // Número máximo de tentativas
        );
    }
}