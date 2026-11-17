
package tests;

import base.BaseTest;
import pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testSuccessfulLogin() {

        LoginPage loginPage = new LoginPage(page);

        loginPage.login("standard_user", "secret_sauce");

        Assert.assertEquals(
                page.locator(".title").textContent(),
                "Products",
                "Products page was not displayed"
        );
    }

    @Test
    public void testInvalidLogin() {

        LoginPage loginPage = new LoginPage(page);

        loginPage.login("wrong_user", "wrong_password");

        Assert.assertTrue(loginPage.isErrorDisplayed());

        Assert.assertEquals(
                loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service"
        );
    }

    @Test
    public void testEmptyUsername() {

        LoginPage loginPage = new LoginPage(page);

        loginPage.login("", "secret_sauce");

        Assert.assertEquals(
                loginPage.getErrorMessage(),
                "Epic sadface: Username is required"
        );
    }

    @Test
    public void testEmptyPassword() {

        LoginPage loginPage = new LoginPage(page);

        loginPage.login("standard_user", "");

        Assert.assertEquals(
                loginPage.getErrorMessage(),
                "Epic sadface: Password is required"
        );
    }
}
