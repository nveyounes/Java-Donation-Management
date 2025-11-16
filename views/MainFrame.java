package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public MainFrame() {
        setTitle("Donation Management System");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        DonorPanel donorPanel = new DonorPanel();
        DonationPanel donationPanel = new DonationPanel();
        AdPanel adPanel = new AdPanel();

        mainPanel.add(donorPanel, "Donor Management");
        mainPanel.add(donationPanel, "Donation Management");
        mainPanel.add(adPanel, "Ad Management");

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem donorMenuItem = new JMenuItem("Donor Management");
        JMenuItem donationMenuItem = new JMenuItem("Donation Management");
        JMenuItem adMenuItem = new JMenuItem("Ad Management");

        donorMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "Donor Management");
            }
        });

        donationMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "Donation Management");
            }
        });

        adMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "Ad Management");
            }
        });

        menu.add(donorMenuItem);
        menu.add(donationMenuItem);
        menu.add(adMenuItem);
        menuBar.add(menu);

        setJMenuBar(menuBar);
        add(mainPanel);
    }
}
