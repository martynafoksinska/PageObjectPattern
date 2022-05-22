package objectPattern;

import Pages.*;
import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.media.model.Timestamp;

import java.util.concurrent.TimeUnit;

public class RegistrationTest {

    private static WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://hotel-testlab.coderslab.pl/en/");
    }

    @Test
    public void testRegistration() throws InterruptedException {

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String email = "test" + timestamp + "@test.com";
        LandingPage onLandingPage = new LandingPage(driver);
        onLandingPage.clickOnSingIn();

        LoginPage onLoginPage = new LoginPage(driver);
        onLoginPage.authentication(email);

        //Faker faker = new Faker();
        //String username = faker.name().firstName();

        RegistrationPage onRegistrationPage = new RegistrationPage(driver);
        onRegistrationPage.createAccount();
        onRegistrationPage.RegisterButton();

        MyAccount myAccount = new MyAccount(driver);
        //Assert.assertTrue(myAccount.checkUsernameVisibility(username));
        myAccount.addFirstAddress();
        myAccount.logOut();

        onLandingPage.clickOnSingIn();
        onLoginPage.login(email, "haslo123");
        onLandingPage.goToStartPage();
        onLandingPage.searchHotel();

        Thread.sleep(2000);

        SearchRooms onSearchRooms = new SearchRooms(driver);
        onSearchRooms.bookHotel();


    }

    @After
    public void tearDown() {
        //driver.quit();

    }
}