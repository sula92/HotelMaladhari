package com.sula.maladhari_hotel.repository;

import com.sula.maladhari_hotel.model.CreditCardDetails;
import com.sula.maladhari_hotel.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardDetailsRepository extends JpaRepository<CreditCardDetails,Integer> {
}
