package testng;

import org.testng.annotations.Test;
import pages.TelescopeSearchPeoplePage;

public class ChangeLandingPageTest extends TestBase {
    @Test
    void testChangeLandingPageDialogWindow() {
        new TelescopeSearchPeoplePage()
                .goToTelescopeGlobalMenu()
                .goToTelescopeSearchTasksPage()
                .goToTelescopeGlobalMenu()
                .pin()
                .acceptChangeLandingPageDialogWindow()
                .validateLandingPageInTelescopeIs("Tasks")
                .goToTelescopeSearchPeoplePage()
                .goToTelescopeGlobalMenu()
                .pin()
                .acceptChangeLandingPageDialogWindow()
                .validateLandingPageInTelescopeIs("People")
                .pin()
                .goToTelescopeSearchTasksPage()
                .goToTelescopeGlobalMenu()
                .pin()
                .cancelChangeLandingPageDialogWindow();
    }
}
