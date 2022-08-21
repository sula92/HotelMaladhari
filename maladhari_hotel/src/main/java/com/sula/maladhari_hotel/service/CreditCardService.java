package com.sula.maladhari_hotel.service;

import com.sula.maladhari_hotel.dto.CreditCardDetailsDTO;
import com.sula.maladhari_hotel.model.CreditCardDetails;
import com.sula.maladhari_hotel.repository.CreditCardDetailsRepository;
import com.sula.maladhari_hotel.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CreditCardService {

    @Autowired
    CreditCardDetailsRepository creditCardDetailsRepository;

    @Autowired
    CustomerRepository customerRepository;

    public CreditCardDetails save(CreditCardDetailsDTO creditCardDetails) {

        int cusId=creditCardDetails.getCustomerId();

        return creditCardDetailsRepository.save(CreditCardDetails.builder()
                .cardNumber(creditCardDetails.getCardNumber())
                .customer(customerRepository.getReferenceById(cusId))
                .secretNumber(creditCardDetails.getSecretNumber())
                .build());
    }
}
