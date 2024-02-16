package mytest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Project1 {
    WebDriver webdriver;

    @BeforeMethod
    public void setup()
    {
        System.out.println("Launching browser");
        WebDriverManager.edgedriver().setup();
        webdriver= new EdgeDriver();
        webdriver.manage().window().maximize();
        webdriver.get("https://www.amazon.in/");

        webdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @Test
    public void VerifyingTitle()
    {
        String actualTitle = webdriver.getTitle();
        String expectedTitle ="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
        Assert.assertEquals(actualTitle, expectedTitle);
    }
    @Test
    public void VerifyLogo()
    {
        boolean flag = webdriver.findElement(By.xpath("//a[@id='nav-logo-sprites']")).isDisplayed();
        Assert.assertTrue(flag);

    }
    @AfterMethod
    public void teardown()
    {
        webdriver.quit();

    }
}