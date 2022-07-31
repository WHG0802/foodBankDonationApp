package com.goodguys.foodBankDonationApp.domain.donation.repository;

import com.goodguys.foodBankDonationApp.domain.donation.model.Donation;
import com.goodguys.foodBankDonationApp.domain.donation.model.DonationType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DonationRepo extends JpaRepository<Donation, Long> {
    Optional<Donation> findByEmail(String email);
    List<Donation> findByDonationType(DonationType type);
}
