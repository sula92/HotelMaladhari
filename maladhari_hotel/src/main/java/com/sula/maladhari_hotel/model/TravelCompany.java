package com.sula.maladhari_hotel.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "travel_company")
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Builder
public class TravelCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "contact_number")
    private String contactNumber;

    private String email;
}
