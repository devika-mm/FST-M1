package project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class Activity8 {

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
    public void contactPageTest(){
        //click on contact tab
        driver.findElement(By.xpath("//a[@href=\"https://alchemy.hguy.co/lms/contact/\"]")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //fill fields with values
        driver.findElement(By.xpath("//input[@id=\"wpforms-8-field_0\"]")).sendKeys("Test");
        driver.findElement(By.xpath("//input[@id=\"wpforms-8-field_1\"]")).sendKeys("Test@gmail.com");
        driver.findElement(By.xpath("//input[@id=\"wpforms-8-field_3\"]")).sendKeys("Test");
        driver.findElement(By.xpath("//textarea[@id=\"wpforms-8-field_2\"]")).sendKeys("Testing contact form");
        driver.findElement(By.id("wpforms-submit-8")).click();

        //print confirmation message to console
        String message = driver.findElement(By.xpath("//div[@id=\"wpforms-confirmation-8\"]/p")).getText();
        System.out.println(message);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        //Close the browser
        driver.quit();
    }
}