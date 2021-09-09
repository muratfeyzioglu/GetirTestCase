package StepDefinitions.Repository;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class ProductDetailPageKeyword {
    private AppiumDriver<MobileElement> driver;

    public ProductDetailPageKeyword(AppiumDriver<MobileElement> driver){
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]")
    private AndroidElement addtoCartButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView[2]")
    private AndroidElement productPrice;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView[1]")
    private AndroidElement productName;

    @AndroidFindBy(xpath = "//android.view.ViewGroup/android.widget.RelativeLayout/android.support.v4.view.ViewPager/android.support.v7.widget.RecyclerView/*")
    private ArrayList<MobileElement> products;

    @AndroidFindBy(xpath = "//android.support.v4.view.ViewPager/android.support.v7.widget.RecyclerView/*/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ImageView")
    private ArrayList<MobileElement> heartButtons;

    //returns to list of Hearth Buttons
    public ArrayList<MobileElement> getHeartButtons() {
        return heartButtons;
    }

    //clicks to Add to Cart button on Products Detail Page
    public void clickAddtoCart(){
        addtoCartButton.click();
    }

    //returns to list of Products
    public ArrayList<MobileElement> getProducts() {
        return products;
    }

    //returns the Product Name
    public String getProductName(){
        return productName.getText();
    }

    //returns the Product Price
    public String getProductPrice(){
        return productPrice.getText();
    }





}
