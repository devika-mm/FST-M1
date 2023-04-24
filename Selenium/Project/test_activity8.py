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
    driver.find_element(By.XPATH,"//a[@href='https://alchemy.hguy.co/lms/contact/']").click()

    #contact form details
    driver.find_element(By.XPATH,"//input[@id='wpforms-8-field_0']").send_keys('Test')
    driver.find_element(By.XPATH,"//input[@id='wpforms-8-field_1']").send_keys('Test@gmail.com')
    driver.find_element(By.XPATH,"//input[@id='wpforms-8-field_3']").send_keys('Test')
    driver.find_element(By.XPATH,"//textarea[@id='wpforms-8-field_2']").send_keys('Testing contact form')
    driver.find_element(By.ID,"wpforms-submit-8").click()

    #verify confirmation message
    message = driver.find_element(By.XPATH,"//div[@id='wpforms-confirmation-8']/p").text
    print(message)

# Close the browser
driver.quit()