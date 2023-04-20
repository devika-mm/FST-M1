package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity4 {

        WebDriver driver;

        @BeforeMethod
        public void beforeMethod() {
            // Set up the Firefox driver
            WebDriverManager.firefoxdriver().setup();
            //Create a new instance of the Firefox driver
            driver = new FirefoxDriver();

            //Open browser
            driver.get("https://www.training-support.net/selenium/target-practice");
        }

        @Test
        public void exampleTestCase() {
            // Check the title of the page
            String title = driver.getTitle();

            //Print the title of the page
            System.out.println("Page title is: " + title);

            String text = driver.findElement(By.xpath("//h3[@id=\"third-header\"]")).getText();
            System.out.println("Third header text : "+text);

            text = driver.findElement(By.xpath("//h5[text()=\"Fifth header\"]")).getCssValue("color");
            System.out.println("Fifth header color : "+text);

            String element = driver.findElement(By.xpath("//button[text()=\"Violet\"]")).getAttribute("class");
            System.out.println("Classes of Violet Button : "+element);

            text = driver.findElement(By.xpath("//button[text()=\"Grey\"]")).getText();
            System.out.println("Grey button text : "+text);
        }

        @AfterMethod
        public void afterMethod() {
            //Close the browser
            driver.quit();
        }
    }


