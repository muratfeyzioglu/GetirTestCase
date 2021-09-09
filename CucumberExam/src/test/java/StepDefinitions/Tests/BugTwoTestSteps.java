package StepDefinitions.Tests;

import StepDefinitions.Helper;
import StepDefinitions.Manager.ConnectionManager;
import StepDefinitions.Repository.HomePageKeyword;
import StepDefinitions.Repository.ProductDetailPageKeyword;
import StepDefinitions.Repository.SearchPageKeyword;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class BugTwoTestSteps {

    private AppiumDriver<MobileElement> driver;
    private ConnectionManager connectionManager;
    private WebDriverWait wait;
    public Helper helper;

    private HomePageKeyword homePageKeywords;
    private ProductDetailPageKeyword productPageKeyword;
    private SearchPageKeyword searchPageKeyword;

    public BugTwoTestSteps() throws MalformedURLException {
        connectionManager = new ConnectionManager();
        driver= connectionManager.GetDriver2();
        wait = new WebDriverWait(driver, 5);
        helper = new Helper();

        homePageKeywords = new HomePageKeyword(driver);
        productPageKeyword = new ProductDetailPageKeyword(driver);
        searchPageKeyword = new SearchPageKeyword(driver);
    }

    @Test
    @Given("User should pass onboarding screensg")
    public void user_should_pass_onboarding_screensg() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.allandroidprojects.getirsample:id/btn_next"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.allandroidprojects.getirsample:id/btn_next"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.allandroidprojects.getirsample:id/btn_next"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.allandroidprojects.getirsample:id/btn_next"))).click();
    }

    @Test
    @When("User goes to searh page")
    public void user_goes_to_searh_page() {
        homePageKeywords.clickSeachButton();
    }

    @Test
    @When("User write {string} to searh bar")
    public void user_write_to_searh_bar(String string) {
        searchPageKeyword.typeSearchBar("Sample");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER);
    }

    @Test
    @Then("User checks to any product recievied")
    public void user_checks_to_any_product_recievied() {
        Assert.assertEquals(searchPageKeyword.searchResultisDisplayed(), false);
    }
}
