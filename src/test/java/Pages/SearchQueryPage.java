package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SearchQueryPage {

    private final WebDriver driver;

    private final By titleFirstMovieBy = By.xpath("//div[@class='title']//a");

    private static final Logger log = LogManager.getLogger(SearchQueryPage.class);

    public SearchQueryPage(WebDriver driver){
        this.driver = driver;
    }

    public String titleFirstMove(){
        log.debug("Getting title first movie...");
        return driver.findElements(titleFirstMovieBy).get(0).getText();
    }

}
