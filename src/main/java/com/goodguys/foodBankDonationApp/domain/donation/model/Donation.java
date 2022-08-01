package com.goodguys.foodBankDonationApp.domain.donation.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private String email;

    @NonNull
    private String nameOfDonation;

    @NonNull
    private DonationType type;

    @NonNull
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @PrePersist
    private void create(){
        date = new Date();
    }

    public String toString() {
        return String.format("%d %s %s %s %s %s %s", id, firstName, lastName, email, nameOfDonation, type, description);
    }
}
