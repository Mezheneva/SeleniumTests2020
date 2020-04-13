import org.junit.Test;
import org.junit.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class FT {

    final String word = "shikimori";
    final String el = "shikimori.one";

    @Test
    public void SimpleTest() {
        WebDriver driver = MainClass.firefoxBrowser();
        WebElement elem = MainClass.googleFind(driver, word);
        Assert.assertEquals(elem.getText(), el);

        driver.close();
    }
}

