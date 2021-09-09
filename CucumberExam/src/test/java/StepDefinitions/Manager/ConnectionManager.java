package StepDefinitions.Manager;

import StepDefinitions.Tests.CaseOneTestSteps;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static io.appium.java_client.touch.WaitOptions.waitOptions;

public class ConnectionManager {
    //keeps URL
    URL url;

    //Capabilities for first device
    public DesiredCapabilities getCapabilities(String deviceName, String port, String emulatorName){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability(MobileCapabilityType.UDID, emulatorName);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.VERSION, "8.1");
        capabilities.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, port);
        capabilities.setCapability(MobileCapabilityType.APP,
                "C:\\Users\\feyziomu\\IdeaProjects\\CucumberExam\\src\\test\\resources\\features\\Apps\\sampleGetir.apk");
        return  capabilities;
    };


    //driver for first device
    public AppiumDriver<MobileElement> GetDriver() throws MalformedURLException {
        AppiumDriver<MobileElement> driver = new AppiumDriver<MobileElement>(UrlCreator(),
                getCapabilities("Galaxy Nexus API 27 1", "9538", "emulator-5554"));
        return  driver;
    }

    //device for second device
    public AppiumDriver<MobileElement> GetDriver2() throws MalformedURLException {
        AppiumDriver<MobileElement> driver = new AppiumDriver<MobileElement>(UrlCreator(),
                getCapabilities("Galaxy Nexus API 27 2", "6789", "emulator-5556"));
        return  driver;
    }

    //create URL for driver
    private URL UrlCreator() {
        try {
            return url = new URL("http://localhost:4723/wd/hub");
        } catch (MalformedURLException e) {
            return url = null;
        }
    }
}
