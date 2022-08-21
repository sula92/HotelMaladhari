package com.sula.maladhari_hotel.dto;

import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Validated
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDTO {

    @NotNull
    private int id;
    @NotNull
    private String name;
    @NotNull
    private String address;
    private String email;
}
