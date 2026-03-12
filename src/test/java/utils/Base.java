package utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Base {

    Properties prop;

    // ThreadLocal WebDriver
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // ThreadLocal ExtentTest
    private static ThreadLocal<ExtentTest> extTest = new ThreadLocal<>();

    ExtentSparkReporter extSparkReport;
    public static ExtentReports extReports;

    // Getter for driver
    public static WebDriver getDriver() {
        return driver.get();
    }

    // Getter for ExtentTest
    public static ExtentTest getTest() {
        return extTest.get();
    }

    // Setter for ExtentTest
    public static void setTest(ExtentTest test) {
        extTest.set(test);
    }

    @BeforeClass
    public void beforeClass() {

        extSparkReport = new ExtentSparkReporter("reports/ExtentReport.html");

        extReports = new ExtentReports();
        extReports.attachReporter(extSparkReport);

        LaunchBrowser();
    }

    @AfterClass
    public void after() {

        extReports.flush();

        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }

    public void LaunchBrowser() {

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_leak_detection", false);
        prefs.put("profile.default_content_setting_values.notifications", 2);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);

        prop = PropertyReader.readProperty();
        String browserName = prop.getProperty("Browser");

        WebDriver localDriver = null;

        if (browserName.equalsIgnoreCase("Chrome")) {

            localDriver = new ChromeDriver(options);

        } else if (browserName.equalsIgnoreCase("fireFox")) {

            localDriver = new FirefoxDriver();

        } else if (browserName.equalsIgnoreCase("edge")) {

            localDriver = new EdgeDriver();
        }

        driver.set(localDriver);

        getDriver().manage().window().maximize();
        getDriver().get(prop.getProperty("URL"));
    }
}