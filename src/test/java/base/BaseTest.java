
package base;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected Page page;

    @BeforeMethod
    public void setUp() {

        // Initialize Playwright
        playwright = Playwright.create();

        // Launch Chromium browser
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false)
        );

        // Create a new page
        page = browser.newPage();

        // Navigate to SauceDemo
        page.navigate("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void tearDown() {

        if (browser != null) {
            browser.close();
        }

        if (playwright != null) {
            playwright.close();
        }
    }
}

