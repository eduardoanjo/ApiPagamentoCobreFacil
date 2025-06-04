package com.example.apipagamentocobrefacil.gateway.cobrefacil.dto.request;

import com.example.apipagamentocobrefacil.gateway.cobrefacil.model.CF_Cliente;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CF_NewClientPFRequestDTO extends CF_Cliente {

    @JsonProperty(required = true)
    private String taxpayerId;
    @JsonProperty(required = true)
    private String personalName;
}
