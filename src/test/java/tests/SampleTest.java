package tests;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.DriverUtils;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Epic("Trust Wallet Feature")
@Feature("Create Wallet Flow")
public class SampleTest extends BaseTest {

    private AppiumDriver driver;
    List<String> pinSequence = Arrays.asList("1", "2", "3", "4", "5", "6");
    WebDriverWait wait ;


    // Define XPath variables
    private String createWalletButtonXpath = "//android.view.View[@resource-id=\'CreateNewWalletButton\']/android.widget.Button";
    private String pinXpathTemplate = "//android.widget.TextView[@text='%s']";
    private String confirmPinButtonXpath = "//android.view.ViewGroup/android.view.View/android.view.View/android.view.View[1]/android.widget.Button";
    private  String skipSetupXpath = "//android.widget.TextView[@resource-id=\"secondaryAction\"]";
    private String skipCryptoXpath = "//android.widget.TextView[@text=\"Skip, I'll do it later\"]";
    private String buyCryptoButtonXpath = "//android.view.View[@resource-id='buyCrypto']/android.widget.Button";
    private String mainBalanceXpath = "//android.widget.TextView[@resource-id='mainBalance']";
    private  String walletNameTool = "//android.widget.TextView[@resource-id=\"topBarWalletName\"]";
    private String walletFirstRow = "//android.view.View[@resource-id=\"walletRow\"][1]";
    private String walletSecondRow = "//android.view.View[@resource-id=\"walletRow\"][2]/*[@resource-id=\"textCellTitle\"]";
    private String addWallet = "//android.view.View[@resource-id=\"addWalletIconButton\"]/android.widget.Button";
    private String createNewWallet = "//android.widget.TextView[@text=\"Create new wallet\"]";
    private String sceretPhrase = "//android.view.View[@resource-id=\"secretPhraseCreateButton\"]/android.widget.Button";
    private String animation = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View";

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        driver = DriverUtils.initializeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test(description = "Verifies that create callet is successfully")
   public void createWalletAndLandingHomePageTest() {
       assert driver != null : "Driver initialization failed!";
       System.out.println("App launched successfully!");

       // Verify and click 'Create Wallet' button
       WebElement createWalletButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(createWalletButtonXpath)));
       Assert.assertTrue(createWalletButton.isDisplayed(), "'Create Wallet' button should be visible on launch.");
       createWalletButton.click();

       // Enter PIN sequence (1-6 twice)
       List<String> pinSequence = Arrays.asList("1", "2", "3", "4", "5", "6");
       enterPinSequence(pinSequence, pinXpathTemplate);
       enterPinSequence(pinSequence, pinXpathTemplate);

       // Confirm PIN
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath(confirmPinButtonXpath))).click();

       // Skip setup
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath(skipSetupXpath))).click();

       // Skip buy or deposit crypto
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath(skipCryptoXpath))).click();

       // Verify main balance
       WebElement mainBalanceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(mainBalanceXpath)));
       String mainBal = mainBalanceElement.getText();
       Assert.assertEquals(mainBal, "$0.00", "The main balance is not shown as expected: actual '" + mainBal + "'");
   }

    @Test(description = "Verifies that add multiple wallet is successfully")
    public void addWalletTest3() {
        assert driver != null : "Driver initialization failed!";
        System.out.println("App launched successfully!");

        // Verify and click 'Create Wallet' button
        WebElement createWalletButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(createWalletButtonXpath)));
        Assert.assertTrue(createWalletButton.isDisplayed(), "'Create Wallet' button should be visible on launch.");
        createWalletButton.click();

        // Enter PIN sequence (1-6 twice)
        enterPinSequence(pinSequence, pinXpathTemplate);
        enterPinSequence(pinSequence, pinXpathTemplate);

        // Confirm PIN
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(confirmPinButtonXpath))).click();

        // Skip setup
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(skipSetupXpath))).click();

        // Skip buy or deposit crypto
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(skipCryptoXpath))).click();

        // Verify main balance
        WebElement mainBalanceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(mainBalanceXpath)));
        String mainBal = mainBalanceElement.getText();
        Assert.assertEquals(mainBal, "$0.00", "The main balance is not shown as expected: actual '" + mainBal + "'");

        // clieck on wallet
        String walletMain =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(walletNameTool))).getText();
        Assert.assertEquals(walletMain, "Main Wallet 1", "The main wallet name is not shown as expected: actual '" + walletMain + "'");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(walletNameTool))).click();

        String walletRow =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(walletFirstRow))).getText();
        Assert.assertEquals(walletMain, "Main Wallet 1", "The main wallet first row is not shown as expected: actual '" + walletRow + "'");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(addWallet))).click();

        String createNewWalletText =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(createNewWallet))).getText();
        Assert.assertEquals(createNewWalletText, "Create new wallet", "The create new wallet text is not shown as expected: actual '" + createNewWalletText + "'");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(createNewWallet))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(sceretPhrase))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(animation))).click();

        // Skip buy or deposit crypto
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(skipCryptoXpath))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(walletNameTool))).click();

        walletRow =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(walletSecondRow))).getText();
        Assert.assertEquals(walletRow, "Main Wallet 2", "The main wallet second row is not shown as expected: actual '" + walletRow + "'");

    }

    private void enterPinSequence(List<String> pinSequence, String pinXpathTemplate) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        for (String digit : pinSequence) {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(pinXpathTemplate, digit)))).click();
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}