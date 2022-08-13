package com.sula.maladhari_hotel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OptionalServiceDetail {

    @Id
    private int id;
    @Column(name = "service_type")
    private String serviceType;
    private int customerId;
    @Column(name = "room_charges")
    private long roomCharges;
}
