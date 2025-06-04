package com.example.apipagamentocobrefacil.gateway.cobrefacil.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "person_type", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = CF_Cliente_PF.class, name = "1"),
        @JsonSubTypes.Type(value = CF_Cliente_PJ.class, name = "2")
})
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CF_Cliente implements Serializable {

    @Serial
    private static final long serialVersionUID = -8415403943817592801L;

    private String id;
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
