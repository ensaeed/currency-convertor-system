# 💱 Currency Converter Test Automation Framework

## 📌 Overview

This project is a **test automation framework** built using:

* Java
* Cucumber (BDD)
* Playwright
* Maven

It validates **currency conversion functionality** using both:

* UI automation (XE website)
* API validation (exchange rates)
* Data-driven testing (JSON input)

---

## 🚀 Key Features

* ✅ BDD framework using Cucumber
* ✅ UI automation with Playwright
* ✅ API integration for real-time exchange rates
* ✅ Data-driven testing using JSON
* ✅ Validation with tolerance handling
* ✅ Modular and reusable architecture
* ✅ HTML test reporting

---

## 🏗️ Project Structure

```
src
 └── test
     ├── java
     │    ├── models              # Test data models (POJOs)
     │    ├── pages               # Page Object Model (UI interactions)
     │    ├── runners             # Test runner (Cucumber execution)
     │    ├── steps               # Step definitions
     │    └── utils               # Utilities (API client, validation, JSON reader)
     │
     └── resources
          ├── features            # Cucumber feature files
          └── testdata           # JSON test data
```

---

## ⚙️ How It Works

1. Test data is read from JSON files
2. Cucumber feature files define scenarios
3. Step definitions execute:

    * UI actions via Playwright
    * API calls for exchange rates
4. Validation is performed with tolerance checks
5. Results are generated as HTML reports

---

## ▶️ How to Run Tests

### Run via Maven

```bash
mvn clean test
```

---

### Run via IntelliJ

* Open `TestRunner.java`
* Click ▶ Run

---

## 📊 Test Report

After execution, open:

```
target/cucumber-reports/cucumber-report.html
```

👉 Open in browser to view results

---

## 📂 Test Data Example

```json
[
  {
    "fromCurrency": "USD",
    "toCurrency": "EUR",
    "amount": 100,
    "expectedRate": 0.92
  }
]
```

---

## 🧪 Validation Logic

* Expected value = `amount × exchange rate`
* Compared with UI result
* Tolerance applied (±1%)

---

## 🛠️ Technologies Used

* Java
* Cucumber
* Playwright
* Maven
* Jackson (JSON parsing)

---

## 🎯 Design Principles

* Single Responsibility Principle
* Separation of Concerns
* Data-driven testing
* Reusable components
* Clean architecture

---

## 📈 Future Improvements

* Allure reporting integration
* CI/CD pipeline (GitHub Actions / Jenkins)
* Parallel test execution
* Multi-browser support

---

## 👤 Author

**Ehsun Saeed**
Test Automation Engineer

---
