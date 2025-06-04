package com.example.apipagamentocobrefacil.dto.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor(onConstructor_= {@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)} )
@ToString
@EqualsAndHashCode
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AddressRequestDTO{

    @JsonProperty(required = true)
    private String description;
    @JsonProperty(required = true)
    private String zipcode;
    @JsonProperty(required = true)
    private String street;
    @JsonProperty(required = true)
    private String number;
    @JsonProperty(required = true)
    private String complement;
    @JsonProperty(required = true)
    private String neighborhood;
    @JsonProperty(required = true)
    private String city;
    @JsonProperty(required = true)
    private String state;
}
