package com.example.apipagamentocobrefacil.gateway.cobrefacil;

import com.example.apipagamentocobrefacil.gateway.cobrefacil.dto.request.CobreFacilAuthenticateRequestDTO;
import com.example.apipagamentocobrefacil.gateway.cobrefacil.dto.response.CF_AuthenticateResponseDTO;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Headers({"Content-Type: application/json"})
@FeignClient(name="cobrefacilau", url="${microservice.sandbox.cobrefacil.url.base}")
public interface CobreFacilClientAuthenticate {

    @PostMapping("/authenticate")
    CF_AuthenticateResponseDTO authenticate(@RequestBody CobreFacilAuthenticateRequestDTO request);
}
