# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    # Navigate to the URL
    driver.get("https://www.training-support.net/selenium/login-form")

    # Print the title of the page
    print("Page title is: ", driver.title)

    driver.find_element(By.ID,'username').send_keys('admin')
    driver.find_element(By.ID,'password').send_keys('password')
    driver.find_element(By.XPATH,'//button[contains(text(),"Log in")]').click()