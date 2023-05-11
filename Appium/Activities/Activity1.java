package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.AfterClass;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity1 {
    AndroidDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public  void setUp() throws MalformedURLException {
        UiAutomator2Options caps = new UiAutomator2Options().
                setPlatformName("android").
                setAutomationName("UiAutomator2").
                setAppPackage("com.vivo.calculator").
                setAppActivity(".Calculator").
                noReset();

        URL serverURL = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(serverURL,caps);
    }

    @Test
    public void addTest(){
        driver.findElement(AppiumBy.id("digit5")).click();
        driver.findElement(AppiumBy.id("plus")).click();
        driver.findElement(AppiumBy.id("digit5")).click();
        driver.findElement(AppiumBy.id("equal")).click();


        String result = driver.findElement(AppiumBy.id("com.vivo.calculator:id/input_edit")).getText();

        Assert.assertEquals(result, "10");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
