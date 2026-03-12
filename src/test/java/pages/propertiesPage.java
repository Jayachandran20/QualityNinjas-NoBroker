package pages;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;
import utils.Base;

public class propertiesPage {

    WebDriver driver;
    WebDriverWait wait;

    // Get Owner Details buttons
    @FindBy(xpath = "//button[contains(text(),'Get Owner Details')]")
    List<WebElement> ownerDetailsButtons;

    // Login iframe
    By loginIframe = By.xpath("//iframe");

    // Phone field inside popup
    By phoneField = By.xpath("//input[@id='phone']");

    public propertiesPage() {

        driver = Base.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        PageFactory.initElements(driver, this);
    }

    @Step("handling login popup")
    public void clickOwnerDetailsAndCaptureScreenshot() throws Exception {

        // Wait until owner buttons appear
        wait.until(ExpectedConditions.visibilityOfAllElements(ownerDetailsButtons));

        // Click first property owner details
        ownerDetailsButtons.get(0).click();

        // Wait for iframe and switch
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(loginIframe));

        // Wait for phone field inside popup
        wait.until(ExpectedConditions.visibilityOfElementLocated(phoneField)).sendKeys("7010516617");;

        // Take screenshot
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        

        File folder = new File("screenshots");
        if(!folder.exists()) {
            folder.mkdir();
        }

        File dest = new File("screenshots/loginPopup.png");

        FileUtils.copyFile(src, dest);

        System.out.println("Screenshot saved successfully: " + dest.getAbsolutePath());

        // Switch back to main page
        driver.switchTo().defaultContent();
    }
}