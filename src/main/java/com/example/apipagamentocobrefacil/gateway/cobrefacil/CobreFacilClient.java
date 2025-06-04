package com.example.apipagamentocobrefacil.gateway.cobrefacil;

import com.example.apipagamentocobrefacil.gateway.cobrefacil.dto.request.CF_NewClientPFRequestDTO;
import com.example.apipagamentocobrefacil.gateway.cobrefacil.dto.request.CF_NewClientPJRequestDTO;
import com.example.apipagamentocobrefacil.gateway.cobrefacil.dto.request.CF_UpdateClientRequestDTO;
import com.example.apipagamentocobrefacil.gateway.cobrefacil.dto.response.CF_ClienteResponseDTO;
import com.example.apipagamentocobrefacil.gateway.cobrefacil.dto.response.CF_DeleteClienteResponseDTO;
import com.example.apipagamentocobrefacil.gateway.cobrefacil.dto.response.CF_NewClienteResponseDTO;
import com.example.apipagamentocobrefacil.gateway.cobrefacil.dto.response.CF_UpdateClienteResponseDTO;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Headers({"Content-Type: application/json"})
@FeignClient(name="cobrefacil", url="${microservice.sandbox.cobrefacil.url.base}",configuration = FeignConfig.class)
public interface CobreFacilClient {

    @GetMapping("/customers")
    CF_ClienteResponseDTO clients();

    @PostMapping(value = "/customers", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    CF_NewClienteResponseDTO newClientPF(@RequestBody CF_NewClientPFRequestDTO client);

    @PostMapping(value = "/customers", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    CF_NewClienteResponseDTO newClientPJ(@RequestBody CF_NewClientPJRequestDTO client);

    @GetMapping("/customers/{id}")
    CF_NewClienteResponseDTO clientInfo(@PathVariable("id") String id);

    @DeleteMapping("/customers/{id}")
    CF_DeleteClienteResponseDTO deleteClient(@PathVariable("id") String id);

    @PutMapping("/customers/{id}")
    CF_UpdateClienteResponseDTO updateClient(@PathVariable("id") String id, @RequestBody CF_UpdateClientRequestDTO updateClientRequestDTO);
}