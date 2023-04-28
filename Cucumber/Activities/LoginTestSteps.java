package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.time.temporal.ChronoUnit.SECONDS;

public class LoginTestSteps extends BaseClass{

    @Given("^User is on Login page$")
    public void loginPage() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.of(10, SECONDS));
        driver.get("https://www.training-support.net/selenium/login-form");
    }

    @When("^User enters username and password$")
    public void credentials(){
        driver.findElement(By.xpath("//input[@id=\"username\"]")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("password");
        driver.findElement(By.xpath("//button[text()=\"Log in\"]")).click();
    }

    @When("^User enters \"(.*)\" and \"(.*)\"$")
    public void user_enters_and(String username,String password) throws Throwable{
        driver.findElement(By.xpath("//input[@id=\"username\"]")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys(password);
        driver.findElement(By.xpath("//button[text()=\"Log in\"]")).click();
    }


    @Then("^Read the page title and confirmation message$")
    public void confirmMessage(){
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);

        String msg =  driver.findElement(By.id("action-confirmation")).getText();
        System.out.println(msg);
    }
}
