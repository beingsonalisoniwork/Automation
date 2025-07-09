package ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if(driver == null) {
            WebDriverManager.chromedriver().setup();

            // ChromeOptions options = new ChromeOptions();
            // Headless Mode
            // options.addArguments("--headless=new"); 
            // options.addArguments("--window-size=1920,1080");
            // options.addArguments("--disable-gpu");
            // options.addArguments("--disable-extensions");
            // options.addArguments("--no-sandbox"); 
            // options.addArguments("--disable-dev-shm-usage");

            driver = new ChromeDriver();
        }
        return driver;
    }

    public static void quitDriver() {
        if(driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
