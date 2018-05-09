package verificator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import webdriver.SeleniumWebDriver;

public class Verificator {
    WebDriver driver = SeleniumWebDriver.getInstance();

    public static void verifyThatElementDisplayedTextIs(WebElement element, String expectedText) {
        Assert.assertEquals(element.getText(), expectedText);
    }
}
