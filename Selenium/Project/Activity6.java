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

public class Activity6 {

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
    public void accountLoginTest(){

        //navigate to my account tab
        driver.findElement(By.xpath("//a[@href=\"https://alchemy.hguy.co/lms/my-account/\"]")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //print the page title
        String title = driver.getTitle();
        System.out.println(title);

        //Assertion
        Assert.assertEquals(title, "My Account – Alchemy LMS");

        //log into lms
        driver.findElement(By.xpath("//a[@href=\"#login\"]")).click();
        driver.findElement(By.xpath("//input[@id=\"user_login\"]")).sendKeys("root");
        driver.findElement(By.xpath("//input[@id=\"user_pass\"]")).sendKeys("pa$$w0rd");
        driver.findElement(By.xpath("//input[@id=\"wp-submit\"]")).click();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

        //print the page title
        title = driver.findElement(By.xpath("//h1[contains(text(),\"  My Account    \")]")).getText();
        System.out.println(title);

        //Assertion
        Assert.assertEquals(title, "My Account");
    }

    @AfterClass
    public void tearDown(){
        //Close the browser
        driver.quit();
    }
}