import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;


public class LoginLayout {

    private AndroidDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "platkovsky.alexey.epamtestapp:id/login_email")
    private MobileElement loginEmail;
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/login_pwd")
    private MobileElement loginPwd;
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/email_sign_in_button")
    private MobileElement signInButton;
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/register_button")
    private MobileElement registrationButton;


    public LoginLayout(AndroidDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10L)), this);
    }


    public Registration clickRegistrationButton(){
        wait.until(visibilityOf(registrationButton));
        registrationButton.click();
        return new Registration(driver, wait);
    }


    private LoginLayout typeEmail(String email){
        loginEmail.sendKeys(email);
        return this;
    }


    private LoginLayout typePassword(String password){
        loginPwd.sendKeys(password);
        return this;
    }


    public Expenses enterEmailAndPassword(String email, String password) {
        wait.until(visibilityOf(loginEmail));
        this.typeEmail(email);
        this.typePassword(password);
        signInButton.click();
        return new Expenses(driver, wait);
    }

}

