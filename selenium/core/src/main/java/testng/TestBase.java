package testng;

import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.reporters.Files;
import util.ReadPropertiesUtil;
import webdriver.SeleniumWebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import static util.EncodeDecodeUtil.decode;
import static util.ReadPropertiesUtil.getProperty;

public class TestBase {

    @BeforeClass
    public static void init() {
        WebDriver driver = SeleniumWebDriver.getInstance();
        driver.get(ReadPropertiesUtil.getProperty("site"));
        String username = getProperty("username");
        String password = decode(getProperty("password"));
//        driver.navigate().to(String.format("https://%s:%s@telescope.epam.com", username, password));
        driver.switchTo().alert().sendKeys(username + Keys.TAB + password);
        driver.switchTo().alert().accept();
    }

    @AfterClass
    public static void stopDriver() {
        SeleniumWebDriver.close();
    }

    @AfterMethod
    public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            File scrFile = ((TakesScreenshot) SeleniumWebDriver.getInstance()).getScreenshotAs(OutputType.FILE);
            Files.copyFile(new FileInputStream(scrFile), new File("errorScreenshots\\" + testResult.getName() + "-"
                    + Arrays.toString(testResult.getParameters()) + ".jpg"));
        }
    }
}
