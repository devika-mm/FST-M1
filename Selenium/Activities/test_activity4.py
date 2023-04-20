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
    driver.get("https://www.training-support.net/selenium/target-practice")

    # Print the title of the page
    print("Page title is: ", driver.title)

    text = driver.find_element(By.XPATH,'//h3[@id="third-header"]').text
    print("Third header text : "+text)

    text = driver.find_element(By.XPATH,'//h5[text()="Fifth header"]').value_of_css_property("color")
    print("Fifth header color : "+text)

    element = driver.find_element(By.XPATH,'//button[text()="Violet"]').get_attribute("class")
    print("Classes of Violet Button : "+element)

    text = driver.find_element(By.XPATH,'//button[text()="Grey"]').text
    print("Grey button text : "+text);