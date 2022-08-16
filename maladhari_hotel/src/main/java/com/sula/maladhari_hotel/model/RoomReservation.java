package com.sula.maladhari_hotel.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "room_reservation")
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Builder
public class RoomReservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @NotNull
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "travel_company_id", referencedColumnName = "id")
    TravelCompany travelCompany;

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

    @Column(name = "restaurant_charges")
    private long restaurantCharges;

    @Column(name = "room_service")
    private long roomService ;

    @Column(name = "laundry")
    private long laundry;

    private long telephone;

    private long club;

    private boolean isCardDetailProvided;

    private boolean isPaymentsCompleted;

    private long discount;
}
