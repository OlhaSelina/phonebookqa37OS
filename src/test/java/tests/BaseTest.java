package tests;

import config.ApplicationManager;
import dto.ContactDTO;
import io.github.bonigarcia.wdm.WebDriverManager;
import dto.UserDTO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


import java.time.Duration;
import java.util.List;

public class BaseTest  {
    static ApplicationManager app =
            new ApplicationManager(System
                    .getProperty("browser", Browser.CHROME.browserName()));
    UserDTO user = new UserDTO().setEmail("ledyolga@ukr.net").setPassword("Qwerty123!@#");
    @BeforeSuite
    public static void startBrowser() {
        app.init();
    }

    @AfterSuite
    public static void tearDown(){
        app.quit();
    }
}
