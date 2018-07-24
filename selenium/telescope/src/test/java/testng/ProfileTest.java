package testng;

import org.testng.annotations.Test;
import pages.TelescopeSearchPeoplePage;

public class ProfileTest extends TestBase {
    @Test
    public void testEmployeePosition() throws InterruptedException {
        new TelescopeSearchPeoplePage()
                .searchForAllEmployeesInTelescope()
                .searchForCitizens("Lviv")
                .searchForPrimarySkill("Automated Testing")
                .searchForPerson("Iryna Laitar")
                .verifyJobTitle("Software Test Automation Engineer")
                .goToCompanyBox("EPAM Systems")
                .verifyProjectItemValue("Customer", "AerLingus");
    }
}
