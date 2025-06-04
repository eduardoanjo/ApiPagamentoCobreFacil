package com.example.apipagamentocobrefacil.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ClienteResponseDTO{

    private List<ClientePFResponseDTO> clientsPF;
    private List<ClientePJResponseDTO> clientsPJ;
}
