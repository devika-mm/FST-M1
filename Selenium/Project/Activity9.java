package project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.util.concurrent.TimeUnit;

public class Activity9 {

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
    public void courseCompletionTest(){
        //click on all course tab
        driver.findElement(By.xpath("//a[@href=\"https://alchemy.hguy.co/lms/all-courses/\"]")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //get list of course
        driver.findElement(By.xpath("//p[@class=\"ld_course_grid_button\"]/a[@href=\"https://alchemy.hguy.co/lms/courses/social-media-marketing/\"]")).click();
        driver.findElement(By.xpath("//a[@class=\"ld-button\"]")).click();

        //log into lms
        driver.findElement(By.xpath("//input[@id=\"user_login\"]")).sendKeys("root");
        driver.findElement(By.xpath("//input[@id=\"user_pass\"]")).sendKeys("pa$$w0rd");
        driver.findElement(By.xpath("//input[@id=\"wp-submit\"]")).click();

        //navigate to Developing Strategy page and complete
        driver.findElement(By.xpath("//div[contains(text(),\"Developing Strategy\")]")).click();

        //Verifying title of page
        String title = driver.getTitle();
        Assertions.assertEquals(title,"Developing Strategy – Alchemy LMS");

        int i = driver.findElements(By.xpath("//div[@class=\"ld-table-list-item\"]")).size();
        driver.findElement(By.xpath("//a[@href=\"https://alchemy.hguy.co/lms/topic/this-is-the-first-topic/\"]/span[@class=\"ld-topic-title\"]")).click();
        while(i>0) {
            checkMarkComplete(driver.findElements(By.xpath("//input[@value=\"Mark Complete\"]")).size() > 0);
            i--;
        }
        driver.findElement(By.xpath("//div[contains(text(),\"Developing Strategy\")]")).click();
        checkMarkComplete(driver.findElements(By.xpath("//input[@value=\"Mark Complete\"]")).size() > 0);

        //navigate to Monitoring & Digital Advertising page and complete
        driver.findElement(By.xpath("//div[contains(text(),\"Monitoring & Digital Advertising\")]")).click();

        //Verifying title of page
        title = driver.getTitle();
        Assertions.assertEquals(title,"Monitoring & Digital Advertising – Alchemy LMS");

        int j = driver.findElements(By.xpath("//div[@class=\"ld-table-list-item\"]")).size();
        driver.findElement(By.xpath("//div[contains(text(),\"Success with Advert\")]")).click();
        while(j>0) {
           checkMarkComplete(driver.findElements(By.xpath("//input[@value=\"Mark Complete\"]")).size() > 0);
            j--;
        }
        driver.findElement(By.xpath("//div[contains(text(),\"Monitoring & Digital Advertising\")]")).click();
        checkMarkComplete(driver.findElements(By.xpath("//input[@value=\"Mark Complete\"]")).size() > 0);

        //navigate to Investment & Marketing  Final Strategies page and complete
        driver.findElement(By.xpath("//div[contains(text(),\"Investment & Marketing  Final Strategies\")]")).click();

        //Verifying title of page
        title = driver.getTitle();
        Assertions.assertEquals(title,"Investment & Marketing Final Strategies – Alchemy LMS");

        checkMarkComplete(driver.findElements(By.xpath("//input[@value=\"Mark Complete\"]")).size() > 0);
        }

        //method to check course completed or not
        public  void checkMarkComplete(boolean isPresent){
            if(isPresent) {
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                driver.findElement(By.xpath("//input[@value=\"Mark Complete\"]")).click();
            }
            else {
                if(driver.findElements(By.xpath("//span[contains(text(),\"Next Topic\")]")).size()>0){
                    driver.findElement(By.xpath("//span[contains(text(),\"Next Topic\")]")).click();
                }
            }
        }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        //Close the browser
        driver.quit();
    }
}
