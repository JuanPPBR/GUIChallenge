package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.Objects;


public class ActorPage {

    private final WebDriver driver;
    private final By knownForBy = By.xpath("//li[@class='account_adult_false item_adult_false']");

    private static final Logger log = LogManager.getLogger(ActorPage.class);

    public ActorPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean checkTimeline(String tittleMovie) {
        log.debug("Getting movies know for...");
        int length = driver.findElements(knownForBy).toArray().length;
        boolean flag = false;
        log.debug("Checking movie in know for...");
        for (int i = 0; i < length; i++) {
            if (Objects.equals(driver.findElements(knownForBy).get(i).getText(), tittleMovie)) {
                flag = true;
            }
        }
        return flag;
    }

}
