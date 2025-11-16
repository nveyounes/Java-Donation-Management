# 🚀 Gestion des Dons (Java Donation Management)

### 🛡️ Project Status & Context

| Status | Tech Stack | Type | Context |
| :--- | :--- | :--- | :--- |
| **Complete** | Java, Swing, FlatLaf | Desktop Application | **ISGA Academic Project** |

[![GitHub last commit](https://img.shields.io/github/last-commit/nveyounes/java-donation-manager?style=for-the-badge&color=2ecc71)](https://github.com/nveyounes/java-donation-manager)
[![License](https://img.shields.io/github/license/nveyounes/java-donation-manager?style=for-the-badge&color=3498db)](LICENSE)
[![Repo Size](https://img.shields.io/github/repo-size/nveyounes/java-donation-manager?style=for-the-badge&color=9b59b6)](https://github.com/nveyounes/java-donation-manager)

---

## ⭐ Project Goal: Donation Management System

This repository contains a Java application designed to simplify and improve the management of donations, donors, and advertisements for a non-profit association.

Built as an academic project for ISGA, its primary goal is to demonstrate a clean **Model-View-Controller (MVC)** architecture in Java, combined with a modern user interface.

### 📌 Key Features
* **Ad Management:** Create, view, and manage promotional ads to attract donors.
* **Donor Management:** Register, update, and consult donor information.
* **Donation Management:** Track and manage all received donations for complete traceability.
* **Modern UI:** Implements the `FlatLaf` library to create an elegant and intuitive user experience, a significant improvement over standard Java Swing.

---

## 🛠️ Technology Stack

This application was built using a pure Java stack, focusing on desktop UI and a clean separation of concerns.

| Category | Technology | Purpose | Icon |
| :--- | :--- | :--- | :--- |
| **Language** | Java | Primary programming language for all logic. | ![Java](https://img.shields.io/badge/Java-EA4C36?style=flat-square&logo=java&logoColor=white) |
| **UI Framework** | Java Swing | Standard library for building the core GUI components. | ![Java Swing](https://img.shields.io/badge/Java_Swing-F89820?style=flat-square&logo=java&logoColor=white) |
| **UI Theme** | FlatLaf | A modern, lightweight look-and-feel library for Swing. | ![FlatLaf](https.img.shields.io/badge/FlatLaf-454545?style=flat-square) |
| **Architecture** | MVC Pattern | Used to separate business logic, data, and presentation. | ![MVC](https://img.shields.io/badge/Architecture-MVC-blue?style=flat-square) |

---

## 📂 Architecture & Data

### 1. Architecture: Model-View-Controller (MVC)
The project strictly follows the MVC pattern to ensure a clean separation of concerns, making the application maintainable and scalable.

* **Models:** Represents the data entities (`Ad`, `Donation`, `Donor`).
* **Views:** The UI components (`MainFrame`, `AdPanel`, `DonorPanel`) that the user interacts with.
* **Controllers:** The logic that handles user input and mediates between the Models and Views.

This structure is clearly reflected in the project's `src` directory:
```
src
├── App.java                 # Main application entry point
├── controllers
│   ├── AdController.java        # Handles ad logic
│   ├── DonationController.java  # Handles donation logic
│   └── DonorController.java     # Handles donor logic
├── models
│   ├── Ad.java
│   ├── Donation.java
│   └── Donor.java
└── views
    ├── AdPanel.java
    ├── DonationPanel.java
    ├── DonorPanel.java
    └── MainFrame.java         # The main application window
```

### 2. Data Model (In-Memory)
This project **does not use an external database**. All data (ads, donors, donations) is managed **in-memory** using `java.util.ArrayList` within each controller.

This means all data is **lost when the application is closed**. The focus of the project was on the application's architecture rather than data persistence.

---

## 📸 Screenshots

*(This is a perfect place to add screenshots of your running application!)*

| Main Interface (MainFrame) | Ad Management (AdPanel) | Donor Management (DonorPanel) |
| :---: | :---: | :---: |
|  |  |  |

---

## 🚀 Getting Started

### Prerequisites
* [Java Development Kit (JDK) 11 or newer](https://www.oracle.com/java/technologies/downloads/)
* An IDE like [IntelliJ IDEA](https://www.jetbrains.com/idea/) or [Eclipse](https://www.eclipse.org/downloads/)

### Installation & Usage

1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/nveyounes/java-donation-manager.git](https://github.com/nveyounes/java-donation-manager.git)
    ```
2.  **Navigate to the project directory:**
    ```bash
    cd java-donation-manager
    ```
3.  **Run the application from your IDE:**
    * Open the project folder in IntelliJ or Eclipse.
    * Locate the `App.java` file in the `src` directory.
    * Right-click and select **"Run App.main()"** to launch the application.

---

## L 👥 Authors & Acknowledgements

This was an academic project for **ISGA (EDVANTIS Higher Education Group)**.

* **Farhat**
* **Bellamine**

### Supervised By:
* **Mme. SBAI**
