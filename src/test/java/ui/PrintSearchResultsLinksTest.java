package ui;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PrintSearchResultsLinksTest extends BaseUiTest {

    /*
    * Write a program to perform the following steps :
    * 1. Go to "https://www.duckduckgo.com"
    * 2. Search for the keyword "Software Quality Assurance"
    * 3. Collect the value of the "href" attribute of the 10 search results
    * 4. Perform the same for the next three search result pages
    * 5. Print the collectedlinks
    */

    @Test
    public void openWebsiteAndSearchKeyword() throws InterruptedException {
        driver.get("https://duckduckgo.com/");
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // implicit wait, global

        Thread.sleep(5000);

        // 1. Verify website is open
        Assert.assertTrue(driver.getTitle().contains("DuckDuckGo"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // explicit wait, condition defined
        String keyword = "Software Quality Assurance";

        // 2. Search keyword
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
        searchBox.sendKeys(keyword);
        Thread.sleep(2000);
        searchBox.submit();
        Thread.sleep(2000);

        // 3. Collect value of href of 10 search results
        List<WebElement> list = driver.findElements(By.xpath("//a[@data-testid='result-title-a']")); // findElements returns 'list' of WebElements
        Set<String> hrefLinks = new HashSet<>();

        for(int i = 0; i < Math.min(10, list.size()); i++ ) {

            /*
             * list.get(i) returns 1 WebElement, here <a> tag
             * getAttribute("href") fetches the attribute value from the webElement
             * hrefLinks.add adds the href value into the set
            */
            
            hrefLinks.add(list.get(i).getAttribute("href")); 
        }

        // 5. Print the links
        for(String link : hrefLinks) {
            System.out.println(link);
        }
    }
}