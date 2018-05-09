package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;
import util.SeleniumUtil;
import webdriver.SeleniumWebDriver;

import java.util.List;
import java.util.NoSuchElementException;

import static java.util.concurrent.TimeUnit.SECONDS;

public class TelescopeSearchPeoplePage {

    WebDriver driver = SeleniumWebDriver.getInstance();

    @FindBy(xpath = "//div[@class='modal-dialog']//button[@class='close']")
    private WebElement whatIsNewInTelescopeCloseButton;

    @FindBy(xpath = "//div[text()='All Employees in Telescope']")
    private WebElement allEmployeeLink;

    @FindBy(xpath = "(//button[contains(@class,'stepRight')])[1]")
    private WebElement stepRightButton;

    @FindBy(xpath = "//span[contains(@class,'pageCount')]")
    private WebElement pageCountLabel;

    private String scroller = "//div[contains(@class,'ScrollPane__vthumb')]";

    private String personNameLabelList = "//div[contains(@class,'personName')]//div/a";

    private String personNameLabelListItem(int index) {
        return String.format("(//div[contains(@class,'personName')]//div/a)[%s]", index);
    }

    private String personNameLabel(String name) {
        return String.format("//div[contains(@class,'personName')]//div/a[text()='%s']", name);
    }

    private String cityCheckbox(String city) {
        return String.format("//div[contains(@id, 'city')]//label[contains(text(),'%s')]", city);
    }

    private String primarySkillCheckbox(String skill) {
        return String.format("//div[contains(@id, 'primarySkill')]//label[contains(text(),'%s')]", skill);
    }

    private String filteringByLabel(String filterBy) {
        return String.format("//span[@facet='%s']", filterBy);
    }

    private Wait<WebDriver> wait = new FluentWait<>(driver)
            .withTimeout(30, SECONDS)
            .pollingEvery(5, SECONDS)
            .ignoring(NoSuchElementException.class)
            .ignoring(StaleElementReferenceException.class);

    public TelescopeSearchPeoplePage() {
        PageFactory.initElements(driver, this);
    }

    public TelescopeSearchPeoplePage closeWhatIsNewInTelescopeDialog() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(whatIsNewInTelescopeCloseButton));
        element.click();
        return this;
    }

    public TelescopeSearchPeoplePage searchForAllEmployeesInTelescope() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(allEmployeeLink));
        element.click();
        return this;
    }

    public TelescopeSearchPeoplePage scrollToElement(WebElement element) {
        WebElement scrollerElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(scroller)));
        SeleniumUtil.scrollToElement(scrollerElement, element);
        wait.until(ExpectedConditions.visibilityOf(element));
        return this;
    }

    public TelescopeSearchPeoplePage searchForCitizens(String city) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(cityCheckbox(city))));
        if (!element.isDisplayed())
            scrollToElement(element);
        element.click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(filteringByLabel(city)))));
        return this;
    }

    public TelescopeSearchPeoplePage searchForPrimarySkill(String skill) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(primarySkillCheckbox(skill))));
        if (!element.isDisplayed())
            scrollToElement(element);
        element.click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(filteringByLabel(skill)))));
        return this;
    }

    public TelescopeSearchPeoplePage goToNextPage() {
        wait.until(ExpectedConditions.elementToBeClickable(stepRightButton)).click();
        return this;
    }

    public TelescopePersonProfilePage searchForPerson(String name) {
        int i = 1;
        doWhileLoop:
        do {
            List<WebElement> peopleList = wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath(personNameLabelList), 10));
            System.out.println("List Size = " + peopleList.size());
            for (int j = 1; j <= 10; j++) {
                String nameFromTheList = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(personNameLabelListItem(j)))).getText();
                System.out.println(nameFromTheList);
                if (nameFromTheList.equals(name)) {
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(personNameLabel(name)))).click();
                    break doWhileLoop;
                }
            }
            goToNextPage();
            i++;
            wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath(personNameLabelList))));
        }
        while (i <= Integer.valueOf(pageCountLabel.getText()));
        return new TelescopePersonProfilePage();
    }
}
