package com.goodguys.foodBankDonationApp.domain.donation.services;

import com.goodguys.foodBankDonationApp.domain.core.ResourceNotFoundException;
import com.goodguys.foodBankDonationApp.domain.donation.model.Donation;
import com.goodguys.foodBankDonationApp.domain.donation.model.DonationType;
import com.goodguys.foodBankDonationApp.domain.donation.repository.DonationRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DonationServiceImpl implements DonationService{

    private DonationRepo donationRepo;

    @Autowired
    public DonationServiceImpl(DonationRepo donationRepo) {
        this.donationRepo = donationRepo;
    }

    @Override
    public Donation create(Donation donation){
        return donationRepo.save(donation);
    }

    @Override
    public Donation getById(Long id) throws ResourceNotFoundException {
        Donation donation = donationRepo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("No Donation with id: " + id));
        return donation;
    }

    @Override
    public Donation getByEmail(String email) throws ResourceNotFoundException {
        Donation donation = donationRepo.findByEmail(email)
                .orElseThrow(()->new ResourceNotFoundException("No Donor with email: " + email));
        return donation;
    }

    @Override
    public List<Donation> getAll() {
        return donationRepo.findAll();
    }

    @Override
    public List<Donation> getByDonationType(DonationType type) throws ResourceNotFoundException {
        List<Donation> items = donationRepo.findByDonationType(type);
        return items;
    }

    @Override
    public Donation update(Long id, Donation donationDetail) throws ResourceNotFoundException {
        Donation donation = getById(id);
        donation.setEmail(donationDetail.getEmail());
        donation.setType(donationDetail.getType());
        donation = donationRepo.save(donation);
        return donation;
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        Donation donation = getById(id);
        donationRepo.delete(donation);
    }
}
