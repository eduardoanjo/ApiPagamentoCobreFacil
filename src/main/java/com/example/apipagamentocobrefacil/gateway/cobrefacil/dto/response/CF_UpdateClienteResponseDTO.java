package com.example.apipagamentocobrefacil.gateway.cobrefacil.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.federasys.pagamentofederacao.dto.UpdateClientDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CF_UpdateClienteResponseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 7139612457683429934L;

    private boolean success;
    private UpdateClientDTO data;
}
