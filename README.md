# NoBroker Automation Framework – Selenium (POM + PageFactory)

## 📌 Project Overview

This project automates key functionalities of the **NoBroker website** using **Selenium WebDriver** with **Java**.

The automation simulates a user searching for rental or sale properties, viewing property details, and contacting property owners. The framework is designed using **Page Object Model (POM)** with **Page Factory**, making test scripts maintainable, reusable, and scalable.

---

## 🎯 Use Case

A user performs the following actions:

1. Navigate to the NoBroker homepage.
2. Search for properties.
3. View search results.
4. Select a property from the results.
5. Contact the property owner.
6. Validate that property details are displayed correctly.

Automation verifies these elements:

- Property Title / Name  
- Price / Rent  
- Owner / Agent Information  
- Property Description  
- Property Images  

---

## 🧰 Tools & Technologies Used

| Tool / Technology | Purpose |
|------------------|---------|
| Selenium WebDriver | Browser automation |
| Java (JDK 21) | Programming language |
| TestNG | Test execution framework |
| Maven | Dependency management & build |
| Page Object Model (POM) | Design pattern for maintainable code |
| Page Factory | Web element initialization |
| Extent Reports | HTML test reporting |
| Allure Reports | Interactive reporting |
| Git | Version control |
| Eclipse | IDE for development |


---

## 🏗 Framework Design

The framework follows a layered architecture:


- **Test Layer** – Contains TestNG test classes (e.g., `ContactOwnerTest.java`)  
- **Page Layer** – Contains Page Object classes (e.g., `HomePage.java`, `propertiesPage.java`)  
- **Utilities** – Helper classes for Base setup, Excel reading, Extent reporting, and property reading  
- **WebDriver** – Selenium WebDriver instance initialization and management  

---

## 📁 Project Structure


<img width="353" height="757" alt="Screenshot 2026-03-12 175030" src="https://github.com/user-attachments/assets/fff18a97-efd4-4a9d-98a6-1cabadaca46b" />



---

## 🧪 Test Scenarios

| Test Case ID | Scenario | Expected Result |
|--------------|---------|----------------|
| TC_01 | Open NoBroker homepage | Page loads successfully |
| TC_02 | Search for property | Search results appear |
| TC_03 | Select property | Property details page opens |
| TC_04 | Contact property owner | Contact form or owner info displayed |
| TC_05 | Validate property details | Title, Price, Description, Images visible |

---

## ⚙ Key Features

- ✔ Page Object Model (POM) implementation  
- ✔ Page Factory for web element initialization  
- ✔ Excel-driven test data using `ExcelReader.java`  
- ✔ Screenshot capture for verification  
- ✔ Extent Report and Allure Report integration  
- ✔ Logger support for execution tracking  
- ✔ Maven dependency management  
- ✔ Git version control  

---

## ⚠ Automation Challenges Handled

- Dynamic property search result loading  
- Infinite scroll on listings page  
- Delayed property image loading  
- Popup handling for location and notifications  
- Excel-driven input data management  

---

## 📸 Screenshots

Screenshots of property details pages are automatically captured during execution and stored in the **reports/** folder.

---

## 📊 Reports

- **Extent Reports** – Detailed HTML reports.  
- **Allure Reports** – Interactive reports with test execution steps.

---
