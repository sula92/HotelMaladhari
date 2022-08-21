package com.sula.maladhari_hotel.controller;

import com.sula.maladhari_hotel.exceptions.custom.ResourceAlreadyExisistException;
import com.sula.maladhari_hotel.exceptions.custom.ResourceNotFoundException;
import com.sula.maladhari_hotel.model.User;
import com.sula.maladhari_hotel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public List<User> getAllUsers() throws ResourceNotFoundException {

        try {
            return userRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResourceNotFoundException(HttpStatus.NOT_FOUND, "No Users Are Available");
        }
    }

    /**
     * Create User.
     *
     * @param User the User
     * @return the User
     */
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@Valid @RequestBody User User) throws ResourceAlreadyExisistException {
        User User1=
                userRepository
                        .findById(User.getId())
                        .orElseThrow(() -> new ResourceAlreadyExisistException(HttpStatus.NOT_ACCEPTABLE,"User is already exists on :: " + User.getId()));

        return userRepository.save(User);
    }

    /**
     * Update User response entity.
     *
     * @param UserId the User id
     * @param userDetails the User details
     * @return the response entity
     * @throws ResourceNotFoundException the resource not found exception
     */
    @PutMapping("/{id}")
    public ResponseEntity<User> editUser(@PathVariable(value = "id") int UserId, @Valid @RequestBody User userDetails) throws ResourceNotFoundException {
        User User1=
                userRepository
                        .findById(UserId)
                        .orElseThrow(() -> new ResourceNotFoundException(HttpStatus.NOT_FOUND,"User not found on :: " + UserId));

        User1.setName(userDetails.getName());
        User1.setEmail(userDetails.getEmail());
        User1.setPassword(userDetails.getPassword());
        User1.setUserName(userDetails.getUserName());

        final User updatedUser=userRepository.save(User1);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public void deleteBranch(@PathVariable int id) throws Exception {
        if (!(userRepository.getReferenceById(id)==null)) {
            userRepository.deleteById(id);
        }
        else {
            throw new ResourceNotFoundException("No Such Branch");
        }
    }
}
