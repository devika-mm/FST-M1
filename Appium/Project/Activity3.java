package liveProject;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import static example.W3CActionsBase.doSwipe;

public class Activity3 {
    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options caps = new UiAutomator2Options().
                setPlatformName("android").
                setAutomationName("UiAutomator2").
                setAppPackage("com.android.chrome").
                setAppActivity("com.google.android.apps.chrome.Main").noReset();

        URL serverURL = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(serverURL, caps);

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.training-support.net/selenium");
    }
@Test
    public void webAppTest() throws InterruptedException {
        Dimension dims = driver.manage().window().getSize();

        wait.until(ExpectedConditions.presenceOfElementLocated(
            (AppiumBy.xpath("//android.view.View"))));

        Point start = new Point((int) (dims.width*0.5), (int) (dims.height*0.9));
        Point end = new Point((int) (dims.width*0.5), (int) (dims.height*0.2));

        doSwipe(driver,start,end,100);

        wait.until(ExpectedConditions.elementToBeClickable
                (AppiumBy.xpath("//android.widget.TextView[contains(@text,'To-Do List')]"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[contains(@text,'Add Task')]")));

        WebElement taskInput = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='taskInput']"));
        WebElement addTask = driver.findElement(AppiumBy.xpath("//android.widget.Button[contains(@text,'Add Task')]"));

        taskInput.sendKeys("Task 1");
        addTask.click();
        Thread.sleep(1000);

        taskInput.sendKeys("Task 2");
        addTask.click();
        Thread.sleep(1000);

        taskInput.sendKeys("Task 3");
        addTask.click();
        Thread.sleep(1000);

        List<WebElement> list = driver.findElements(AppiumBy.xpath("//android.view.View[@resource-id='tasksList']/android.view.View"));
         Assert.assertEquals(list.size()-1,3);

         for(int i=1;i<= list.size()-1;i++) {
             list.get(i).click();
         }

         driver.findElement(AppiumBy.xpath("//android.widget.TextView[contains(@text,'Clear List')]")).click();

         list = driver.findElements(AppiumBy.xpath("//android.view.View[@resource-id='tasksList']/android.view.View"));
         Assert.assertEquals(list.size(),0);
    }

    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}
