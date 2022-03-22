package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private final WebDriver driver;

    private final By loginBy = By.xpath("//div[@class='flex']//a[@href='/login']");
    private final By searchBarBy = By.id("inner_search_v4");
    private final By searchButtonBy = By.xpath("//div[@class='search']//form//input[@type='submit']");
    private final By movieButtonBy = By.xpath("//li[@class='k-item k-menu-item k-state-default k-first']");
    private final By topRatedInDropdownMenuBy = By.xpath("//li[@class='k-item k-menu-item k-state-default k-last']//a[@href='/movie/top-rated']");

    private static final Logger log = LogManager.getLogger(HomePage.class);

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public LoginPage clickLoginButton(){
        log.debug("Clicking login button...");
        driver.findElement(loginBy).click();
        return new LoginPage(driver);
    }

    public void clickSearchButton(){
        log.debug("Clicking search button...");
        driver.findElement(searchButtonBy).click();
        new SearchQueryPage(driver);
    }

    public HomePage clickMovieButton(){
        log.info("Clicking movie button ...");
        driver.findElement(movieButtonBy).click();
        return new HomePage(driver);
    }

    public MovieTopRatedPage clickTopRatedInDropMenu(){
        log.debug("Clicking top rated in dropdown menu...");
        driver.findElement(topRatedInDropdownMenuBy).click();
        return new MovieTopRatedPage(driver);
    }

    public HomePage typingInSearchBar(String search){
        log.debug("Typing in search bar...");
        driver.findElement(searchBarBy).sendKeys(search);
        return new HomePage(driver);
    }
}

