# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    # Open the browser to the URL
    driver.get("https://alchemy.hguy.co/lms")

    #click on my account tab
    driver.find_element(By.XPATH,"//a[@href='https://alchemy.hguy.co/lms/my-account/']").click()

    #title of page
    title = driver.title
    print(title)
    assert "My Account – Alchemy LMS" == title

# Close the browser
driver.quit()