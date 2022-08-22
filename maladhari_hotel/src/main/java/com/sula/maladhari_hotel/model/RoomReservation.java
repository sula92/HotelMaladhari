package com.sula.maladhari_hotel.model;

import com.sula.maladhari_hotel.model.enums.ReservationStatus;
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

    @ManyToMany
    @JoinTable(
            name = "room_reservation_detail",
            joinColumns = {@JoinColumn(name = "reservation_id")},
            inverseJoinColumns = {@JoinColumn(name = "room_id")}
    )
    private List<Room> rooms;

    @Column(name = "reservation_status")
    private ReservationStatus reservationStatus;

    @OneToOne
    @JoinColumn(name = "travel_company_id", referencedColumnName = "id", nullable = true)
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
    private double restaurantCharges;

    @Column(name = "room_service")
    private double roomService ;

    @Column(name = "laundry_expences")
    private double laundryExpences;

    private double telephoneExpences;

    private double clubExpences;

    private boolean isCardDetailProvided;

    private boolean isPaymentsCompleted;

    private long discount;
}
