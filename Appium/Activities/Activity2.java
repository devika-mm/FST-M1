package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Activity2 {
    AndroidDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public  void setUp() throws MalformedURLException {
        UiAutomator2Options caps = new UiAutomator2Options().
                setPlatformName("android").
                setAutomationName("UiAutomator2").
                setAppPackage("com.android.chrome").
                setAppActivity("com.google.android.apps.chrome.Main").noReset();

        URL serverURL = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(serverURL,caps);

        wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        driver.get("https://www.training-support.net/");
    }

    @Test
    public void chromeTest(){

        String pageHeading = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Training Support']")).getText();
        System.out.println(pageHeading);

        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='About Us']")).click();

        String aboutPageHeading = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='About Us']")).getText();
        System.out.println(aboutPageHeading);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
