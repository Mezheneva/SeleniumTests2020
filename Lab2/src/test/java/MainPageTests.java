import org.junit.*;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainPageTests {


    private WebDriver driver;
    private WebDriverWait wait;
    private MainPage mainPage;


    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\\\geckodriver.exe");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10, 1000);
        driver.get("http://github.com");
        mainPage = new MainPage(driver, wait);
    }


    @Test
    @Category(SmokeTest.class)
    public void MainPageTest() {
        String heading = mainPage.getHeadingText();
        Assert.assertEquals("Built for developers", heading);
    }


    @Test
    public void signInButtonTest() {
        SignInPage signInPage = mainPage.clickSignIn();
        String heading = signInPage.getHeadingText();
        Assert.assertEquals("Sign in to GitHub", heading);
    }


    @Test
    public void signUpButtonTest() {
        SignUpPage signUpPage = mainPage.clickSignUpButton();

        String heading = signUpPage.getHeadingText();
        Assert.assertEquals("Create your account", heading);
    }


    @After
    public void tearDown() {
        driver.quit();
    }
}
