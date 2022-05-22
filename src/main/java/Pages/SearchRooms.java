package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchRooms {

    private WebDriver driver;

    public SearchRooms(WebDriver driver) {
        this.driver = driver;
    }

    public void bookHotel() {
        WebElement bookNowButton = driver.findElement(By.xpath("//*[@id='category_data_cont']/div[3]/div/div[2]/a/span"));
        bookNowButton.click();
        WebElement proceedToCheckOut = driver.findElement(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[3]/a/span"));
        proceedToCheckOut.click();
    }
}