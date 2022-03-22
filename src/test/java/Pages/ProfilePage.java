package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ProfilePage {

    private final WebDriver driver;

    private final By contentWrapperBy = By.xpath("//div[@class='content_wrapper flex']//a");

    private static final Logger log = LogManager.getLogger(ProfilePage.class);

    public ProfilePage(WebDriver driver){
        this.driver = driver;
    }
    public String getContentWrapper(){
        log.debug("Getting name profile...");
        return driver.findElement(contentWrapperBy).getText();
    }

}
