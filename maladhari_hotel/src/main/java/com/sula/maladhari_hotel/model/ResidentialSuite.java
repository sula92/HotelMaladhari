package com.sula.maladhari_hotel.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "residential_suit")
@Data
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class ResidentialSuite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String type;

    @Column(name = "weekly_charges")
    private long weeklyCharges;

    @Column(name = "monthly_charges")
    private long monthlyCharges;

    @ManyToOne
    @JoinColumn(name = "reservation_id", referencedColumnName = "id", nullable = true)
    private ResidentialSuitReservation residentialSuitReservation;

    private String availability;
}
