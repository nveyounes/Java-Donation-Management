package controllers;

import models.Donor;
import java.util.ArrayList;
import java.util.List;

public class DonorController {
    private List<Donor> donors;

    public DonorController() {
        this.donors = new ArrayList<>();
    }

    public void registerDonor(String name, String email, String phone) {
        int id = donors.size() + 1;
        Donor donor = new Donor(id, name, email, phone);
        donors.add(donor);
    }

    public List<Donor> getDonors() {
        return donors;
    }
}
