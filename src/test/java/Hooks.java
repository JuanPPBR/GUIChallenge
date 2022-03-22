import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.util.Date;


public class Hooks {

    protected WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.themoviedb.org/");
    }
    @AfterMethod
    public void Screenshots() throws IOException{
        Date currentDate = new Date();
        String screenShotFileName = currentDate.toString().replace(" ","-").replace(":","-");

        File screenshotTest = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotTest, new File(".//screenshots//" + screenShotFileName + ".png"));
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
