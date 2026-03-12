package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;
import utils.Base;

public class HomePage {

    public WebDriver driver;
    public WebDriverWait wait;

    // Current city
    @FindBy(xpath = "//div[contains(text(),'Bangalore')]")
    WebElement currentcity;

    // City list
    @FindBy(xpath = "//div[text()='Bangalore' or text()='Chennai' or text()='Delhi-NCR' or text()='Hyderabad' or text()='Mumbai' or text()='Pune']")
    List<WebElement> cities;

    // Search locality textbox
    @FindBy(xpath = "//input[@placeholder='Search upto 3 localities or landmarks']")
    WebElement searchBox;

    // Locality dropdown suggestions
    @FindBy(xpath = "//div[contains(@class,'suggestion')]")
    List<WebElement> localitySuggestions;

    // BHK dropdown
    @FindBy(xpath = "//div[contains(text(),'BHK')]")
    WebElement bhkDropdown;

    // All BHK options
    @FindBy(xpath = "//div[text()='1 BHK' or text()='2 BHK' or text()='3 BHK' or text()='4 BHK']")
    List<WebElement> bhkOptions;

    // Search button
    @FindBy(xpath = "//button[contains(text(),'Search')]")
    WebElement searchButton;

    public HomePage() {
        this.driver = Base.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    @Step("Selecting product from menu")
    public void searchApartment() {

        // Select City
        wait.until(ExpectedConditions.elementToBeClickable(currentcity));
        currentcity.click();

        wait.until(ExpectedConditions.visibilityOfAllElements(cities));

        for (WebElement city : cities) {

            if (city.getText().equalsIgnoreCase("Pune")) {
                city.click();
                break;
            }
        }

        // Enter locality
        wait.until(ExpectedConditions.elementToBeClickable(searchBox));
        searchBox.sendKeys("Kharadi");

        // Select locality from dropdown
        wait.until(ExpectedConditions.visibilityOfAllElements(localitySuggestions));

        for (WebElement place : localitySuggestions) {

            if (place.getText().toLowerCase().contains("kharadi")) {
                place.click();
                break;
            }
        }

        // Select BHK
        wait.until(ExpectedConditions.elementToBeClickable(bhkDropdown));
        bhkDropdown.click();

     // wait until BHK options are visible

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                org.openqa.selenium.By.xpath("//div[contains(@class,'dropdown')]")
        ));
        // send keyboard keys to active element
        driver.switchTo().activeElement().sendKeys(
                org.openqa.selenium.Keys.ARROW_DOWN,
                org.openqa.selenium.Keys.ARROW_DOWN,
                org.openqa.selenium.Keys.ENTER
        );
        
        // Click Search
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();
    }
}