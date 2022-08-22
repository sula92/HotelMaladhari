package com.sula.maladhari_hotel.repository;

import com.sula.maladhari_hotel.model.Room;
import com.sula.maladhari_hotel.model.enums.ReservationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room,Integer> {

    @Query("update RoomReservation rs set rs.reservationStatus=:status where rs.id=:id")
    @Modifying
    public void updateStatus(@Param("id") Integer id, @Param("status") ReservationStatus status);
}
