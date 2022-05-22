package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LandingPage {
    private WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;

    }

    public void clickOnSingIn() {
        WebElement clickOnSignIn = driver.findElement(By.className("user_login"));
        clickOnSignIn.click();
    }

    public void goToStartPage() {
        WebElement startPageButton = driver.findElement(By.id("header_logo"));
        startPageButton.click();
    }

    public void searchHotel() {
        WebElement hotelLocation = driver.findElement(By.id("hotel_location"));
        WebElement selectHotel = driver.findElement(By.id("hotel_cat_name"));
        WebElement selectHotelPrime = driver.findElement(By.xpath("//*[@id='search_hotel_block_form']/div[2]/div/ul/li"));
        WebElement checkInDate = driver.findElement(By.id("check_in_time"));
        WebElement checkOutDate = driver.findElement(By.id("check_out_time"));
        WebElement searchNowButton = driver.findElement(By.id("search_room_submit"));

        hotelLocation.sendKeys("Paris");
        selectHotel.click();
        selectHotelPrime.click();

        LocalDate dateCheckIn = LocalDate.now();
        LocalDate dateCheckOut = dateCheckIn.plusDays(3);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        checkInDate.sendKeys(dateCheckIn.format(formatter));
        checkOutDate.sendKeys(dateCheckOut.format(formatter));
        searchNowButton.click();

    }
}