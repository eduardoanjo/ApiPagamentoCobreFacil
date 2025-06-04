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
@AllArgsConstructor(onConstructor_= {
        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES),
})
@ToString
@EqualsAndHashCode(callSuper = false)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class NewPFClienteRequestDTO extends NewClienteRequestDTO{

    @JsonProperty(required = true)
    private String taxpayerId;
    @JsonProperty(required = true)
    private String personalName;
}
