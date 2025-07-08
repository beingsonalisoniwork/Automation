package ui;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseUiTest;

public class DuckDuckGoSearchTest extends BaseUiTest {

    @Test
    public void testDuckDuckGoSearch() {
        driver.get("https://duckduckgo.com/");
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
        searchBox.sendKeys("Selenium WebDriver");
        searchBox.submit();

        wait.until(ExpectedConditions.titleContains("Selenium"));

        System.out.println("Page title: " + driver.getTitle());
        Assert.assertTrue(driver.getTitle().toLowerCase().contains("selenium"));
    }
}
