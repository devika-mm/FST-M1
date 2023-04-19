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

public class Activity1 {
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
    public void myAccountTest(){
        //click on my account
        driver.findElement(By.xpath("//a[@href=\'https://alchemy.hguy.co/lms/my-account/\']")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //print page title
        String myAccountTitle=driver.getTitle();
        System.out.println(myAccountTitle);

        //Assertion
        Assert.assertEquals(myAccountTitle, "My Account – Alchemy LMS");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        //Close the browser
        driver.quit();
    }
}