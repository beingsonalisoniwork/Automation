package ui;

import org.testng.Assert;
import org.testng.annotations.Test;

/*
 * Write a program to perform the following steps :
 * 1. Go to "https://www.duckduckgo.com"
 * 2. Search for the keyword "Software Quality Assurance"
 * 3. Collect the value of the "href" attribute of the 10 search results
 * 4. Perform the same for the next three search result pages
 * 5. Print the collectedlinks
*/

public class SprinklrSearchPrintLinksTest extends BaseUiTest {

    @Test
    public void testSearchAndFetchLinks() {
        // 1. Go to homepage
        driver.get("https://duckduckgo.com/");
        // set up wait
        DuckDuckGoHomePage homePage = new DuckDuckGoHomePage(driver, 30);

        // 2. Search keyword
        homePage.search("Software Qaulity Assurance");
        Assert.assertTrue(homePage.isTitleMatching("Software Qaulity Assurance"));

        // 3. Collect href from next three search result pages and print collected links
        homePage.printSearchResultLinks();
    }
}
