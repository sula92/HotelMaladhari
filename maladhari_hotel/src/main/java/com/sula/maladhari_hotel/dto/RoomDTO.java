package com.sula.maladhari_hotel.dto;

import com.sula.maladhari_hotel.model.RoomReservation;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
@Builder
public class RoomDTO {

    private String id;
    private long chargesPerDay;
    private int floor;
    private String availability;
}
