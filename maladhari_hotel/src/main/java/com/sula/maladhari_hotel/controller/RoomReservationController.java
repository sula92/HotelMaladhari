package com.sula.maladhari_hotel.controller;

import com.sula.maladhari_hotel.exceptions.custom.ResourceAlreadyExisistException;
import com.sula.maladhari_hotel.exceptions.custom.ResourceNotFoundException;
import com.sula.maladhari_hotel.model.RoomReservation;
import com.sula.maladhari_hotel.repository.RoomReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/roomReservation_reservation")
@CrossOrigin
public class RoomReservationController {

    @Autowired
    RoomReservationRepository roomReservationRepository;

    @GetMapping("/")
    public List<RoomReservation> getAllRoomReservations() throws ResourceNotFoundException {

        try {
            return roomReservationRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResourceNotFoundException(HttpStatus.NOT_FOUND, "No roomReservations Are Available");
        }
    }

    /**
     * Create roomReservation.
     *
     * @param roomReservation the RoomReservation
     * @return the roomReservation
     */
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public RoomReservation saveRoomReservation(@Valid @RequestBody RoomReservation roomReservation) throws ResourceAlreadyExisistException {
        RoomReservation roomReservation1=
                roomReservationRepository
                        .findById(roomReservation.getId())
                        .orElseThrow(() -> new ResourceAlreadyExisistException(HttpStatus.NOT_ACCEPTABLE,"RoomReservation is already exists on :: " + roomReservation.getId()));

        return roomReservationRepository.save(roomReservation);
    }

    /**
     * Update RoomReservation response entity.
     *
     * @param roomReservationId the RoomReservation id
     * @param roomReservationDetails the RoomReservation details
     * @return the response entity
     * @throws ResourceNotFoundException the resource not found exception
     */
    @PutMapping("/{id}")
    public ResponseEntity<RoomReservation> editRoomReservation(@PathVariable(value = "id") int roomReservationId, @Valid @RequestBody RoomReservation roomReservationDetails) throws ResourceNotFoundException {
        RoomReservation roomReservation1=
                roomReservationRepository
                        .findById(roomReservationId)
                        .orElseThrow(() -> new ResourceNotFoundException(HttpStatus.NOT_FOUND,"RoomReservation not found on :: " + roomReservationId));

        roomReservation1.setCardDetailProvided(roomReservationDetails.isCardDetailProvided());
        roomReservation1.setCardDetailProvided(roomReservationDetails.isCardDetailProvided());
        roomReservation1.setCardDetailProvided(roomReservationDetails.isCardDetailProvided());
        roomReservation1.setCardDetailProvided(roomReservationDetails.isCardDetailProvided());
        roomReservation1.setCardDetailProvided(roomReservationDetails.isCardDetailProvided());

        final RoomReservation updatedRoomReservation=roomReservationRepository.save(roomReservation1);
        return ResponseEntity.ok(updatedRoomReservation);
    }

    @DeleteMapping("/{id}")
    public void deleteBranch(@PathVariable int id) throws Exception {
        if (!(roomReservationRepository.getReferenceById(id)==null)) {
            roomReservationRepository.deleteById(id);
        }
        else {
            throw new ResourceNotFoundException("No Such Branch");
        }
    }
}
