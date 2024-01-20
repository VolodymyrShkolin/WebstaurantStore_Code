package Core;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

abstract public class BasePage implements Constants {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static JavascriptExecutor jsExecutor;

    public static void setDriver(WebDriver webDriver){
        driver = webDriver;
        jsExecutor = (JavascriptExecutor)driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(IMPLICIT_WAIT));
    }
}
