package com.trycloud.tests.base;

import com.trycloud.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        //1. Open browser
        driver = WebDriverFactory.getDriver("chrome");

        //2. Go to website: http://practice.cybertekschool.com/javascript_alerts
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

@Test
    public void login() throws IOException {


        Properties properties = new Properties();

        String path = "configuration.properties";
        FileInputStream file = new FileInputStream(path);

        properties.load(file);

        String url = properties.getProperty("webOrderUrl");
        driver.get(url);
    WebElement username = driver.findElement(By.xpath("//input[@id='user']"));
    username.sendKeys("User5");
    WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
    password.sendKeys("Userpass123");
    WebElement logIN = driver.findElement(By.xpath("//input[@id='submit-form']"));
    logIN.click();


    }

}
