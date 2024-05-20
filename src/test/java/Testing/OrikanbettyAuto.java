package Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

public class OrikanbettyAuto {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Set up WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    
    @Test
    public void VerifyNextButtonisEnabled() {
        // Test data
        String username = OrikanConfig.USERNAME;
        String password = OrikanConfig.PASSWORD;
        
        // Navigate to the registration page
        driver.get(OrikanConfig.URL);

        // Fill in registration form
        driver.findElement(OrikanLocators.EMAIL_ADDRESS_INPUT).sendKeys(username);
        //Verify the button is enabled 
        WebElement element= driver.findElement(OrikanLocators.REGISTER_BUTTON_STEP1);
        if(!element.isEnabled()) {
         System.out.println("Test is pass: Next button is in Disabled state");
        }
        else {
        	System.out.println("The Test case is failed: Next button is in Enabled state");
        }
        driver.findElement(OrikanLocators.PASSWORD_INPUT).sendKeys(password);
        driver.findElement(OrikanLocators.CONFIRM_PASSWORD_INPUT).sendKeys(password);
        driver.findElement(OrikanLocators.REGISTER_BUTTON_STEP1).click();

           }
    @Test
    public void testRegistrationWithExistingEmail() {
        // Test data
        String username = OrikanConfig.USERNAME2;
        String password = OrikanConfig.PASSWORD2;
        String expectedToastMessage = "Email address is already registered";

        // Navigate to the registration page
        driver.get(OrikanConfig.URL);

        // Fill in registration form
        driver.findElement(OrikanLocators.EMAIL_ADDRESS_INPUT).sendKeys(username);
        driver.findElement(OrikanLocators.PASSWORD_INPUT).sendKeys(password);
        driver.findElement(OrikanLocators.CONFIRM_PASSWORD_INPUT).sendKeys(password);
        driver.findElement(OrikanLocators.REGISTER_BUTTON_STEP1).click();

        // Get the toast message
        String actualToastMessage = driver.findElement(By.className("toast-message error active")).getText();

        // Verify toast message
        Assert.assertEquals(actualToastMessage, expectedToastMessage, "Incorrect toast message displayed");
        System.out.println("Test case passed: Registration with existing email detected successfully");
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
