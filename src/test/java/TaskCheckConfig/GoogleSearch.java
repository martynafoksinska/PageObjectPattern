package TaskCheckConfig;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.google.com");

        WebElement searchBar = driver.findElement(By.name("q"));
        //WebElement element1 = driver.findElement(By.xpath("//*[@id='L2AGLb']/div"));
        WebElement acceptPopUpButton = driver.findElement(By.id("L2AGLb"));

        acceptPopUpButton.isDisplayed();
        acceptPopUpButton.click();

        searchBar.clear();
        searchBar.sendKeys("Coderslab");
        searchBar.submit();
        driver.quit();
    }
}