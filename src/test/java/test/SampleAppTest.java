package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleAppTest {
    @Test
    public void fillRegistrationSipleTest() throws InterruptedException {
        System.setProperty("webdriver.crome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.uitestingplayground.com/sampleapp");
        driver.findElement(By.name("UserName")).sendKeys("qwrqw");
        driver.findElement(By.name("Password")).sendKeys("pwd");
        driver.findElement(By.id("login")).click();

        String expectedResultLogin = "Welcome, qwrqw!";
        String actualResultLogin = driver.findElement(By.id("loginstatus")).getText();

        Assert.assertEquals(expectedResultLogin,actualResultLogin);

        Thread.sleep(3000);

        driver.findElement(By.id("login")).click();
        String expectedResultLogOut ="User logged out.";
        String actualResultLogOut = driver.findElement(By.id("loginstatus")).getText();

        Assert.assertEquals(expectedResultLogOut, actualResultLogOut);

        Thread.sleep(3000);

        driver.quit();


    }
}
