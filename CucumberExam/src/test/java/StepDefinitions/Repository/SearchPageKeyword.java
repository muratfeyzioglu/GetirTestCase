package StepDefinitions.Repository;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class SearchPageKeyword {

    private AppiumDriver<MobileElement> driver;

    public SearchPageKeyword(AppiumDriver<MobileElement> driver){
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.support.v7.widget.LinearLayoutCompat/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText")
    private AndroidElement searchBar;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.TextView")
    private AndroidElement SearchResult;

    //writes text to Search Bar
    public void typeSearchBar(String text){
        searchBar.sendKeys(text);
    }

    //returns true or false according to Search Result element is exist or not
    public boolean searchResultisDisplayed(){
        return SearchResult.isDisplayed();
    }
}


