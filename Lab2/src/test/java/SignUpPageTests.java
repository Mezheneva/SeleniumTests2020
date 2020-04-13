import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SignUpPageTests {


    private WebDriver driver;
    private WebDriverWait wait;
    private SignUpPage signUpPage;


    @Before
    public void setUp(){
        System.setProperty("webdriver.gecko.driver", "C:\\\\geckodriver.exe");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10, 1000);
        driver.get("https://github.com/join?source_repo=ahmedfgad%2FCoinTex");
        signUpPage = new SignUpPage(driver, wait);
    }


    @Test
    @Category(SmokeTest.class)
    public void SignUpPageTest() {
        String heading = signUpPage.getHeadingText();
        Assert.assertEquals("Create your account", heading);
    }


    @Test
    public void signUpInvalidEmailTest() {
        signUpPage = signUpPage.registerWithInvalidCreds("testusername", "testemail", "testpassword");
        String error = signUpPage.getEmailErrorText();
        Assert.assertEquals("Email is invalid or already taken", error);
    }


    @Test
    public void signUpInvalidUserNameTest() {
        signUpPage = signUpPage.registerWithInvalidCreds("testusername", "testemail", "testpassword");
        String error = signUpPage.getUsernameErrorText();
        Assert.assertEquals("Username testusername is not available.", error);
    }


    @After
    public void tearDown(){
        driver.quit();
    }
}
