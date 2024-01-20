package Core;

import PageObjectClasses.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

abstract public class BaseTest implements Constants{
    protected static WebDriver driver;
    protected static MainPage mp;



    @BeforeAll
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(IMPLICIT_WAIT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
        BasePage.setDriver(driver);

        mp = new MainPage();

        driver.get(URL);
    }

    @AfterAll
    public static void tearDown(){
        driver.close();
        driver.quit();
    }
}
