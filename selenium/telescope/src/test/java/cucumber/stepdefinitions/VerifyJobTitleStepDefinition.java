package cucumber.stepdefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.TelescopePersonProfilePage;
import pages.TelescopeSearchPeoplePage;
import webdriver.SeleniumWebDriver;

import static util.EncodeDecodeUtil.decode;
import static util.ReadPropertiesUtil.getProperty;
import static webdriver.SeleniumWebDriver.close;

public class VerifyJobTitleStepDefinition {

    private WebDriver driver;

    private TelescopeSearchPeoplePage searchPeoplePage;
    private TelescopePersonProfilePage personProfilePage;

    @Before
    public void before() {
        driver = SeleniumWebDriver.getInstance();

        driver.navigate().to(getProperty("site"));
    }

    @Given("User logs in")
    public void login() {
       searchPeoplePage = new LoginPage().login(getProperty("username"), decode(getProperty("password")));
    }

    @When("User closes What is new in Telescope dialog")
    public void closeWhatIsNewInTelescopeDialog() {
        searchPeoplePage.closeWhatIsNewInTelescopeDialog();
    }

    @And("User navigates to All Employees in Telescope")
    public void navigateToAllEmployeesList(){
        searchPeoplePage.searchForAllEmployeesInTelescope();
    }

    @And("User filters employees by city '(.*?)'")
    public void filterByCity(String city) {
        searchPeoplePage.searchForCitizens(city);
    }

    @And("User filters employees by primary skill '(.*?)'")
    public void filterPrimarySkill(String primarySkill) {
        searchPeoplePage.searchForPrimarySkill(primarySkill);
    }

    @And("User goes through pages to find '(.*?)' in the list of employees")
    public void findEmployee(String employeeName) {
        personProfilePage = searchPeoplePage.searchForPerson(employeeName);
    }

    @Then("Then User verifies Job Title of employee is '(.*?)'")
    public void verifyJobTitle(String jobTitle) {
        personProfilePage.verifyJobTitle(jobTitle);
    }

    @After
    public void after() {
        close();
    }
}