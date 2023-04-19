package project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class Activity2 {

    WebDriver driver;

    //Create the setup methods
    @BeforeClass
    public void setUp(){
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");

        //set up the Firefox driver
        WebDriverManager.firefoxdriver().setup();

        //Initialize driver object
        driver=new FirefoxDriver();

        //open the browser
        driver.get("https://alchemy.hguy.co/lms");
    }

    //Create the test method
    @Test(priority = 1)
    public void myAccountHeadingTest(){
        //print heading of the page
        String heading = driver.findElement(By.className("uagb-ifb-title")).getText();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        System.out.println(heading);

        //Assertion
        Assert.assertEquals(heading, "Learn from Industry Experts");
    }

    @AfterClass
    public void tearDown(){
        //Close the browser
        driver.quit();
    }
}