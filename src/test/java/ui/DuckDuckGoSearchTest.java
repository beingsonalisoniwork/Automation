package ui;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DuckDuckGoSearchTest extends BaseUiTest {

    @Test
    public void testDuckDuckGoSearch() {
        driver.get("https://duckduckgo.com/");
        
        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        // WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
        // searchBox.sendKeys("Selenium WebDriver");
        // searchBox.submit();
        // wait.until(ExpectedConditions.titleContains("Selenium"));
        // System.out.println("Page title: " + driver.getTitle());
        // Assert.assertTrue(driver.getTitle().toLowerCase().contains("selenium"));

        DuckDuckGoHomePage homePage = new DuckDuckGoHomePage(driver);
        homePage.search("Selenium WebDriver");
        Assert.assertTrue(homePage.isTitleMatching("Selenium WebDriver"));
    }
}
