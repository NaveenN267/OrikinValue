package Testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static Testing.OrikanLocators.*;

public class OrikanAutoTesting {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        // Step 1: Register User
        registerUser(driver, OrikanConfig.USERNAME, OrikanConfig.PASSWORD);

        driver.quit();
    }

    private static void registerUser(WebDriver driver, String username, String password) {
        driver.get(OrikanConfig.URL);
        driver.findElement(EMAIL_ADDRESS_INPUT).sendKeys(username);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(CONFIRM_PASSWORD_INPUT).sendKeys(password);
        driver.findElement(REGISTER_BUTTON_STEP1).click();
    }
}
