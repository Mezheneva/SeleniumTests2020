import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SignInPageTests{


    private WebDriver driver;
    private WebDriverWait wait;
    private SignInPage signInPage;


    @Before
    public void setUp(){
        System.setProperty("webdriver.gecko.driver", "C:\\\\geckodriver.exe");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10, 1000);
        driver.get("https://github.com/login?return_to=%2Fjoin%3Fsource%3Dheader-home");
        signInPage = new SignInPage(driver, wait);
    }


    @Test
    @Category(SmokeTest.class)
    public void SignInPageTest(){
        String heading = signInPage.getHeadingText();
        Assert.assertEquals("Sign in to GitHub", heading);
    }


    @Test
    public void signInCreateAccCalloutTest(){
        SignUpPage signUpPage = signInPage.createAccount();

        String heading = signUpPage.getHeadingText();
        Assert.assertEquals("Create your account", heading);
    }


    @Test
    public void signInWithInvalidCredsTest(){
        signInPage.loginWithInvalidCreds("testusername","testpassword");

        String error = signInPage.getErrorText();
        Assert.assertEquals("Incorrect username or password.", error);
    }


    @After
    public void tearDown(){
        driver.quit();
    }
}
