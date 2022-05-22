package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LandingPagePageFactory {

    private WebDriver driver;

    public LandingPagePageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(className = "user_login")
    WebElement signInLink;

    @FindBy(id = "header_logo")
    WebElement headerLogoButton;

    @FindBy(id = "hotel_location")
    WebElement cityInput;

    @FindBy(id = "hotel_cat_name")
    WebElement selectHotel;

    @FindBy(xpath = "//*[@id='search_hotel_block_form']/div[2]/div/ul/li")
    WebElement selectHotelPrime;

    @FindBy(id = "check_in_time")
    WebElement chekInDate;

    @FindBy(id = "check_out_time")
    WebElement checkOutDate;

    @FindBy(id = "search_room_submit")
    WebElement searchNow;

    public void clickOnSignIn() {
        signInLink.click();
    }

    public void searchHotel(String city) {
        cityInput.sendKeys(city);
        selectHotel.click();
        selectHotelPrime.click();

        LocalDate dateChackIn = LocalDate.now();
        LocalDate dateChackOut = dateChackIn.plusDays(2);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");

        chekInDate.sendKeys(dateChackIn.format(formatter));
        checkOutDate.sendKeys(dateChackOut.format(formatter));
        searchNow.click();
    }

    public void goToStartPage(){
        headerLogoButton.click();
    }
}