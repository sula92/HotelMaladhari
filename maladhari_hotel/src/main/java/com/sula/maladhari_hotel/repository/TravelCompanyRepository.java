package com.sula.maladhari_hotel.repository;

import com.sula.maladhari_hotel.model.TravelCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelCompanyRepository extends JpaRepository<TravelCompany, Integer> {
}
