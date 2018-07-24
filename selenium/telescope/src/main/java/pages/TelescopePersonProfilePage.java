package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.SeleniumUtil;
import webdriver.SeleniumWebDriver;

import static verificator.Verificator.verifyThatElementDisplayedTextIs;

public class TelescopePersonProfilePage {
    private WebDriver driver = SeleniumWebDriver.getInstance();

    @FindBy(xpath = "//div[contains(@class,'jobTitle')]")
    private WebElement jobTitleLabel;

    private String companyLink(String company) {
        return String.format("//div[contains(@class, 'PastProjectBox')]/a[text()='%s']", company);
    }

    private String projectItemValue(String projectItem) {
        return String.format("//table[contains(@class, 'ProjectItem')]//td[text()='%s']//following-sibling::td", projectItem);
    }

    public TelescopePersonProfilePage() {
        PageFactory.initElements(SeleniumWebDriver.getInstance(), this);
    }

    public TelescopePersonProfilePage goToCompanyBox(String company) {
        WebElement companyLink = driver.findElement(By.xpath(companyLink(company)));
        SeleniumUtil.scrollPageToElement(companyLink);
        return this;
    }

    public TelescopePersonProfilePage verifyJobTitle(String expectedJobTitle) {
        verifyThatElementDisplayedTextIs(jobTitleLabel, expectedJobTitle);
        return this;
    }

    public TelescopePersonProfilePage verifyProjectItemValue(String projectItem, String expectedValue) {
        WebElement projectItemValue = driver.findElement(By.xpath(projectItemValue(projectItem)));
        verifyThatElementDisplayedTextIs(projectItemValue, expectedValue);
        return this;
    }

}
