package StepDefinitions.Repository;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class WhislistKeyword {

    private AppiumDriver<MobileElement> driver;

    public WhislistKeyword(AppiumDriver<MobileElement> driver){
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]")
    private AndroidElement whisListPage;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.support.v7.widget.RecyclerView/*")
    private ArrayList<MobileElement> whislistProducts;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.ImageView[2]")
    private AndroidElement removeButton;

    //returns true or false according to Whislist PAge is exist or not
    public boolean whislistPageisDisplayed(){
        return whisListPage.isDisplayed();
    }

    //returns product size of the whislist
    public int getCountWhislistProductSize(){
        return whislistProducts.size();
    }

    //clicks Remove Button
    public void clickRemoveButton(){
        removeButton.click();
    }



}
