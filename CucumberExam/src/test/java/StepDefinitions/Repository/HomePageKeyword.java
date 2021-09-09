package StepDefinitions.Repository;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class HomePageKeyword {
    private AppiumDriver<MobileElement> driver;

    public HomePageKeyword(AppiumDriver<MobileElement> driver){
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup")
    private MobileElement homePage;

    @AndroidFindBy(xpath = "//android.support.v7.app.ActionBar.Tab[@content-desc=\"Baby Care\"]")
    private AndroidElement babyCare;

    @AndroidFindBy(xpath = "//android.support.v7.app.ActionBar.Tab[@content-desc=\"Home Care\"]")
    private AndroidElement homeCare;

    @AndroidFindBy(xpath = "//android.support.v7.app.ActionBar.Tab[@content-desc=\"Snacks\"]")
    private AndroidElement snacks;

    @AndroidFindBy(xpath = "//android.support.v7.app.ActionBar.Tab[@content-desc=\"Fruits & Veg\"]")
    private AndroidElement fruitandVeg;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Cart\"]")
    private AndroidElement basketButton;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/*")
    private ArrayList<MobileElement> catagories;

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]")
    private AndroidElement menuButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Search\"]")
    private AndroidElement searchButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup/android.widget.RelativeLayout/android.support.v4.view.ViewPager/android.support.v7.widget.RecyclerView/*")
    private ArrayList<MobileElement> products;

    //return a list with products
    public ArrayList<MobileElement> getProducts() {
        return products;
    }

    //return a list with categories
    public ArrayList<MobileElement> getCatagories() {return catagories; }

    //returns home page element
    public MobileElement getHomePage() {
        return homePage;
    }

    //returns Home Care category element
    public AndroidElement getHomeCare() {
        return homeCare;
    }

    //returns Snacks category element
    public AndroidElement getSnacks() {
        return snacks;
    }

    //returns Baby Care category element
    public AndroidElement getBabyCare() {
        return babyCare;
    }

    //returns Fruit&Veg category element
    public AndroidElement getFruitandVeg() {
        return fruitandVeg;
    }

    //returns true or false aaccording to Home Page is exist or not
    public boolean isDisplayed(){
          return homePage.isDisplayed();
      }

      //clicks Baby Care on the category
      public void clickBabyCare(){ babyCare.click(); }

    //clicks Baby Snacks on the category
    public void clickSnacks(){
        snacks.click();
      }

    //clicks Baby Care on the category
    public void clickBasket(){
        basketButton.click();
      }

    //returns int for the count of element in the category
      public int getcategoriesSize(){
        return catagories.size();
      }

      //clicks Menu button
      public void clickMenu(){
        menuButton.click();
      }

      //clicks the Search button
      public void clickSeachButton(){
        searchButton.click();
      }


}
