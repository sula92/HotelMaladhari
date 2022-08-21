package com.sula.maladhari_hotel.repository;

import com.sula.maladhari_hotel.model.Room;
import com.sula.maladhari_hotel.model.RoomReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomReservationRepository extends JpaRepository<RoomReservation,Integer> {
}
