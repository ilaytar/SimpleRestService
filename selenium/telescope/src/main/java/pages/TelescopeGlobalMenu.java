package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import webdriver.SeleniumWebDriver;

import java.util.NoSuchElementException;

import static java.util.concurrent.TimeUnit.SECONDS;

public class TelescopeGlobalMenu {
    private WebDriver driver = SeleniumWebDriver.getInstance();

    private Wait<WebDriver> wait = new FluentWait<>(driver)
            .withTimeout(30, SECONDS)
            .pollingEvery(5, SECONDS)
            .ignoring(NoSuchElementException.class);

    @FindBy(xpath = "//i[contains(@class, 'PinContainer')]")
    private WebElement pin;

    @FindBy(xpath = "//div[@class='modal-footer']/button[text()='Cancel']")
    private WebElement closeChangeLandingPageDialogButton;

    @FindBy(xpath = "//div[@class='modal-footer']/button[text()='OK']")
    private WebElement acceptChangeLandingPageDialogButton;

    private WebElement menuItemLink(String item) {
        return driver.findElement(By.xpath(String.format("//a[contains(@class,'MainMenu')][text()='%s']", item)));
    }

    public TelescopeGlobalMenu() {
        PageFactory.initElements(SeleniumWebDriver.getInstance(), this);
    }

    public TelescopeGlobalMenu pin() {
        wait.until(ExpectedConditions.elementToBeClickable(pin)).click();
        driver.switchTo().activeElement();
        return this;
    }

    public TelescopeGlobalMenu cancelChangeLandingPageDialogWindow() {
        closeChangeLandingPageDialogButton.click();
        return new TelescopeGlobalMenu();
    }

    public TelescopeGlobalMenu acceptChangeLandingPageDialogWindow() {
        acceptChangeLandingPageDialogButton.click();
        return new TelescopeGlobalMenu();
    }

    public TelescopeSearchTasksPage goToTelescopeSearchTasksPage() {
        menuItemLink("Tasks").click();
        return new TelescopeSearchTasksPage();
    }

    public TelescopeSearchPeoplePage goToTelescopeSearchPeoplePage() {
        menuItemLink("People").click();
        return new TelescopeSearchPeoplePage();
    }

    public TelescopeGlobalMenu validateLandingPageInTelescopeIs(String page) {
        Assert.assertEquals(menuItemLink(page).getCssValue("color"), "rgb(57, 194, 215)");
        return this;
    }
}
