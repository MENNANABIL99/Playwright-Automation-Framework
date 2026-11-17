
package pages;

import com.microsoft.playwright.Page;
import java.util.ArrayList;
import java.util.List;

public class ProductsPage {

    private final Page page;

    // Locators
    private final String pageTitle = ".title";
    private final String products = ".inventory_item";
    private final String productNames = ".inventory_item_name";
    private final String productPrices = ".inventory_item_price";
    private final String sortDropdown = ".product_sort_container";

    // Constructor
    public ProductsPage(Page page) {
        this.page = page;
    }

    // Get Page Title
    public String getPageTitle() {
        return page.locator(pageTitle).textContent().trim();
    }

    // Get Products Count
    public int getProductsCount() {
        return page.locator(products).count();
    }

    // Open First Product Details
    public void openFirstProduct() {
        page.locator(productNames).first().click();
    }

    // Get Product Details Name
    public String getProductDetailsName() {
        return page.locator(".inventory_details_name")
                .textContent().trim();
    }

    // Sort Products
    public void sortProducts(String option) {
        page.locator(sortDropdown).selectOption(option);
    }

    // Get Product Prices
    public List<Double> getProductPrices() {

        List<String> prices = page.locator(productPrices)
                .allTextContents();

        List<Double> numericPrices = new ArrayList<>();

        for (String price : prices) {
            numericPrices.add(
                    Double.parseDouble(price.replace("$", ""))
            );
        }

        return numericPrices;
    }
}

