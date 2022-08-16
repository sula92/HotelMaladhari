package com.sula.maladhari_hotel.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Builder
public class Room {

    @Id
    private String id;
    @Column(name = "charges_per_day")
    private long chargesPerDay;
    private int floor;
    private String condition;
    @ManyToOne
    @JoinColumn(name = "reservation_id", referencedColumnName = "id", nullable = true)
    private RoomReservation roomReservation;
    private String availability;
}
