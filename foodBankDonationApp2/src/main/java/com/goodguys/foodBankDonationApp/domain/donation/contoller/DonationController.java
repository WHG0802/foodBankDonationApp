package com.goodguys.foodBankDonationApp.domain.donation.contoller;

import com.goodguys.foodBankDonationApp.domain.donation.model.Donation;
import com.goodguys.foodBankDonationApp.domain.donation.services.DonationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/donations")
public class DonationController {

    private DonationService donationService;

    public DonationController(DonationService donationService) {
        this.donationService = donationService;
    }

    @GetMapping
    public ResponseEntity<List<Donation>> getAll(){
        List<Donation> requests = donationService.getAll();
        return new ResponseEntity<>(requests, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Donation> create(@RequestBody Donation donation){
        donation = donationService.create(donation);
        return new ResponseEntity<>(donation, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Donation> getById(@PathVariable("id") Long id){
        Donation donation = donationService.getById(id);
        return new ResponseEntity<>(donation, HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Donation> getByEmail(@RequestParam String email){
        Donation donation = donationService.getByEmail(email);
        return new ResponseEntity<>(donation, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Donation> update(@PathVariable("id") Long id, @RequestBody Donation donationDetail){
        donationDetail = donationService.update(id, donationDetail);
        return new ResponseEntity<>(donationDetail, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        donationService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
