package Pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccount {
    private static WebDriver driver;

    public MyAccount(WebDriver driver) {
        this.driver = driver;
    }

    public void textAlert() {
        WebElement successText = driver.findElement(By.className("alert"));
        //return successText.getText();

        if (successText.isDisplayed()) {
            System.out.println("Your account has been created");
        } else {
            System.out.println("Account not created");
        }
    }

    public void logOut() {
        WebElement userNameButton = driver.findElement(By.id("user_info_acc"));
        WebElement logOutButton = driver.findElement(By.xpath("//*[@id='header']/div[3]/div/div/div[7]/ul/li/ul/li[3]/a"));

        userNameButton.click();
        logOutButton.click();

    }

    public void addFirstAddress() {

        Faker faker = new Faker();

        WebElement addMyFirstAddress = driver.findElement(By.xpath("//*[@id='center_column']/div/div/ul/li[1]/a/span"));
        addMyFirstAddress.click();

        driver.findElement(By.id("address1")).sendKeys(faker.address().streetAddress());
        driver.findElement(By.id("postcode")).sendKeys(faker.number().digits(5));
        driver.findElement(By.id("city")).sendKeys(faker.address().city());
        driver.findElement(By.id("phone_mobile")).sendKeys(faker.phoneNumber().cellPhone());
        driver.findElement(By.id("alias")).click();
        driver.findElement(By.id("submitAddress")).click();
        driver.findElement(By.xpath("//*[@id='center_column']/ul/li[1]/a/span")).click();
    }
}


    /*public boolean checkUsernameVisibility(String username) {
        WebElement usernameDropDown = driver.findElement(By.className("account_user_name"));

        if (usernameDropDown.getText() == username) {
            return true;
        } else {
            return false;
        }
        */