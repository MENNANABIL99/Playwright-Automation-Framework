
package pages;

import com.microsoft.playwright.Page;

public class LoginPage {

    private final Page page;

    // Locators
    private final String usernameInput = "#user-name";
    private final String passwordInput = "#password";
    private final String loginButton = "#login-button";
    private final String errorMessage = "[data-test='error']";

    // Constructor
    public LoginPage(Page page) {
        this.page = page;
    }

    // Enter Username
    public void enterUsername(String username) {
        page.locator(usernameInput).fill(username);
    }

    // Enter Password
    public void enterPassword(String password) {
        page.locator(passwordInput).fill(password);
    }

    // Click Login
    public void clickLogin() {
        page.locator(loginButton).click();
    }

    // Login Action
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    // Get Error Message
    public String getErrorMessage() {
        return page.locator(errorMessage).textContent().trim();
    }

    // Check Error Visibility
    public boolean isErrorDisplayed() {
        return page.locator(errorMessage).isVisible();
    }
}

