package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HerokuAppTest {
    @Test
    public void fillRegstarationHerokuTest() throws InterruptedException {
        System.setProperty("webdriver.crome.driver","src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//*[@id=\"login\"]/button")).click();

        String expectedResult = "Welcome to the Secure Area. When you are done click logout below.";
        String actualResult = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h4")).getText();

        Assert.assertEquals(expectedResult,actualResult);
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/a")).click();

        driver.quit();

    }
}