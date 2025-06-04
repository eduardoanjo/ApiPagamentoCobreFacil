package com.example.apipagamentocobrefacil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.web.bind.annotation.CrossOrigin;

@EnableRetry
@CrossOrigin
@EnableFeignClients
@SpringBootApplication
@EnableAspectJAutoProxy
public class ApiPagamentoCobreFacilApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiPagamentoCobreFacilApplication.class, args);
    }

}
