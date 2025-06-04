package com.example.apipagamentocobrefacil.gateway.cobrefacil.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.federasys.pagamentofederacao.gateway.cobrefacil.model.CF_Cliente;
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
public class CF_DeleteClienteResponseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -6948102759235899486L;

    private boolean success;
    private CF_Cliente data;
}
