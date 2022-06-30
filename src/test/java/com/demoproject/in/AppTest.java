package com.demoproject.in;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void openHomePage() throws InterruptedException
    {
        System.setProperty("webdriver.edge.driver", "E:/work/demoproject/msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Iphone 12");
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.ENTER);
        By iphone  = (By.xpath("//*[@id='container']/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[2]/div[1]/div[1]"));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(iphone));
        driver.findElement(iphone).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'ADD TO CART')]")));
        driver.findElement(By.xpath("//button[contains(text(),'ADD TO CART')]")).click();
        Boolean check = driver.findElement(By.xpath("//a[contains(text(),'APPLE iPhone 12 (Black, 128 GB)')]")).isDisplayed();
        Assert.assertEquals(check, true, "Iphone added");
    }
}