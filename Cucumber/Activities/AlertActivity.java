package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.time.temporal.ChronoUnit.SECONDS;

public class AlertActivity extends BaseClass{
Alert alert;
    @Given("User is on the page")
    public void openPage(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.of(10, SECONDS));

        driver.get("https://www.training-support.net/selenium/javascript-alerts");
    }

    @When("User clicks the Simple Alert button")
    public void simpleAlert(){
        driver.findElement(By.id("simple")).click();
    }

    @When("User clicks the Confirm Alert button")
    public void confirmAlert(){
        driver.findElement(By.id("confirm")).click();
    }

    @When("User clicks the Prompt Alert button")
    public void promptAlert(){
        driver.findElement(By.id("prompt")).click();
    }

    @Then("Alert opens")
    public void alertOpens(){
        alert = driver.switchTo().alert();
    }
    @Then("Read the text from it and print it")
    public void readAlertText(){
       String text = alert.getText();
       System.out.println(text);
    }

    @Then("Close the alert")
    public void closeAlert(){
        alert.accept();
    }

    @Then("Close the alert with Cancel")
    public void closeAlertWithCancel(){
        alert.dismiss();
    }

    @Then("Write a custom message in it")
    public void closeAlertWithMsg(){
        alert.sendKeys("Custom Message");
    }

}
