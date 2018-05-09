package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webdriver.SeleniumWebDriver;

public class LoginPage {
    @FindBy(xpath = "//input[@id='userNameInput']")
    private WebElement usernameInput;

    @FindBy(xpath = "//input[@id='passwordInput']")
    private WebElement passwordInput;

    @FindBy(xpath = "//span[@id='submitButton']")
    private WebElement submitButton;

    public LoginPage() {
        PageFactory.initElements(SeleniumWebDriver.getInstance(), this);
    }

    public TelescopeSearchPeoplePage login(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        submitButton.click();
        return new TelescopeSearchPeoplePage();
    }


}
