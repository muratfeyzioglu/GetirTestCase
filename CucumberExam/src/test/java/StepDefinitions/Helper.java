package StepDefinitions;

import StepDefinitions.Tests.CaseOneTestSteps;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static io.appium.java_client.touch.WaitOptions.waitOptions;

public class Helper {

    //Swipe by elements, swipe location is from startElement to endElement
    public void swipeByElements(MobileElement startElement, MobileElement endElement, AppiumDriver<MobileElement> driver) throws MalformedURLException {
        int startX = startElement.getLocation().getX() + (startElement.getSize().getWidth() / 2);
        int startY = startElement.getLocation().getY() + (startElement.getSize().getHeight() / 2);
        int endX = endElement.getLocation().getX() + (endElement.getSize().getWidth() / 2);
        int endY = endElement.getLocation().getY() + (endElement.getSize().getHeight() / 2);
        new TouchAction(driver)
                .press(PointOption.point(startX,startY))
                .waitAction(waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endX, endY))
                .release().perform();
    }

    //select random element with a MobileElement list
    public MobileElement selectRandomElement(ArrayList<MobileElement> list){
        Random rand = new Random();
        int randomProduct = rand.nextInt(list.size() );

        System.out.println("Selected random product number= " + randomProduct);
        System.out.println("Total Product = " + list.size());
        return list.get(randomProduct);
    }
}
