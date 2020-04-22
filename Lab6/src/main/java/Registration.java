import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;


public class Registration {

    private static AndroidDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "platkovsky.alexey.epamtestapp:id/registration_email")
    private MobileElement emailFild;
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/registration_username")
    private MobileElement usernameFild;
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/registration_password")
    private MobileElement passwordFild;
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/registration_confirm_password")
    private MobileElement confirmPasswordFild;
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/register_new_account_button")
    private MobileElement finishButton;


    public Registration (AndroidDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10L)), this);
    }


    private Registration typeEmail(String email){
        emailFild.sendKeys(email);
        return this;
    }


    private Registration typeUsername(String username){
        usernameFild.sendKeys(username);
        return this;
    }


    private Registration typePassword(String password){
        passwordFild.sendKeys(password);
        return this;
    }


    private Registration typeConfirmPassword(String password){
        confirmPasswordFild.sendKeys(password);
        return this;
    }


    public LoginLayout registerNewAccount(String email, String username, String password) {
        wait.until(visibilityOf(emailFild));
        this.typeEmail(email);
        this.typeUsername(username);
        this.typePassword(password);
        this.typeConfirmPassword(password);
        finishButton.click();
        return new LoginLayout(driver, wait);
    }

}

