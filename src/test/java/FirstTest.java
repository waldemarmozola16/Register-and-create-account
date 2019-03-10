import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FirstTest {
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/waldemar/Pobrane/FirstTest/src/test/java/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");


    }

    @Test
    public void userRegistrationWithValidData() throws InterruptedException {
        driver.findElement(By.cssSelector("[title=\"Log in to your customer account\"]")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("email_create")).sendKeys("testowy1email@testowy.com");
        driver.findElement(By.id("SubmitCreate")).click();
        Thread.sleep(5000);

        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.id("customer_firstname")).sendKeys("RandomowyPan2");
        driver.findElement(By.id("customer_lastname")).sendKeys("RandomoweNazwisko2");
        driver.findElement(By.id("submitAccount")).click();
        Thread.sleep(5000);

        boolean isAlertDisplayed = driver.findElement(By.className("alert")).isDisplayed();

        Assert.assertTrue(isAlertDisplayed);
    }

    @After
    public void TearDown() {
        driver.quit();
    }
}
