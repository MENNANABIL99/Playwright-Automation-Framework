# Playwright Automation Framework

UI test automation in Java with Playwright and TestNG, using the Page Object Model. It tests the [SauceDemo](https://www.saucedemo.com) demo store.

## Tech stack
Java 24 | Playwright for Java 1.64.0 | TestNG 7.12.0 | Maven

## Structure
```
src/test/java
  base/BaseTest.java       shared setup and teardown
  pages/LoginPage.java     login page object
  pages/ProductsPage.java  products page object
  tests/LoginTest.java     login tests
  tests/ProductsTest.java  products page tests
```

## Scenarios covered
**Login (4 tests):** valid login, invalid credentials, empty username, empty password (checks the error messages)

**Products page (5 tests):** page is displayed, product count is 6, first product details open, price sort low to high, price sort high to low

## Run the tests
Requirements: JDK 24 (set in `pom.xml`) and Maven.
```
git clone https://github.com/MENNANABIL99/Playwright-Automation-Framework.git
cd Playwright-Automation-Framework
mvn test
```

## Notes
The demo credentials used are the public ones published by SauceDemo.
