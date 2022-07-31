package com.goodguys.foodBankDonationApp.domain.donation;

import com.goodguys.foodBankDonationApp.domain.donation.model.Donation;
import com.goodguys.foodBankDonationApp.domain.donation.model.DonationType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class DonationTest {

    @Test
    public void userConstructorTest(){
        Donation donation = new Donation("William", "Guy", "abc@123", "Cereal", DonationType.NONPERISHABLE,"Frosted Flakes");
        donation.setId(1L);
        String expected = "1 William Guy abc@123 Cereal NONPERISHABLE Frosted Flakes";
        String actual = donation.toString();
        Assertions.assertEquals(expected,actual);
    }
}
