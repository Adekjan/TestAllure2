package Sbol.Beeline;



import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
//import org.slf4j.Assert;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;

import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_ACTIVITY;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_PACKAGE;

/*public class SwipeTest {
    public static AppiumDriver<WebElement> driver;
    public static DesiredCapabilities cap;
    public static void main(String[] args) {
        cap = new DesiredCapabilities();
        cap.setCapability("Plat");
    }
};*/

    public class AndroidDriverIn implements WebDriverProvider {
        public static AppiumDriver<WebElement> driver;
        @Override
        public WebDriver createDriver(DesiredCapabilities capabilities) {
            capabilities.setCapability(MobileCapabilityType.VERSION, "10.0");
            capabilities.setCapability("automationName", "Appium");
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("deviceName", "Samsung Galaxy S10");
            capabilities.setCapability(APP_PACKAGE, "ru.sberbankmobile");
            capabilities.setCapability(APP_ACTIVITY, "ru.sberbankmobile.SplashActivity");
            capabilities.setCapability("fullReset", "false");
            capabilities.setCapability("noReset", "true");
            capabilities.setCapability("newCommandTimeout","300");




            try {
                return new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }



    }


