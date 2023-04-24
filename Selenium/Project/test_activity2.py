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

    #print heading of page
    heading = driver.find_element(By.CLASS_NAME,"uagb-ifb-title").text
    print(heading)
    assert "Learn from Industry Experts" == heading

# Close the browser
driver.quit()