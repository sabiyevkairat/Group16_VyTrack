package com.vytrack.tests.kai;

import com.vytrack.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TS16_102 {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDownMethod() {
        driver.quit();
    }

    @Test
    public void testOroDocumentationLink() {

        // nagivate to "https://qa1.vytrack.com/user/login"
        driver.get("https://qa1.vytrack.com/user/login");

        // login as user
        WebElement usernameBox = driver.findElement(By.xpath("//input[@id = 'prependedInput']"));
        usernameBox.sendKeys("user12");

        WebElement passwordBox = driver.findElement(By.xpath("//input[@id = 'prependedInput2']"));
        passwordBox.sendKeys("UserUser123");

        // click submit button
        WebElement loginButton = driver.findElement(By.id("_submit"));
        loginButton.click();

        // save window handle
        String originalWindow = driver.getWindowHandle();

        // Locate Oroinc Documentation button
        WebElement oroButton = driver.findElement(By.xpath("//a[contains(@href, 'oroinc')]"));
        oroButton.click();

        // switch window handle
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.equals(windowHandle)) {
                driver.switchTo().window(windowHandle);
            }
        }

        // verify page url is "https://doc.oroinc.com/"
        String expectedUrl = "https://doc.oroinc.com/";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl, expectedUrl);

    }

}
