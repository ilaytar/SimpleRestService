package pages;

import org.openqa.selenium.WebDriver;
import webdriver.SeleniumWebDriver;

public class TelescopeSearchTasksPage {
    private WebDriver driver = SeleniumWebDriver.getInstance();
    private TelescopeGlobalMenu telescopeGlobalMenu = new TelescopeGlobalMenu();

    public TelescopeGlobalMenu goToTelescopeGlobalMenu() {
        return new TelescopeGlobalMenu();
    }
}
