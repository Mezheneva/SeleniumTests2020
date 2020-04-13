import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainClass {

public static WebDriver firefoxBrowser()
{
    System.setProperty("webdriver.gecko.driver", "C:\\\\geckodriver.exe");
    WebDriver driver = new FirefoxDriver();
    return driver;
}


public static WebElement googleFind(WebDriver driver, final String word)
{
    driver.get("http://www.google.com");

    WebElement element = driver.findElement(By.name("q"));
    element.sendKeys(word);
    element.submit();

    (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
        public Boolean apply(WebDriver d) {
            return d.getTitle().toLowerCase().startsWith(word);
        }
    });

    WebElement elem = driver.findElement(By.xpath("//div[@class='g']//div//div[@class='rc']//div[@class='TbwUpd NJjxre']"));

    return elem;
}


    public static void main(String[] args) {
        System.out.print(" ");
    }

}

