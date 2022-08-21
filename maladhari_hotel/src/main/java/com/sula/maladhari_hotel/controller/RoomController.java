package com.sula.maladhari_hotel.controller;

import com.sula.maladhari_hotel.exceptions.custom.ResourceAlreadyExisistException;
import com.sula.maladhari_hotel.exceptions.custom.ResourceNotFoundException;
import com.sula.maladhari_hotel.model.Room;
import com.sula.maladhari_hotel.repository.RoomRepository;
import com.sula.maladhari_hotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/room")
public class RoomController {

    @Autowired
    RoomRepository roomRepository;

    @GetMapping("/")
    public List<Room> getAllRooms() throws ResourceNotFoundException {

        try {
            return roomRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResourceNotFoundException(HttpStatus.NOT_FOUND, "No rooms Are Available");
        }
    }

    /**
     * Create room.
     *
     * @param room the Room
     * @return the room
     */
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Room saveRoom(@Valid @RequestBody Room room) throws ResourceAlreadyExisistException {
        Room room1=
                roomRepository
                        .findById(room.getId())
                        .orElseThrow(() -> new ResourceAlreadyExisistException(HttpStatus.NOT_ACCEPTABLE,"Room is already exists on :: " + room.getId()));

        return roomRepository.save(room);
    }

    /**
     * Update Room response entity.
     *
     * @param roomId the Room id
     * @param roomDetails the Room details
     * @return the response entity
     * @throws ResourceNotFoundException the resource not found exception
     */
    @PutMapping("/{id}")
    public ResponseEntity<Room> editRoom(@PathVariable(value = "id") int roomId, @Valid @RequestBody Room roomDetails) throws ResourceNotFoundException {
        Room room1=
                roomRepository
                        .findById(roomId)
                        .orElseThrow(() -> new ResourceNotFoundException(HttpStatus.NOT_FOUND,"Room not found on :: " + roomId));

        room1.setAvailability(roomDetails.getAvailability());
        room1.setChargesPerDay(roomDetails.getChargesPerDay());
        room1.setFloor(roomDetails.getFloor());

        final Room updatedRoom=roomRepository.save(room1);
        return ResponseEntity.ok(updatedRoom);
    }

    @DeleteMapping("/{id}")
    public void deleteBranch(@PathVariable int id) throws Exception {
        if (!(roomRepository.getReferenceById(id)==null)) {
            roomRepository.deleteById(id);
        }
        else {
            throw new ResourceNotFoundException("No Such Branch");
        }
    }
}
