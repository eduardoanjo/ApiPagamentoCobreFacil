package com.example.apipagamentocobrefacil.gateway.cobrefacil.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CF_AuthenticateResponseDTO implements Serializable {

    private static final long serialVersionUID = 3789745340524566976L;

    private String success;
    private CF_DataAuthenticateResponseDTO data;
}
