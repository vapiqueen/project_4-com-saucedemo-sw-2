package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com/";


    @Before
    public void setUp() {
        openBrowser(baseUrl);

    }

    @Test
    public void verifyUserShouldLoginSuccessfullyWithValidCredentials() {

//Enter the Username in Username field
        //enter username and password
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String expected = "Products";
        String actual = driver.findElement(By.xpath("//span[text() = 'Products']")).getText();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        //enter username and password
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        List<WebElement> products = driver.findElements(By.xpath("//div[@class = 'inventory_item']"));
        int expected = 6;
        int actual = products.size();
        Assert.assertEquals(expected, actual);
    }

    @After
    public void tearDown() {
        closeBrowser();


    }
}
