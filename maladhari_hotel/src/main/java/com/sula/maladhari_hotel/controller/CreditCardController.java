package com.sula.maladhari_hotel.controller;

import com.sula.maladhari_hotel.dto.CreditCardDetailsDTO;
import com.sula.maladhari_hotel.exceptions.custom.ResourceAlreadyExisistException;
import com.sula.maladhari_hotel.exceptions.custom.ResourceNotFoundException;
import com.sula.maladhari_hotel.model.CreditCardDetails;
import com.sula.maladhari_hotel.model.Customer;
import com.sula.maladhari_hotel.repository.CreditCardDetailsRepository;
import com.sula.maladhari_hotel.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.function.Predicate;

@RestController
@CrossOrigin
@RequestMapping("/api/credit_card")
public class CreditCardController {

    @Autowired
    CreditCardDetailsRepository creditCardDetailsRepository;

    @Autowired
    CreditCardService creditCardService;

    @GetMapping("/")
    public List<CreditCardDetails> getAllCreditCardDetailss() throws ResourceNotFoundException {

        try {
            return creditCardDetailsRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResourceNotFoundException(HttpStatus.NOT_FOUND, "No creditCardDetailss Are Available");
        }
    }

    /**
     * Create creditCardDetails.
     *
     * @param creditCardDetails the CreditCardDetails
     * @return the creditCardDetails
     */
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public CreditCardDetails saveCreditCardDetails(@Valid @RequestBody CreditCardDetailsDTO creditCardDetails) throws ResourceAlreadyExisistException {
        CreditCardDetails creditCardDetails1=
                creditCardDetailsRepository
                        .findById(creditCardDetails.getId())
                        .orElseThrow(() -> new ResourceAlreadyExisistException(HttpStatus.NOT_ACCEPTABLE,"record is already exists on :: " + creditCardDetails.getId()));

        return creditCardService.save(creditCardDetails);
    }

    /**
     * Update CreditCardDetails response entity.
     *
     * @param creditCardDetailsId the CreditCardDetails id
     * @param creditCardDetails the CreditCardDetails details
     * @return the response entity
     * @throws ResourceNotFoundException the resource not found exception
     */
    @PutMapping("/{id}")
    public ResponseEntity<CreditCardDetailsDTO> editCreditCardDetails(@PathVariable(value = "id") int creditCardDetailsId, @Valid @RequestBody CreditCardDetailsDTO creditCardDetails) throws ResourceNotFoundException {
        CreditCardDetails creditCardDetails1=
                creditCardDetailsRepository
                        .findById(creditCardDetailsId)
                        .orElseThrow(() -> new ResourceNotFoundException(HttpStatus.NOT_FOUND,"CreditCardDetails not found on :: " + creditCardDetailsId));


        final CreditCardDetails updatedCreditCardDetails=creditCardService.save(creditCardDetails);

        return ResponseEntity.ok(
                CreditCardDetailsDTO.builder()
        .cardNumber(updatedCreditCardDetails.getCardNumber())
        .customerId(updatedCreditCardDetails.getCustomer().getId())
        .secretNumber(updatedCreditCardDetails.getSecretNumber())
        .build()
        );
    }

    @DeleteMapping("/{id}")
    public void deleteBranch(@PathVariable int id) throws Exception {
        if (!(creditCardDetailsRepository.getReferenceById(id)==null)) {
            creditCardDetailsRepository.deleteById(id);
        }
        else {
            throw new ResourceNotFoundException("No Such Record");
        }
    }
}
