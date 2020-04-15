package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;


public class MainPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public MainPage(WebDriver driver, WebDriverWait wait) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = wait;

        if (!"The world’s leading software development platform · GitHub".equals(driver.getTitle())) {
            throw new IllegalStateException(driver.getTitle());
        }
    }

    @FindBy(xpath = "//a[@class='HeaderMenu-link no-underline mr-3']")
    private WebElement signInButton;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/header[1]/div[1]/div[2]/div[2]/a[2]")
    private WebElement signUpButton;
    @FindBy(xpath = ".//*[@id='user[login]']")
    private WebElement userNameField;
    @FindBy(xpath = ".//*[@id='user[email]']")
    private WebElement emailField;
    @FindBy(xpath = ".//*[@id='user[password]']")
    private WebElement passwordField;
    @FindBy(xpath = "/html[1]/body[1]/div[4]/main[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/button[1]")
    private WebElement signUpForGitHubButton;
    @FindBy(xpath = "//div[@class='rounded-1 text-gray bg-gray-light py-4 px-4 px-md-3 px-lg-4']")
    private WebElement signUpForm;

    @FindBy(xpath = "//div[@class='d-md-flex flex-items-center gutter-md-spacious']")
    private WebElement mainForm;
    @FindBy(xpath = "//h1[@class='h000-mktg text-white lh-condensed-ultra mb-3']")
    private WebElement mainFormText;


    public String getHeadingText(){
        wait.until(visibilityOf(mainForm));
        return mainFormText.getText();
    }

    public SignInPage clickSignIn(){
        wait.until(visibilityOf(signInButton));
        signInButton.click();
        return new SignInPage(driver, wait);
    }

    public SignUpPage clickSignUpButton(){
        wait.until(visibilityOf(signUpButton));
        signUpButton.click();
        return new SignUpPage(driver, wait);
    }


    public MainPage typeUserName(String username){
        userNameField.sendKeys(username);
        return this;
    }

    public MainPage typePassword(String password){
        passwordField.sendKeys(password);
        return this;
    }

    public MainPage typeEmail(String email){
        emailField.sendKeys(email);
        return this;
    }


    public SignUpPage clickSignUpForGitHubButton(){
        signUpForGitHubButton.click();
        return new SignUpPage(driver, wait);
    }


    public SignUpPage register(String username, String email, String password){
        wait.until(visibilityOf(signUpForm));
        this.typeUserName(username);
        this.typeEmail(email);
        this.typePassword(password);
        this.clickSignUpForGitHubButton();
        return new SignUpPage(driver, wait);
    }


}

