package com.sula.maladhari_hotel.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Builder
public class ResidentilSuitReservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private ResidentialSuite residentialSuite;

    private Customer customer;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_reserved")
    private Date dateOfReserved;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_arrival")
    private Date dateOfArrival;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_departure")
    private Date dateOfADeparture;

    private long discount;
}
