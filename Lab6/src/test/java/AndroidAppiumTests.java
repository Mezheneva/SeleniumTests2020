import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.*;
import java.util.concurrent.TimeUnit;

public class AndroidAppiumTests {

    private static AndroidDriverManager driverManager;
    static AndroidDriver driver;
    static WebDriverWait wait;
    private LoginLayout loginLayout;

    private static String username = "irm98";
    private static String email = "irm98@mail.ru";
    private static String password = "12345qtchewq";
    private static String title = "Cat food";
    private static String sum = "379";
    private static String date = "22/04/2020";
    private static String category = "pets";


    @BeforeClass
    public static void prepareTest() {

        driverManager = new AndroidDriverManager();
        driver = driverManager.getDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10, 1000);

    }


    @Before
    public void initPageObject() {
        loginLayout = new LoginLayout(driver, wait);
    }


    @Test
    public void registrationTest() {
        Registration registration = loginLayout.clickRegistrationButton();
        registration.registerNewAccount(email, username, password);
    }


    @Test
    public void loginTest() {
        Registration registration = loginLayout.clickRegistrationButton();
        loginLayout = registration.registerNewAccount(email, username, password);

        loginLayout.enterEmailAndPassword(email, password);
    }


    @Test
    public void expensesTest(){
        Registration registration = loginLayout.clickRegistrationButton();
        loginLayout = registration.registerNewAccount(email, username, password);

        Expenses expenses = loginLayout.enterEmailAndPassword(email, password);

        expenses.addExpense(title ,sum, date, category);
    }


    @After
    public void stopApp() {
        driver.closeApp();
    }


    @AfterClass
    public static void quit() {
        driverManager.quitDriver();
    }

}

