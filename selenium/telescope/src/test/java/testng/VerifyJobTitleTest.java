package testng;

import org.testng.annotations.Test;
import pages.LoginPage;

import static util.EncodeDecodeUtil.decode;
import static util.ReadPropertiesUtil.getProperty;

public class VerifyJobTitleTest extends TestBase {
    @Test
    public void testEmployeePosition() throws InterruptedException {

        new LoginPage()
                .login(getProperty("username"), decode(getProperty("password")))
                .closeWhatIsNewInTelescopeDialog()
                .searchForAllEmployeesInTelescope()
                .searchForCitizens("Lviv")
                .searchForPrimarySkill("Automated Testing")
                .searchForPerson("Iryna Laitar")
                .verifyJobTitle("Software Test Automation Engineer");
    }
}
