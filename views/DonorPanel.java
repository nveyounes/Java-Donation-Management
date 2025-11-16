package views;

import controllers.DonorController;
import models.Donor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DonorPanel extends JPanel {
    private DonorController donorController;
    private JTextField nameField;
    private JTextField emailField;
    private JTextField phoneField;
    private JTable donorTable;
    private DefaultTableModel tableModel;

    public DonorPanel() {
        donorController = new DonorController();

        setLayout(new BorderLayout());
        setBackground(new Color(230, 240, 255));

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(4, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        formPanel.setBackground(new Color(230, 240, 255));

        formPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        formPanel.add(nameField);

        formPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        formPanel.add(emailField);

        formPanel.add(new JLabel("Phone:"));
        phoneField = new JTextField();
        formPanel.add(phoneField);

        JButton addButton = new JButton("Add Donor");
        addButton.setBackground(new Color(100, 149, 237));
        addButton.setForeground(Color.WHITE);
        addButton.setFocusPainted(false);
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String email = emailField.getText();
                String phone = phoneField.getText();
                donorController.registerDonor(name, email, phone);
                displayDonors();
            }
        });
        formPanel.add(addButton);

        add(formPanel, BorderLayout.NORTH);

        tableModel = new DefaultTableModel(new Object[]{"ID", "Name", "Email", "Phone"}, 0);
        donorTable = new JTable(tableModel);
        donorTable.setRowHeight(30);
        donorTable.setShowGrid(true);
        donorTable.setGridColor(Color.GRAY);
        donorTable.setFont(new Font("Serif", Font.PLAIN, 18));
        donorTable.getTableHeader().setFont(new Font("Serif", Font.BOLD, 18));
        donorTable.getTableHeader().setBackground(new Color(100, 149, 237));
        donorTable.getTableHeader().setForeground(Color.WHITE);
        add(new JScrollPane(donorTable), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(230, 240, 255));
        JButton editButton = new JButton("Edit Donor");
        JButton deleteButton = new JButton("Delete Donor");

        editButton.setBackground(new Color(100, 149, 237));
        editButton.setForeground(Color.WHITE);
        editButton.setFocusPainted(false);
        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = donorTable.getSelectedRow();
                if (selectedRow != -1) {
                    int donorId = (int) tableModel.getValueAt(selectedRow, 0);
                    String name = (String) tableModel.getValueAt(selectedRow, 1);
                    String email = (String) tableModel.getValueAt(selectedRow, 2);
                    String phone = (String) tableModel.getValueAt(selectedRow, 3);

                    nameField.setText(name);
                    emailField.setText(email);
                    phoneField.setText(phone);

                    donorController.getDonors().removeIf(donor -> donor.getId() == donorId);
                    tableModel.removeRow(selectedRow);
                }
            }
        });

        deleteButton.setBackground(new Color(100, 149, 237));
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setFocusPainted(false);
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = donorTable.getSelectedRow();
                if (selectedRow != -1) {
                    int donorId = (int) tableModel.getValueAt(selectedRow, 0);
                    donorController.getDonors().removeIf(donor -> donor.getId() == donorId);
                    tableModel.removeRow(selectedRow);
                }
            }
        });

        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        add(buttonPanel, BorderLayout.SOUTH);

        displayDonors();
    }

    private void displayDonors() {
        java.util.List<Donor> donors = donorController.getDonors();
        tableModel.setRowCount(0);
        for (Donor donor : donors) {
            tableModel.addRow(new Object[]{donor.getId(), donor.getName(), donor.getEmail(), donor.getPhone()});
        }
    }
}
