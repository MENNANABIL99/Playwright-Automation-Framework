
package tests;

import base.BaseTest;
import pages.LoginPage;
import pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ProductsTest extends BaseTest {

    // Login before testing products
    private ProductsPage loginToProductsPage() {

        LoginPage loginPage = new LoginPage(page);

        loginPage.login("standard_user", "secret_sauce");

        return new ProductsPage(page);
    }

    @Test
    public void verifyProductsPageDisplayed() {

        ProductsPage productsPage = loginToProductsPage();

        Assert.assertEquals(
                productsPage.getPageTitle(),
                "Products"
        );
    }

    @Test
    public void verifyProductsCount() {

        ProductsPage productsPage = loginToProductsPage();
        System.out.println("Products count: " + productsPage.getProductsCount());
        Assert.assertEquals(
                productsPage.getProductsCount(),
                6,
                "Expected 6 products"
        );
    }

    @Test
    public void verifyProductDetails() {

        ProductsPage productsPage = loginToProductsPage();

        productsPage.openFirstProduct();

        Assert.assertEquals(
                productsPage.getProductDetailsName(),
                "Sauce Labs Backpack"
        );
    }

    @Test
    public void verifySortPriceLowToHigh() {

        ProductsPage productsPage = loginToProductsPage();

        productsPage.sortProducts("lohi");

        List<Double> prices = productsPage.getProductPrices();

        for (int i = 0; i < prices.size() - 1; i++) {

            Assert.assertTrue(
                    prices.get(i) <= prices.get(i + 1),
                    "Products are not sorted from low to high"
            );
        }
    }

    @Test
    public void verifySortPriceHighToLow() {

        ProductsPage productsPage = loginToProductsPage();

        productsPage.sortProducts("hilo");

        List<Double> prices = productsPage.getProductPrices();

        for (int i = 0; i < prices.size() - 1; i++) {

            Assert.assertTrue(
                    prices.get(i) >= prices.get(i + 1),
                    "Products are not sorted from high to low"
            );
        }
    }
}
