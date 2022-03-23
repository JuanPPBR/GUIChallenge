package Pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.apache.logging.log4j.LogManager.getLogger;

public class LoginPage {

    private final WebDriver driver;

    private final By usernameTextboxBy = By.id("username");
    private final By passwordTextboxBy = By.id("password");
    private final By loginButtonBy = By.id("login_button");
    private final By thereWasAProblemBy = By.className("carton");
    private final By redBoxBy = By.xpath("//div[@class='content']/ul/li['You have 6 remaining login attempts.']");

    private static final Logger log = getLogger(LoginPage.class.getName());

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public LoginPage typingUsername(String username){
        log.debug("Typing username...");
        driver.findElement(usernameTextboxBy).sendKeys(username);
        return new LoginPage(driver);
    }

    public LoginPage typingPassword(String password){
        log.debug("Typing password...");
        driver.findElement(passwordTextboxBy).sendKeys(password);
        return new LoginPage(driver);
    }

    public void clickLoginButton(){
        log.debug("Clicking login button...");
        driver.findElement(loginButtonBy).click();
        new ProfilePage(driver);
    }

    public LoginPage waitThereWasAProblem(){
        log.debug("Waiting red box...");
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.numberOfElementsToBe(thereWasAProblemBy, 1));
        return new LoginPage(driver);
    }

    public String getTextRedBox(){
        log.debug("Getting text of the red box...");
        return driver.findElements(redBoxBy).get(1).getText();
    }
}
