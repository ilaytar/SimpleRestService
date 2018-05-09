package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webdriver.SeleniumWebDriver;

import static verificator.Verificator.*;

public class TelescopePersonProfilePage {

    @FindBy(xpath = "//div[contains(@class,'jobTitle')]")
    private WebElement jobTitleLabel;

    public void verifyJobTitle(String expectedJobTitle) {
        verifyThatElementDisplayedTextIs(jobTitleLabel, expectedJobTitle);
    }

    public TelescopePersonProfilePage() {
        PageFactory.initElements(SeleniumWebDriver.getInstance(), this);
    }

}
