package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;

public class Activity5 {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        // Set up the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        //Open browser
        driver.get("https://www.training-support.net/selenium/input-events");
    }

    @Test
    public void exampleTestCase() {
        // Check the title of the page
        String title = driver.getTitle();

        //Print the title of the page
        System.out.println("Page title is: " + title);
        Actions builder = new Actions(driver);

        // Open the page
        driver.get("https://www.training-support.net/selenium/input-events");
        // Print the title of the page
        System.out.println("Home page title: " + driver.getTitle());

        // Perform left click
        builder.click().pause(1000).build().perform();
        // Print the front side text
        String frontText = driver.findElement(By.className("active")).getText();
        System.out.println(frontText);

        // Perform left click
        builder.doubleClick().pause(1000).build().perform();
        // Print the front side text
        frontText = driver.findElement(By.className("active")).getText();
        System.out.println(frontText);

        // Perform left click
        builder.contextClick().pause(1000).build().perform();
        // Print the front side text
        frontText = driver.findElement(By.className("active")).getText();
        System.out.println(frontText);
    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}
