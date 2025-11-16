package views;

import controllers.AdController;
import models.Ad;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdPanel extends JPanel {
    private AdController adController;
    private JTextField titleField;
    private JTextField descriptionField;
    private JTextField targetAudienceField;
    private JTable adTable;
    private DefaultTableModel tableModel;

    public AdPanel() {
        adController = new AdController();

        setLayout(new BorderLayout());
        setBackground(new Color(230, 240, 255));

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(4, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        formPanel.setBackground(new Color(230, 240, 255));

        formPanel.add(new JLabel("Title:"));
        titleField = new JTextField();
        formPanel.add(titleField);

        formPanel.add(new JLabel("Description:"));
        descriptionField = new JTextField();
        formPanel.add(descriptionField);

        formPanel.add(new JLabel("Target Audience:"));
        targetAudienceField = new JTextField();
        formPanel.add(targetAudienceField);

        JButton addButton = new JButton("Add Ad");
        addButton.setBackground(new Color(100, 149, 237));
        addButton.setForeground(Color.WHITE);
        addButton.setFocusPainted(false);
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                String description = descriptionField.getText();
                String targetAudience = targetAudienceField.getText();
                adController.createAd(title, description, targetAudience);
                displayAds();
            }
        });
        formPanel.add(addButton);

        add(formPanel, BorderLayout.NORTH);

        tableModel = new DefaultTableModel(new Object[]{"Title", "Description", "Target Audience"}, 0);
        adTable = new JTable(tableModel);
        adTable.setRowHeight(30);
        adTable.setShowGrid(true);
        adTable.setGridColor(Color.GRAY);
        adTable.setFont(new Font("Serif", Font.PLAIN, 18));
        adTable.getTableHeader().setFont(new Font("Serif", Font.BOLD, 18));
        adTable.getTableHeader().setBackground(new Color(100, 149, 237));
        adTable.getTableHeader().setForeground(Color.WHITE);
        add(new JScrollPane(adTable), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(230, 240, 255));
        JButton deleteButton = new JButton("Delete Ad");

        deleteButton.setBackground(new Color(100, 149, 237));
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setFocusPainted(false);
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = adTable.getSelectedRow();
                if (selectedRow != -1) {
                    String title = (String) tableModel.getValueAt(selectedRow, 0);
                    adController.getAds().removeIf(ad -> ad.getTitle().equals(title));
                    tableModel.removeRow(selectedRow);
                }
            }
        });

        buttonPanel.add(deleteButton);
        add(buttonPanel, BorderLayout.SOUTH);

        displayAds();
    }

    private void displayAds() {
        java.util.List<Ad> ads = adController.getAds();
        tableModel.setRowCount(0);
        for (Ad ad : ads) {
            tableModel.addRow(new Object[]{ad.getTitle(), ad.getDescription(), ad.getTargetAudience()});
        }
    }
}
