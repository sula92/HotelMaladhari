package com.sula.maladhari_hotel.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Room {

    @Id
    private String id;
    @Column(name = "charges_per_day")
    private long chargesPerDay;
    private int floor;
    private String condition;
    private String availability;
}
