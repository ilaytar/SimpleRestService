package util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import webdriver.SeleniumWebDriver;

public class SeleniumUtil {
    static WebDriver driver = SeleniumWebDriver.getInstance();

    public static void scrollToElement(WebElement scroller, WebElement targetElement) {
        Actions actions = new Actions(driver);
        actions.moveToElement(targetElement).perform();
    }

    public static void scrollPageToElement(WebElement element) {
        Point point = element.getLocation();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(" + point.getX() + "," + point.getY() + ")");
    }

}