package com.example.apipagamentocobrefacil.gateway.cobrefacil.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CobreFacilAuthenticateRequestDTO implements Serializable {

    private static final long serialVersionUID = 756673107351715517L;

    private String appId;
    private String secret;
}