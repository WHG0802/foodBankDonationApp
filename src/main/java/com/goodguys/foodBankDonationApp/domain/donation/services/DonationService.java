package com.goodguys.foodBankDonationApp.domain.donation.services;

import com.goodguys.foodBankDonationApp.domain.core.ResourceNotFoundException;
import com.goodguys.foodBankDonationApp.domain.donation.model.Donation;
import com.goodguys.foodBankDonationApp.domain.donation.model.DonationType;

import java.util.List;

public interface DonationService {
    Donation create (Donation donation);
    List<Donation> getAll();
    Donation getById(Long id) throws ResourceNotFoundException;
    Donation getByEmail(String email) throws ResourceNotFoundException;
    List<Donation> getByDonationType(DonationType type) throws ResourceNotFoundException;
    Donation update(Long id, Donation donationDetail) throws ResourceNotFoundException;
    void delete(Long id) throws ResourceNotFoundException;
}
