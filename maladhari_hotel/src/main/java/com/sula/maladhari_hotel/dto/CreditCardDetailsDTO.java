package com.sula.maladhari_hotel.dto;

import com.sula.maladhari_hotel.model.Customer;
import lombok.*;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class CreditCardDetailsDTO {

    private int id;
    private String cardNumber;
    private int secretNumber;
    private int customerId;
}
