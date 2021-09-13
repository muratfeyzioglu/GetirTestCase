package StepDefinitions.Tests;

import StepDefinitions.Helper;
import StepDefinitions.Manager.ConnectionManager;
import StepDefinitions.Repository.CartPageKeyword;
import StepDefinitions.Repository.HomePageKeyword;
import StepDefinitions.Repository.ProductDetailPageKeyword;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.net.MalformedURLException;


public class CaseOneTestSteps {

    public ConnectionManager connectionManager;
    public AppiumDriver<MobileElement> driver;
    public WebDriverWait wait;
    public Helper helper;

    private HomePageKeyword homePageKeywords;
    private ProductDetailPageKeyword productPageKeyword;
    private CartPageKeyword cartPageKeyword;

    //keeps product name and prices when test process
    public String productName1;
    public String productPrice1;
    public String productName2;
    public String productPrice2;

    public CaseOneTestSteps() throws MalformedURLException {
        connectionManager = new ConnectionManager();
        driver = connectionManager.GetDriver();
        wait = new WebDriverWait(driver, 5);
        helper = new Helper();

        homePageKeywords = new HomePageKeyword(driver);
        productPageKeyword = new ProductDetailPageKeyword(driver);
        cartPageKeyword = new CartPageKeyword(driver);
    }

    @Test
    @Given("User should pass onboarding screens")
    public void user_should_pass_onboarding_screens(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.allandroidprojects.getirsample:id/btn_next"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.allandroidprojects.getirsample:id/btn_next"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.allandroidprojects.getirsample:id/btn_next"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.allandroidprojects.getirsample:id/btn_next"))).click();
    }

    @Test
    @Then("User checks if home page exists or not")
    public void user_checks_if_home_page_exists_or_not() {
        Assert.assertEquals(homePageKeywords.isDisplayed(), true);
    }

    @Test
    @When("User changes category to ‘Baby Care’")
    public void user_changes_category_to_baby_care() throws MalformedURLException {
        helper.swipeByElements(homePageKeywords.getHomeCare(), homePageKeywords.getSnacks(), driver);
        homePageKeywords.clickBabyCare();
    }

    @Test
    @When("User open a random product detailb")
    public void user_open_a_random_product_detailb() {
        helper.selectRandomElement(homePageKeywords.getProducts()).click();
    }

    @Test
    @Then("User adds this product to basket")
    public void user_adds_this_product_to_basket() {
        productName1 = productPageKeyword.getProductName();
        productPrice1 = productPageKeyword.getProductPrice();
        productPageKeyword.clickAddtoCart();
    }

    @Test
    @Then("Return last page")
    public void return_last_page() {
        driver.navigate().back();
    }

    @Test
    @When("User changes category to ‘Snacks’")
    public void user_changes_category_to_snacks() throws MalformedURLException {
        helper.swipeByElements(homePageKeywords.getHomeCare(), homePageKeywords.getFruitandVeg(), driver);
        homePageKeywords.clickSnacks();
    }

    @Test
    @When("User open a random product detail")
    public void user_open_a_random_product_detail() {
        helper.selectRandomElement(productPageKeyword.getProducts()).click();
    }

    @Test
    @Then("User adds this product to basketb")
    public void userAddsThisProductToBasketb() {
        productName2 = productPageKeyword.getProductName();
        productPrice2 = productPageKeyword.getProductPrice();
        productPageKeyword.clickAddtoCart();
    }

    @Test
    @And("Return last pageb")
    public void returnLastPageb() {
        driver.navigate().back();
    }

    @Test
    @When("User goes to basket")
    public void user_goes_to_basket() {
        homePageKeywords.clickBasket();
    }

    @Test
    @When("Control added products and prices")
    public void control_added_products_and_prices() {
        Assert.assertEquals(cartPageKeyword.getProductsCount(), 2);
        Assert.assertEquals(cartPageKeyword.getCartProductName1(), productName1);
        Assert.assertEquals(cartPageKeyword.getCartProductPrice1(), productPrice1);
        Assert.assertEquals(cartPageKeyword.getCartProductName2(), productName2);
        Assert.assertEquals(cartPageKeyword.getCartProductPrice2(), productPrice2);
        Assert.assertEquals(cartPageKeyword.getTotalPrice(), "$3.96");



    }
    @Test
    @When("User should deletes all products from basket")
    public void user_should_deletes_all_products_from_basket() throws InterruptedException {
        for (int i = 0; i <= cartPageKeyword.getProductsCount(); i++){
            System.out.println(cartPageKeyword.getProductsCount());
            cartPageKeyword.clickremoveButton();
            Thread.sleep(1000);
        }


    }



}