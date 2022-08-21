package com.sula.maladhari_hotel.dto;

import lombok.*;

import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class TravelCompanyDTO {

    private int id;

    private String companyName;

    private String contactNumber;

    private String email;
}
