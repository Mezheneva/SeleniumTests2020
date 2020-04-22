import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;


public class Expenses {

    private AndroidDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "platkovsky.alexey.epamtestapp:id/add_new_expense")
    private MobileElement addExpenseButton;
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/new_expense_title_edit")
    private MobileElement expenseTitleFild;
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/new_expense_sum_edit")
    private MobileElement expenseSumFild;
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/new_expense_date_edit")
    private MobileElement expenseDateFild;
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/new_expense_category_picker")
    private MobileElement expenseCategoryFild;
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/save_new_expense")
    private MobileElement saveExpenseButton;


    public Expenses(AndroidDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10L)), this);
    }


    private Expenses typeExpenseTitle(String title){
        expenseTitleFild.sendKeys(title);
        return this;
    }


    private Expenses typeExpenseSum(String sum){
        expenseSumFild.sendKeys(sum);
        return this;
    }


    private Expenses typeExpenseDate(String date){
        expenseDateFild.sendKeys(date);
        return this;
    }


    private Expenses typeExpenseCategory(String category){
        expenseCategoryFild.sendKeys(category);
        return this;
    }


    public void addExpense(String title, String sum, String date, String category) {
        wait.until(visibilityOf(addExpenseButton));
        addExpenseButton.click();

        wait.until(visibilityOf(expenseTitleFild));
        this.typeExpenseTitle(title);
        this.typeExpenseSum(sum);
        this.typeExpenseDate(date);
        this.typeExpenseCategory(category);
        saveExpenseButton.click();
        wait.until(visibilityOf(addExpenseButton));
    }

}

