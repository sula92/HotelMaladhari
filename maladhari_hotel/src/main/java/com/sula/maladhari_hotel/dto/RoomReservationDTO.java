package com.sula.maladhari_hotel.dto;

import com.sula.maladhari_hotel.model.Customer;
import lombok.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class RoomReservationDTO {

    private int id;

    private int customerId;

    int travelCompanyId;

    private Date dateOfReserved;

    private Date dateOfArrival;

    private Date dateOfADeparture;

    private long restaurantCharges;

    private long roomService ;

    private long laundry;

    private long telephone;

    private long club;

    private boolean isCardDetailProvided;

    private boolean isPaymentsCompleted;

    private long discount;
}
