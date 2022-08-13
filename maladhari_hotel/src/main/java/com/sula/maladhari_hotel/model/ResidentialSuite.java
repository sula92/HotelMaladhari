package com.sula.maladhari_hotel.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
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

    private String availability;
}
