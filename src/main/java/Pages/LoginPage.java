package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.media.model.Timestamp;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void authentication(String email) {
        WebElement authentication = driver.findElement(By.id("email_create"));

        authentication.sendKeys(email);

        driver.findElement(By.name("SubmitCreate")).click();

    }

    public void login(String email, String password) {
        WebElement emailInput = driver.findElement(By.id("email"));
        WebElement passwordInput = driver.findElement(By.id("passwd"));
        WebElement submitButton = driver.findElement(By.id("SubmitLogin"));
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        submitButton.click();
    }

}