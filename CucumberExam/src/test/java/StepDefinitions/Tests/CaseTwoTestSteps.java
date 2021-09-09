package StepDefinitions.Tests;

import StepDefinitions.Helper;
import StepDefinitions.Manager.ConnectionManager;
import StepDefinitions.Repository.*;
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

public class CaseTwoTestSteps {

    private AppiumDriver<MobileElement> driver;
    private ConnectionManager connectionManager;
    private Helper helper;
    private WebDriverWait wait;

    private HomePageKeyword homePageKeywords;
    private ProductDetailPageKeyword productPageKeyword;
    private MenuPageKeyword menuPageKeyword;
    private WhislistKeyword whislistKeyword;

    public CaseTwoTestSteps() throws MalformedURLException {
        connectionManager = new ConnectionManager();
        driver= connectionManager.GetDriver2();
        wait = new WebDriverWait(driver, 5);
        helper = new Helper();

        homePageKeywords = new HomePageKeyword(driver);
        productPageKeyword = new ProductDetailPageKeyword(driver);
        menuPageKeyword = new MenuPageKeyword(driver);
        whislistKeyword = new WhislistKeyword(driver);

    }

    @Test
    @Given("User should pass onboarding screensd")
    public void user_should_pass_onboarding_screensd() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.allandroidprojects.getirsample:id/btn_next"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.allandroidprojects.getirsample:id/btn_next"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.allandroidprojects.getirsample:id/btn_next"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.allandroidprojects.getirsample:id/btn_next"))).click();
    }

    @Test
    @Then("User checks if home page exists or notd")
    public void user_checks_if_home_page_exists_or_notd() {
        Assert.assertEquals(homePageKeywords.isDisplayed(), true);
    }

    @Test
    @When("User gets the number of categories and  write this number to console")
    public void user_Gets_The_NumberOfCategoriesAndWriteThisNumberToConsole() {
        System.out.println(homePageKeywords.getcategoriesSize());
    }

    @Test
    @When("User open a random category")
    public void user_open_a_random_category() {
        helper.selectRandomElement(homePageKeywords.getCatagories()).click();
    }

    @Test
    @And("User adds three random products to wishlist via mini heart icon")
    public void userAddsThreeRandomProductsToWishlistViaMiniHeartIcon() {
        helper.selectRandomElement(productPageKeyword.getHeartButtons()).click();
        helper.selectRandomElement(productPageKeyword.getHeartButtons()).click();
        helper.selectRandomElement(productPageKeyword.getHeartButtons()).click();
    }

    @Test
    @When("User opens the menu in the left")
    public void user_opens_the_menu_in_the_left() {
        homePageKeywords.clickMenu();
    }

    @Test
    @When("User go to ‘My Wishlist’")
    public void user_go_to_my_wishlist() {
       menuPageKeyword.clickWhisList();
    }

    @Test
    @Then("User controls the page and products")
    public void user_controls_the_page_and_products() {
        Assert.assertEquals(whislistKeyword.whislistPageisDisplayed(), true);
        Assert.assertEquals(whislistKeyword.getCountWhislistProductSize(), 3);
    }

    @Test
    @When("User deletes all of them from Wishlist")
    public void user_deletes_all_of_them_from_wishlist() {
        for(int i = 0; i <=whislistKeyword.getCountWhislistProductSize(); i ++){
            whislistKeyword.clickRemoveButton();
        }
    }
}
