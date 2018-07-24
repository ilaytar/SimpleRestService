package util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import webdriver.SeleniumWebDriver;

public class SeleniumUtil {
    private static WebDriver driver = SeleniumWebDriver.getInstance();

    public static void scrollToElement(WebElement targetElement) {
        Actions actions = new Actions(driver);
        actions.moveToElement(targetElement).click().perform();
    }

    public static void scrollPageToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public static void click(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
}