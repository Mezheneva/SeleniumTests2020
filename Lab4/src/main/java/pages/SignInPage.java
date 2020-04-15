package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;


public class SignInPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public SignInPage(WebDriver driver, WebDriverWait wait) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = wait;

        if (!"Sign in to GitHub · GitHub".equals(driver.getTitle())) {
            throw new IllegalStateException(driver.getTitle());
        }
    }

    @FindBy(xpath = ".//*[@id='login_field']")
    private WebElement loginField;
    @FindBy(xpath = ".//*[@id='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//input[@name='commit']")
    private WebElement signInButton;
    @FindBy(xpath = "//div[@class='auth-form-header p-0']")
    private WebElement heading;
    @FindBy(xpath = "//div[contains(@class,'flash flash-full flash-error')]")
    private WebElement error ;
    @FindBy(xpath = "//a[contains(text(),'Create an account')]")
    private WebElement createAccLink;
    @FindBy(xpath = "//div[@class='auth-form-body mt-3']")
    private WebElement SignInForm;


    public SignInPage typeUsername(String username){
        loginField.sendKeys(username);
        return this;
    }


    public SignInPage typePassword(String password){
        passwordField.sendKeys(password);
        return this;
    }


    public SignInPage loginWithInvalidCreds(String username, String password){
        wait.until(visibilityOf(SignInForm));
        this.typeUsername(username);
        this.typePassword(password);
        signInButton.click();
        return new SignInPage(driver, wait);
    }


    public String getHeadingText(){
        wait.until(visibilityOf(heading));
        return heading.getText();
    }


    public String getErrorText(){
        wait.until(visibilityOf(error));
        return error.getText();
    }


    public SignUpPage createAccount(){
        wait.until(visibilityOf(createAccLink));
        createAccLink.click();
        return new SignUpPage(driver, wait);
    }

}

