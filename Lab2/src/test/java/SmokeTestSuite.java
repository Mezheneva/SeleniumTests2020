import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory(SmokeTest.class)
@Suite.SuiteClasses({MainPageTests.class, SignInPageTests.class, SignUpPageTests.class})

public class SmokeTestSuite {
}
