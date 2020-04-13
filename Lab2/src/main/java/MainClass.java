import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainClass {

    static WebDriver driver;
    static WebDriverWait wait;

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\\\geckodriver.exe");

        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);

        driver.get("https://github.com/");

        MainPage mainPage = new MainPage(driver, wait);

        mainPage.register("testusername", "testemail@test.com", "testpassword");

        driver.quit();
    }
}
