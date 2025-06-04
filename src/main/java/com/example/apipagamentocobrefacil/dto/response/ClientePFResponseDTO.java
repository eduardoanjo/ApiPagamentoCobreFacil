package com.example.apipagamentocobrefacil.dto.response;

import com.example.apipagamentocobrefacil.gateway.cobrefacil.model.CF_Cliente_PF;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ClientePFResponseDTO extends CF_Cliente_PF {
}
