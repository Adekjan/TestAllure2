package Sbol.Beeline;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.impl.WebElementSource;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;

//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.DesiredCapabilities;



import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;


public class BeelineTest {


    private Object AndroidDriver;

    @Before
    public void setUp() {

        closeWebDriver();
        Configuration.startMaximized = false;
        Configuration.browserSize = null;
        Configuration.timeout = 15000;
        Configuration.browser = AndroidDriverIn.class.getName();
        open();
    }


    @Test
    public void SBOL() {
        //Заходим в демо режим
        $(By.xpath("//*[@content-desc ='Ещё']")).waitUntil(visible, 10000).click();
        $(By.id("ru.sberbankmobile:id/title")).waitUntil(visible, 10000).click();
        //Нажимаем продолжить в демонстрационном режиме
        $(By.id("android:id/button1")).waitUntil(visible, 10000).click();


/*
        //Swipe bottomTop
        int  startX1 = (int) ($(By.xpath("//android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.view.View[1]")).getSize().getWidth() / 2);
        int  startY1 = (int) ($(By.xpath("//android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.view.View[1]")).getSize().height * 0.50);
        int endY1 = (int) ($(By.xpath("//android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.view.View[1]")).getSize().height * 0.20);


        TouchAction action2 = new TouchAction((PerformsTouchActions) WebDriverRunner.getWebDriver());
        action2.press(PointOption.point( (int) startX1, (int) startY1));
        action2.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)));
        action2.moveTo(PointOption.point((int) startX1, (int) endY1));
        action2.release().perform();
        sleep(5000);

        //Нажимаем на Золото
        $(By.xpath("//*[@text ='Золото']")).waitUntil(visible, 10000).click();


*/

        //нажимаем на карту маестро
        $(By.xpath("//android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]/android.view.View[1]")).waitUntil(visible, 10000).click();
        sleep(3000);
        //Swipe right to left
       int  startY = (int) ($(By.id("ru.sberbankmobile:id/info_recycler_view")).getSize().getHeight() / 5);
       int  startX = (int) ($(By.id("ru.sberbankmobile:id/info_recycler_view")).getSize().width * 0.80);
       int endX = (int) ($(By.id("ru.sberbankmobile:id/info_recycler_view")).getSize().width * 0.20);


        TouchAction action = new TouchAction((PerformsTouchActions) WebDriverRunner.getWebDriver());
        action.press(PointOption.point( (int) startX, (int) startY));
        action.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)));
        action.moveTo(PointOption.point((int) endX, (int) startY));
        action.release().perform();

        sleep(5000);


        //Swipe bottomTop
        int  startZ = (int) ($(By.id("ru.sberbankmobile:id/info_recycler_view")).getSize().width / 2);
        int  startV = (int) ($(By.id("ru.sberbankmobile:id/info_recycler_view")).getSize().height * 0.50);
        int endV = (int) ($(By.id("ru.sberbankmobile:id/info_recycler_view")).getSize().height * 0.20);


        TouchAction action1 = new TouchAction((PerformsTouchActions) WebDriverRunner.getWebDriver());
        action1.press(PointOption.point( (int) startZ, (int) startV));
        action1.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)));
        action1.moveTo(PointOption.point((int) startZ, (int) endV));
        action1.release().perform();

        sleep(5000);

        //Нажимаем на Байкал

       // $(By.xpath("//android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.view.View[1]")).waitUntil(visible, 10000).click();
       // sleep(3000);


            /*WebElement Panel = el;
            Dimension dimension = Panel.getSize();

            int Anchor = Panel.getSize().getHeight()/2;

            Double ScreenWidthStart = dimension.getWidth() * 0.8;
            int scrollStart = ScreenWidthStart.intValue();

            Double ScreenWidthEnd = dimension.getWidth() * 0.2;
            int scrollEnd = ScreenWidthEnd.intValue();

            /*new TouchAction((PerformsTouchActions) driver)
                    .press(PointOption.point(scrollStart, Anchor))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                    .moveTo(PointOption.point(scrollEnd, Anchor))
                    .release().perform();*/



/*
       //Платеж и перевод
        $(By.xpath("//*[@text ='Платеж или перевод']")).waitUntil(visible, 10000).click();
        $(By.xpath("//*[@text ='За рубеж']")).waitUntil(visible, 10000).click();
        $(By.xpath("//*[@text ='По номеру счёта']")).waitUntil(visible, 10000).click();
        $(By.xpath("//*[@text ='Частному лицу']")).waitUntil(visible, 10000).click();
        $(By.xpath("//*[@text ='Германия']")).waitUntil(visible, 10000).click();
        //заполняем данные

        $(By.id("ru.sberbankmobile:id/edit_text_view")).waitUntil(visible, 10000).click();
        $(By.id("ru.sberbankmobile:id/edit_text_view")).waitUntil(visible, 10000).waitUntil(visible, 10000).sendKeys("300");
        sleep(1000);
        $(By.xpath("//*[@text ='РАССЧИТАТЬ КОМИССИЮ']")).waitUntil(visible, 10000).click();
        $(By.xpath("//*[@text ='ПРОДОЛЖИТЬ']")).waitUntil(visible, 10000).click();



        $(By.xpath("//*[@text ='Банк получателя (Bank name)']")).waitUntil(visible, 10000).click();
        $(By.xpath("//*[@text ='Банк получателя (Bank name)']")).waitUntil(visible, 10000).waitUntil(visible, 10000).sendKeys("Bank");

        $(By.xpath("//*[@text ='Номер счета получателя (IBAN)']")).waitUntil(visible, 10000).click();
        $(By.xpath("//*[@text ='Номер счета получателя (IBAN)']")).waitUntil(visible, 10000).waitUntil(visible, 10000).sendKeys("123");


        $(By.xpath("//*[@text ='Имя получателя']")).waitUntil(visible, 10000).click();
        $(By.xpath("//*[@text ='Имя получателя']")).waitUntil(visible, 10000).waitUntil(visible, 10000).sendKeys("Aset");

        $(By.xpath("//*[@text ='Фамилия получателя']")).waitUntil(visible, 10000).click();
        $(By.xpath("//*[@text ='Фамилия получателя']")).waitUntil(visible, 10000).waitUntil(visible, 10000).sendKeys("Li");
        //Нажимаем продолжить
        $(By.id("ru.sberbankmobile:id/main_button")).waitUntil(visible, 10000).click();
        sleep(1000);
        $(By.id("ru.sberbankmobile:id/main_button")).waitUntil(visible, 10000).click();
        $(By.xpath("//*[@text ='Перевод отправлен']")).waitUntil(visible, 10000).shouldBe(visible);*/

    }
}