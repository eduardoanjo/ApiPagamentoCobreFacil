package com.example.apipagamentocobrefacil.gateway.cobrefacil.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CF_Cliente_PF extends CF_Cliente implements Serializable {

    private static final long serialVersionUID = 6684135380186767458L;

    private String taxpayerId;
    private String personalName;
}
