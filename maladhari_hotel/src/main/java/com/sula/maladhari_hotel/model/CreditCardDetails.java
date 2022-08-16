package com.sula.maladhari_hotel.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "credit_card_details")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreditCardDetails {

    @Id
    private String cardNumber;
    private int secretNumber;
    @OneToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;
}
