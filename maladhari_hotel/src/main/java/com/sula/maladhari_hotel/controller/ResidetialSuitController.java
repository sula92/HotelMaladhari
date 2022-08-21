package com.sula.maladhari_hotel.controller;

import com.sula.maladhari_hotel.exceptions.custom.ResourceAlreadyExisistException;
import com.sula.maladhari_hotel.exceptions.custom.ResourceNotFoundException;
import com.sula.maladhari_hotel.model.ResidentialSuite;
import com.sula.maladhari_hotel.repository.ResidentialSuiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping
@CrossOrigin
public class ResidetialSuitController {

    @Autowired
    ResidentialSuiteRepository residentialSuiteRepository;

    @GetMapping("/")
    public List<ResidentialSuite> getAllResidentialSuites() throws ResourceNotFoundException {

        try {
            return residentialSuiteRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResourceNotFoundException(HttpStatus.NOT_FOUND, "No residentialSuites Are Available");
        }
    }

    /**
     * Create residentialSuite.
     *
     * @param residentialSuite the ResidentialSuite
     * @return the residentialSuite
     */
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResidentialSuite saveResidentialSuite(@Valid @RequestBody ResidentialSuite residentialSuite) throws ResourceAlreadyExisistException {
        ResidentialSuite residentialSuite1=
                residentialSuiteRepository
                        .findById(residentialSuite.getId())
                        .orElseThrow(() -> new ResourceAlreadyExisistException(HttpStatus.NOT_ACCEPTABLE,"ResidentialSuite is already exists on :: " + residentialSuite.getId()));

        return residentialSuiteRepository.save(residentialSuite);
    }

    /**
     * Update ResidentialSuite response entity.
     *
     * @param residentialSuiteId the ResidentialSuite id
     * @param residentialSuiteDetails the ResidentialSuite details
     * @return the response entity
     * @throws ResourceNotFoundException the resource not found exception
     */
    @PutMapping("/{id}")
    public ResponseEntity<ResidentialSuite> editResidentialSuite(@PathVariable(value = "id") int residentialSuiteId, @Valid @RequestBody ResidentialSuite residentialSuiteDetails) throws ResourceNotFoundException {
        ResidentialSuite residentialSuite1=
                residentialSuiteRepository
                        .findById(residentialSuiteId)
                        .orElseThrow(() -> new ResourceNotFoundException(HttpStatus.NOT_FOUND,"ResidentialSuite not found on :: " + residentialSuiteId));

        residentialSuite1.setAvailability(residentialSuiteDetails.getAvailability());
        residentialSuite1.setResidentialSuitTypes(residentialSuiteDetails.getResidentialSuitTypes());

        final ResidentialSuite updatedResidentialSuite=residentialSuiteRepository.save(residentialSuite1);
        return ResponseEntity.ok(updatedResidentialSuite);
    }

    @DeleteMapping("/{id}")
    public void deleteBranch(@PathVariable int id) throws Exception {
        if (!(residentialSuiteRepository.getReferenceById(id)==null)) {
            residentialSuiteRepository.deleteById(id);
        }
        else {
            throw new ResourceNotFoundException("No Such Record");
        }
    }
}
