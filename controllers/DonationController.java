package controllers;

import models.Donation;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DonationController {
    private List<Donation> donations;

    public DonationController() {
        this.donations = new ArrayList<>();
    }

    public void addDonation(int donorId, double amount) {
        int id = donations.size() + 1;
        Donation donation = new Donation(id, donorId, amount, new Date());
        donations.add(donation);
    }

    public List<Donation> getDonations() {
        return donations;
    }
}
