package com.example.apipagamentocobrefacil.dto;

import com.example.apipagamentocobrefacil.gateway.cobrefacil.model.CF_Address;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UpdateClientDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 4893919979498865268L;

    private String taxpayerId;
    private String personalName;
    private String ein;
    private String companyName;
    private Long personType;
    private String telephone;
    private String cellular;
    private String email;
    private String emailCc;
    private String fullName;
    private String document;
    private CF_Address address;
    private Instant createdAt;
    private Instant updatedAt;
    private Instant deletedAt;
}
