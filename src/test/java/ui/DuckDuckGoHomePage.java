package ui;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DuckDuckGoHomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By searchBox = By.name("q");
    // private By searchListOptions = By.xpath("//ol/li/article/div[3]/h2/a");
    private By moreResults = By.id("more-results");

    public DuckDuckGoHomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public DuckDuckGoHomePage(WebDriver driver, int seconds) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
    }

    public void search(String query) {
        WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
        search.sendKeys(query);
        search.submit();
    }

    public boolean isTitleMatching(String keyword) {
        return wait.until(ExpectedConditions.titleContains(keyword));
    }

    public void printSearchResultLinks() {
        List<WebElement> searchATagsList = driver.findElements(By.xpath("//a[contains(@data-testid, 'result-title-a')]"));


        Set<String> hrefLinks = new HashSet<>();
        for(int i = 0; i < Math.min(10, searchATagsList.size()); i++) {

            WebElement aTagPath = searchATagsList.get(i);
            String href = aTagPath.getAttribute("href");

            if(href != null && !href.trim().isEmpty()) {
                hrefLinks.add(href);
            }
        }

        System.out.println("reached here");

        for(String link : hrefLinks) {
            System.out.println(link);
        }
    }
}
