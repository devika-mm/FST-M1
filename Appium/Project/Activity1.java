package liveProject;

import com.beust.ah.A;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.AfterClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Activity1 {
    AndroidDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public  void setUp() throws MalformedURLException {
        UiAutomator2Options caps = new UiAutomator2Options().
                setPlatformName("android").
                setAutomationName("UiAutomator2").
                setAppPackage("com.google.android.apps.tasks").
                setAppActivity(".ui.TaskListsActivity").
                noReset();

        URL serverURL = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(serverURL,caps);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void addTest(){
        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='New task']")).sendKeys("Complete Activity with Google Tasks");
        driver.findElement(AppiumBy.id("add_task_done")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(
                AppiumBy.accessibilityId("Create new task")
        ));
        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(
                AppiumBy.xpath("//android.widget.EditText[@text='New task']")
        ));
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='New task']")).sendKeys("Complete Activity with Google Keep");
        driver.findElement(AppiumBy.id("add_task_done")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(
                AppiumBy.accessibilityId("Create new task")
        ));
        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(
                AppiumBy.xpath("//android.widget.EditText[@text='New task']")
        ));
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='New task']")).sendKeys("Complete the second Activity Google Keep");
        driver.findElement(AppiumBy.id("add_task_done")).click();

        List<WebElement> tasks = driver.findElements(AppiumBy.xpath("//android.support.v7.widget.RecyclerView[@resource-id='com.google.android.apps.tasks:id/tasks_list']/android.widget.FrameLayout"));
        Assert.assertEquals(tasks.size(), 3);


    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
