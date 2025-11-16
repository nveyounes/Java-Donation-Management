package views;

import controllers.DonationController;
import models.Donation;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DonationPanel extends JPanel {
    private DonationController donationController;
    private JTextField donorIdField;
    private JTextField amountField;
    private JTable donationTable;
    private DefaultTableModel tableModel;

    public DonationPanel() {
        donationController = new DonationController();

        setLayout(new BorderLayout());
        setBackground(new Color(230, 240, 255));

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(3, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        formPanel.setBackground(new Color(230, 240, 255));

        formPanel.add(new JLabel("Donor ID:"));
        donorIdField = new JTextField();
        formPanel.add(donorIdField);

        formPanel.add(new JLabel("Amount:"));
        amountField = new JTextField();
        formPanel.add(amountField);

        JButton addButton = new JButton("Add Donation");
        addButton.setBackground(new Color(100, 149, 237));
        addButton.setForeground(Color.WHITE);
        addButton.setFocusPainted(false);
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int donorId = Integer.parseInt(donorIdField.getText());
                double amount = Double.parseDouble(amountField.getText());
                donationController.addDonation(donorId, amount);
                displayDonations();
            }
        });
        formPanel.add(addButton);

        add(formPanel, BorderLayout.NORTH);

        tableModel = new DefaultTableModel(new Object[]{"ID", "Donor ID", "Amount", "Date"}, 0);
        donationTable = new JTable(tableModel);
        donationTable.setRowHeight(30);
        donationTable.setShowGrid(true);
        donationTable.setGridColor(Color.GRAY);
        donationTable.setFont(new Font("Serif", Font.PLAIN, 18));
        donationTable.getTableHeader().setFont(new Font("Serif", Font.BOLD, 18));
        donationTable.getTableHeader().setBackground(new Color(100, 149, 237));
        donationTable.getTableHeader().setForeground(Color.WHITE);
        add(new JScrollPane(donationTable), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(230, 240, 255));
        JButton deleteButton = new JButton("Delete Donation");

        deleteButton.setBackground(new Color(100, 149, 237));
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setFocusPainted(false);
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = donationTable.getSelectedRow();
                if (selectedRow != -1) {
                    int donationId = (int) tableModel.getValueAt(selectedRow, 0);
                    donationController.getDonations().removeIf(donation -> donation.getId() == donationId);
                    tableModel.removeRow(selectedRow);
                }
            }
        });

        buttonPanel.add(deleteButton);
        add(buttonPanel, BorderLayout.SOUTH);

        displayDonations();
    }

    private void displayDonations() {
        java.util.List<Donation> donations = donationController.getDonations();
        tableModel.setRowCount(0);
        for (Donation donation : donations) {
            tableModel.addRow(new Object[]{donation.getId(), donation.getDonorId(), donation.getAmount(), donation.getDate()});
        }
    }
}
