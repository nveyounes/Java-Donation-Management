package models;

import java.util.Date;

public class Donation {
    private int id;
    private int donorId;
    private double amount;
    private Date date;

    public Donation(int id, int donorId, double amount, Date date) {
        this.id = id;
        this.donorId = donorId;
        this.amount = amount;
        this.date = date;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getDonorId() { return donorId; }
    public void setDonorId(int donorId) { this.donorId = donorId; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }
}
