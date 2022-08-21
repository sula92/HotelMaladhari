package com.sula.maladhari_hotel.controller;

import com.sula.maladhari_hotel.exceptions.custom.ResourceAlreadyExisistException;
import com.sula.maladhari_hotel.exceptions.custom.ResourceNotFoundException;
import com.sula.maladhari_hotel.model.TravelCompany;
import com.sula.maladhari_hotel.repository.TravelCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/travel_company")
public class TravelCompanyController {

    @Autowired
    TravelCompanyRepository travelCompanyRepository;

    @GetMapping("/")
    public List<TravelCompany> getAllTravelCompanys() throws ResourceNotFoundException {

        try {
            return travelCompanyRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResourceNotFoundException(HttpStatus.NOT_FOUND, "No travelCompanys Are Available");
        }
    }

    /**
     * Create travelCompany.
     *
     * @param travelCompany the TravelCompany
     * @return the travelCompany
     */
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public TravelCompany saveTravelCompany(@Valid @RequestBody TravelCompany travelCompany) throws ResourceAlreadyExisistException {
        TravelCompany travelCompany1=
                travelCompanyRepository
                        .findById(travelCompany.getId())
                        .orElseThrow(() -> new ResourceAlreadyExisistException(HttpStatus.NOT_ACCEPTABLE,"TravelCompany is already exists on :: " + travelCompany.getId()));

        return travelCompanyRepository.save(travelCompany);
    }

    /**
     * Update TravelCompany response entity.
     *
     * @param travelCompanyId the TravelCompany id
     * @param travelCompanyDetails the TravelCompany details
     * @return the response entity
     * @throws ResourceNotFoundException the resource not found exception
     */
    @PutMapping("/{id}")
    public ResponseEntity<TravelCompany> editTravelCompany(@PathVariable(value = "id") int travelCompanyId, @Valid @RequestBody TravelCompany travelCompanyDetails) throws ResourceNotFoundException {
        TravelCompany travelCompany1=
                travelCompanyRepository
                        .findById(travelCompanyId)
                        .orElseThrow(() -> new ResourceNotFoundException(HttpStatus.NOT_FOUND,"TravelCompany not found on :: " + travelCompanyId));

        travelCompany1.setCompanyName(travelCompanyDetails.getCompanyName());
        travelCompany1.setContactNumber(travelCompanyDetails.getContactNumber());
        travelCompany1.setEmail(travelCompanyDetails.getEmail());

        final TravelCompany updatedTravelCompany=travelCompanyRepository.save(travelCompany1);
        return ResponseEntity.ok(updatedTravelCompany);
    }

    @DeleteMapping("/{id}")
    public void deleteBranch(@PathVariable int id) throws Exception {
        if (!(travelCompanyRepository.getReferenceById(id)==null)) {
            travelCompanyRepository.deleteById(id);
        }
        else {
            throw new ResourceNotFoundException("No Such Branch");
        }
    }
}
