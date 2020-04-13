
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class SignUpPage {

    WebDriver driver;
    private WebDriverWait wait;

    public SignUpPage(WebDriver driver, WebDriverWait wait) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = wait;

        if (!"Join GitHub · GitHub".equals(driver.getTitle())) {
            throw new IllegalStateException(driver.getTitle());
        }
    }

    @FindBy(xpath = "//h1[contains(@class,'d-none d-md-block mt-0 mb-3 text-center h00-mktg lh-condensed-ultra')] ")
    private WebElement heading;
    @FindBy(xpath = ".//*[@id='user_login']")
    private WebElement userNameField;
    @FindBy(xpath = ".//*[@id='user_email']")
    private WebElement emailField;
    @FindBy(xpath = ".//*[@id='user_password']")
    private WebElement passwordField;
    @FindBy(xpath = "/html[1]/body[1]/div[4]/main[1]/div[1]/div[2]/div[1]/form[1]/div[2]")
    private WebElement signUpButton;
    @FindBy(xpath = "//form[@id='signup-form']")
    private WebElement signUpForm;

    private By emailError = By.xpath("/html[1]/body[1]/div[4]/main[1]/div[1]/div[2]/div[1]/form[1]/auto-check[2]/dl[1]/dd[2]");
    private By userNameError = By.xpath("//div[contains(@class,'mb-1')]");

    private SignUpPage typeUserName(String username) {
        userNameField.sendKeys(username);
        return this;
    }

    private SignUpPage typePassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    private SignUpPage typeEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    public SignUpPage registerWithInvalidCreds(String username, String email, String password) {
        wait.until(visibilityOf(signUpForm));
        this.typeUserName(username);
        this.typeEmail(email);
        this.typePassword(password);
        return new SignUpPage(driver, wait);
    }

    public String getHeadingText() {
        wait.until(visibilityOf(heading));
        return heading.getText();
    }


    public String getUsernameErrorText() {
        WebElement error = wait.until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver d) {
                return d.findElement(userNameError);
            }});
        return error.getText();
    }



    public String getEmailErrorText(){
        WebElement error = wait.until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver d) {
                return d.findElement(emailError);
            }});
        return error.getText();
    }

}