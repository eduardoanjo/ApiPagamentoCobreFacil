package com.example.apipagamentocobrefacil.dto.response;

import com.example.apipagamentocobrefacil.dto.UpdateClientDTO;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UpdateClientResponseDTO extends UpdateClientDTO {
}
