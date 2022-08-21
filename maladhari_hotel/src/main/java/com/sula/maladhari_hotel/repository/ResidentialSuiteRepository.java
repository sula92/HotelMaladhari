package com.sula.maladhari_hotel.repository;

import com.sula.maladhari_hotel.model.ResidentialSuite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResidentialSuiteRepository extends JpaRepository<ResidentialSuite,Integer> {
}
