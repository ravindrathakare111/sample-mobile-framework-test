package utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverUtils {
    private static AppiumDriver driver;

    public static AppiumDriver initializeDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "RavindraOnePlus11");
        capabilities.setCapability("automationName", "UiAutomator2");
        String projectFolder = System.getProperty("user.dir");
        System.out.println("Current project folder: " + projectFolder);
        capabilities.setCapability("app", projectFolder+"\\src\\apps\\android\\trustWallet.apk");
        capabilities.setCapability("ignoreHiddenApiPolicyError", true);
        capabilities.setCapability("noReset", false);

        driver = new AppiumDriver(new URL("http://127.0.0.1:4725/wd/hub"), capabilities);
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
