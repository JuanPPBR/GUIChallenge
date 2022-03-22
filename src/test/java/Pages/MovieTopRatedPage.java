package Pages;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import org.apache.logging.log4j.Logger;
import static org.apache.logging.log4j.LogManager.getLogger;


public class MovieTopRatedPage {

    private final WebDriver driver;

    private final By filterButtonBy = By.xpath("//div[@data-callback='filterCallback()']");
    private final By actionButtonBy = By.xpath("//li[@data-value='28']");
    private final By searchButtonBy = By.xpath("//div[@class='apply small background_color light_blue enabled']");
    private final By actionMovieBy = By.xpath("//h2//a[@href='/movie/1891']");
    private final By movieBy = By.xpath("//div[@class='card style_1']");
    private final By dropdownMenuSortBy = By.xpath("//span[@class='k-widget k-dropdown kendo_dropdown full_width font_size_1']");
    private final By releaseDateAscendingBy = By.xpath("//ul[@class='k-list k-reset']/li[@data-offset-index='5']");
    private final By movieDateBy = By.xpath("//div[@class='content']/p");


    public MovieTopRatedPage(WebDriver driver){
        this.driver = driver;
    }

    private static final Logger log = LogManager.getLogger(MovieTopRatedPage.class);

    public MovieTopRatedPage clickFilterButton(){
        log.debug("Clicking filter button...");
        driver.findElement(filterButtonBy).click();
        return new MovieTopRatedPage(driver);
    }

    public MovieTopRatedPage clickActionButton(){
        log.debug("Clicking Action button...");
        driver.findElement(actionButtonBy).click();
        return new MovieTopRatedPage(driver);
    }

    public MovieTopRatedPage clickSearchButtonByAction(){
        log.debug("Clicking Search button...");
        driver.findElement(searchButtonBy).click();
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.numberOfElementsToBe(actionMovieBy, 1));
        return new MovieTopRatedPage(driver);
    }

    public void selectMovie(int i){
        log.debug("Selecting movie...");
        driver.findElements(movieBy).get(i).click();
        new MoviePage(driver);
    }

    public MovieTopRatedPage clickInDropdownMenuSort(){
        log.debug("Clicking sort");
        driver.findElement(dropdownMenuSortBy).click();
        return new MovieTopRatedPage(driver);
    }

    public MovieTopRatedPage selectReleaseDateAscending (){
        log.debug("Waiting dropdown menu...");
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.numberOfElementsToBe(releaseDateAscendingBy, 4));
        log.debug("Clicking dropdown menu in Date ascending...");
        driver.findElements(releaseDateAscendingBy).get(0).click();
        return new MovieTopRatedPage(driver);
    }

    public MovieTopRatedPage clickSearchButton(){
        log.debug("Clicking search button...");
        driver.findElement(searchButtonBy).click();
        return new MovieTopRatedPage(driver);
    }


    public boolean checkReleaseDateAscending(){
        log.debug("Checking release date ascending...");
        boolean flag = false;
        List<WebElement> dates = driver.findElements(movieDateBy);
        for (int i = 0; i < 3; i++){
            if (Integer.parseInt(dates.get(i + 1).getText().split(", ")[1]) > Integer.parseInt(dates.get(i).getText().split(", ")[1])) {
                flag = true;
            }
        }
        return flag;
    }

}
