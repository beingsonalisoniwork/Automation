# Automation Framework (Selenium + Rest Assured + TestNG)

A unified automation project using **Java**, **TestNG**, **Selenium 4**, **Rest Assured**, and **Maven** for both UI and API testing.

---

## Tech Stack

- Java 17+
- Maven
- Selenium 4 (auto-manages ChromeDriver)
- Rest Assured
- TestNG

---

## Maven Commands

```bash
# Clean and compile the project
mvn clean compile

# Run all tests
mvn test

# Run using specific TestNG suite
mvn test -DsuiteXmlFile=testng.xml

# Run and install dependencies
mvn clean install
