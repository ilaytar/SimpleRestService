package testng;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.reporters.Files;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import util.ReadPropertiesUtil;
import webdriver.SeleniumWebDriver;

public class TestBase {

    @BeforeClass
    public static void init() {
        WebDriver driver = SeleniumWebDriver.getInstance();
        driver.get(ReadPropertiesUtil.getProperty("site"));
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
