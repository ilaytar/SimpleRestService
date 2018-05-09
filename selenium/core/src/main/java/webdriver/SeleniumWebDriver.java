package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static util.ReadPropertiesUtil.getProperty;

public class SeleniumWebDriver {
    private static WebDriver driver;

    private SeleniumWebDriver() {
    }

    public static WebDriver getInstance() {
        if (driver == null) {
            String browser = getProperty("browser");
            switch (browser) {
                case "firefox":
                    System.setProperty("webdriver.gecko.driver", getProperty("firefox.driver.path"));
                    driver = new FirefoxDriver();
                    break;
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", getProperty("chrome.driver.path"));
                    driver = new ChromeDriver();
                    break;
                default:
                    driver = new FirefoxDriver();
                    break;
            }
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        return driver;
    }

    public static void close() {
        if (driver != null) {
            driver.quit();
        }
        driver = null;
    }
}
