package steps;



import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.*;


public class PagesTestsDefinition {

    private WebDriver driver;
    private WebDriverWait wait;

    private MainPage mainPage;
    private SignInPage signInPage;
    private SignUpPage signUpPage;


    @Given("^Open browser$")
    public void user_opened_browser() {
        System.setProperty("webdriver.gecko.driver", "C:\\\\geckodriver.exe");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10, 1000);
    }


    @Given("^Open main page$")
    public void open_main_page(){
        driver.get("http://github.com");
        mainPage = new MainPage(driver, wait);
    }


    @Given("^Open Sign In page$")
    public void open_sign_in_page(){
        driver.get("https://github.com/login?return_to=%2Fjoin%3Fsource%3Dheader-home");
        signInPage = new SignInPage(driver, wait);
    }


    @Given("^Open Sign Up page$")
    public void open_sign_up_page(){
        driver.get("https://github.com/join?source_repo=ahmedfgad%2FCoinTex");
        signUpPage = new SignUpPage(driver, wait);
    }


    @When("^Click Sign In button$")
    public void click_Sign_In_button(){
        signInPage = mainPage.clickSignIn();
    }

    @When("^Click Sign Up button$")
    public void click_Sign_Un_button(){
        signUpPage = mainPage.clickSignUpButton();
    }

    @When("^Sign In with invalid creds$")
    public void sign_In_with_invalid_creds(){
        signInPage.loginWithInvalidCreds("testusername","testpassword");
    }

    @Then("^get error message$")
    public void get_error_message() {
        String error = signInPage.getErrorText();
        Assert.assertEquals("Incorrect username or password.", error);
    }

    @When("^Click Create acc callout$")
    public void signInCreateAccCallout(){
        signUpPage = signInPage.createAccount();
    }


    @When("^enters \"([^\"]*)\" as email$")
    public void signUpWithEnterEmail(String email) {
        signUpPage.typeEmail(email);
    }

    @And("^enters \"([^\"]*)\" as name$")
    public void signUpWithEnterName(String name) {
        signUpPage.typeUserName(name);
    }


    @Then("^get error email message$")
    public void get_error_email_message() {
        String error = signUpPage.getEmailErrorText();
        Assert.assertEquals("Email is invalid or already taken", error);
    }

    @And("^get error name message$")
    public void get_error_name_message() {
        String error = signUpPage.getUsernameErrorText();
        Assert.assertEquals("Username testusername is not available.", error);
    }

    @When("^Closing browser$")
    public void closing_browser() {
        if (driver != null) {
            driver.quit();
        }
    }

}
