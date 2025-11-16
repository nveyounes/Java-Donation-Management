package controllers;

import models.Ad;
import java.util.ArrayList;
import java.util.List;

public class AdController {
    private List<Ad> ads;

    public AdController() {
        this.ads = new ArrayList<>();
    }

    public void createAd(String title, String description, String targetAudience) {
        int id = ads.size() + 1;
        Ad ad = new Ad(id, title, description, targetAudience);
        ads.add(ad);
    }

    public List<Ad> getAds() {
        return ads;
    }
}
