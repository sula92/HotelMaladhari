package com.sula.maladhari_hotel.model;

import com.sula.maladhari_hotel.model.enums.ReservationStatus;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "residential_suit_reservation")
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Builder
public class ResidentialSuitReservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany
    @JoinTable(
            name = "residentialSuite_reservation_detail",
            joinColumns = {@JoinColumn(name = "reservation_id")},
            inverseJoinColumns = {@JoinColumn(name = "residentialSuite_id")}
    )
    private List<ResidentialSuite> residentialSuites;

    @OneToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @Column(name = "reservation_status")
    private ReservationStatus reservationStatus;

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

    @Column(name = "monthly_or_weekly")
    private long monthlyOrWeekly;

    @Column(name = "charges")
    private long Charges;

    @Column(name = "restaurant_charges")
    private double restaurantCharges;

    @Column(name = "laundry_expences")
    private double laundryExpences;

    private double telephoneExpences;

    private double clubExpences;

    private boolean isCardDetailProvided;

    private boolean isPaymentsCompleted;

    private long discount;
}
