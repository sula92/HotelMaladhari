package com.sula.maladhari_hotel.repository;

import com.sula.maladhari_hotel.model.Room;
import com.sula.maladhari_hotel.model.RoomReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomReservationRepository extends JpaRepository<RoomReservation,Integer> {

    List<RoomReservation> findAllByCustomerId();
    List<RoomReservation> findAllByPaymentsCompletedEquals(@Param("paid") Boolean paid);
}
