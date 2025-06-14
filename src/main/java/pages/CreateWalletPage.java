package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.DriverUtils;

import java.time.Duration;

public class CreateWalletPage {

    @AndroidFindBy(id = "com.wallet.crypto.trustapp:id/create_wallet_button")
    @iOSXCUITFindBy(accessibility = "Create Wallet")
    private WebElement createWalletBtn;

    @AndroidFindBy(id = "com.wallet.crypto.trustapp:id/accept_terms_checkbox")
    @iOSXCUITFindBy(accessibility = "Accept Terms")
    private WebElement termsCheckbox;

    @AndroidFindBy(id = "com.wallet.crypto.trustapp:id/continue_button")
    @iOSXCUITFindBy(accessibility = "Continue")
    private WebElement continueBtn;

    public CreateWalletPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    public void tapCreateWallet() {
        createWalletBtn.click();
    }

    public void acceptTermsAndContinue() {
        termsCheckbox.click();
        continueBtn.click();
    }
}
