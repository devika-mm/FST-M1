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

    #verify title of page
    title = driver.title
    print(title)
    assert "My Account – Alchemy LMS" == title

    #lms log in
    driver.find_element(By.XPATH,"//a[@href='#login']").click()
    driver.find_element(By.XPATH,"//input[@id='user_login']").send_keys('root')
    driver.find_element(By.XPATH,"//input[@id='user_pass']").send_keys('pa$$w0rd')
    driver.find_element(By.XPATH,"//input[@id='wp-submit']").click()

    #verify title of page
    title = driver.find_element(By.XPATH,"//h1[contains(text(),'  My Account    ')]").text
    print(title)
    assert "My Account" == title

# Close the browser
driver.quit()