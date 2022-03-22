package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MoviePage {

    private static WebDriver driver;
    private final By genresBy = By.xpath("//span[@class='genres']");
    private static final By actorCardBy = By.xpath("//ol/li[@class='card']");
    private final By titleMovieBy = By.xpath("//div[@class='title ott_true']//a");

    public MoviePage(WebDriver driver){
        MoviePage.driver = driver;
    }

    public static final Logger log = LogManager.getLogger(MoviePage.class);

    public boolean getGenres(String genre){
        log.debug("Getting genres of the movie...");
        String movie = driver.findElement(genresBy).getText();
        String[] genres = movie.split(", ");
        boolean flag = false;
        log.debug("Verify genres on te movie...");
        for (String s : genres) {
            if (s.equals(genre)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static void clickActor(){
        log.debug("Clicking in actor card...");
        driver.findElements(actorCardBy).get(0).click();
        new ActorPage(driver);
    }

    public String getTitleMovie(){
        log.debug("Getting title title movie...");
        return driver.findElements(titleMovieBy).get(0).getText();
    }
}
