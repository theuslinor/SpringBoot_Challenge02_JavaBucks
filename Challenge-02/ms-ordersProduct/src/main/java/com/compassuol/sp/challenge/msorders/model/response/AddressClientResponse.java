package com.compassuol.sp.challenge.msorders.model.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AddressClientResponse {
    @JsonIgnore
    private Long id;

    private String street;

    private Long number;

    private String complement;

    private String city;

    @JsonIgnore
    private String neighborhood;

    private String state;

    private String postal_code;

}
