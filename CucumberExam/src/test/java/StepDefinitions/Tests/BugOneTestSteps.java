package StepDefinitions.Tests;

import StepDefinitions.Helper;
import StepDefinitions.Manager.ConnectionManager;
import StepDefinitions.Repository.HomePageKeyword;
import StepDefinitions.Repository.ProductDetailPageKeyword;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class BugOneTestSteps {

    private  AppiumDriver<MobileElement> driver;
    private  ConnectionManager connectionManager;
    private  WebDriverWait wait;
    private  Helper helper;

    private  HomePageKeyword homePageKeywords;
    private  ProductDetailPageKeyword productPageKeyword;




    public MobileElement selectedProduct;

    public BugOneTestSteps() throws MalformedURLException {
        connectionManager = new ConnectionManager();
        driver= connectionManager.GetDriver2();
        wait = new WebDriverWait(driver, 5);
        helper = new Helper();

        homePageKeywords = new HomePageKeyword(driver);
        productPageKeyword = new ProductDetailPageKeyword(driver);
      }

    @Test
    @Given("User should pass onboarding screensf")
    public void user_should_pass_onboarding_screensf() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.allandroidprojects.getirsample:id/btn_next"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.allandroidprojects.getirsample:id/btn_next"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.allandroidprojects.getirsample:id/btn_next"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.allandroidprojects.getirsample:id/btn_next"))).click();

    }

    @Test
    @When("User open a random categoryt")
    public void user_open_a_random_categoryt() {
        helper.selectRandomElement(homePageKeywords.getCatagories()).click();

    }

    @Test
    @When("User adds a random product to wishlist via mini heart icon")
    public void user_adds_a_random_product_to_wishlist_via_mini_heart_icon() {
        selectedProduct = helper.selectRandomElement(productPageKeyword.getHeartButtons());
        selectedProduct.click();
    }

    @Test
    @Then("User checks to mini hearth icon of the product is selected")
    public void user_checks_to_mini_hearth_icon_of_the_product_is_selected() {
        Assert.assertEquals(selectedProduct.isSelected(), true);
    }

}
