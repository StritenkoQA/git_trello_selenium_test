package com.marinaS.trello;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    WebDriver wd;
    @BeforeClass
    public void setUp(){
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.get("https://trello.com/");
    }

    @Test
    public void testLogin(){
        //clikLogin
        clickLoginLink();
    }
    public void clickLoginLink(){
        wd.findElement(By.cssSelector("[href='/login']")).click();
        wd.findElement(By.id("user")).click();
        wd.findElement(By.id("user")).clear();
        wd.findElement(By.id("user")).sendKeys("stritenkoqa");

        if(wd.findElement(By.id("password")).isDisplayed()){
            wd.findElement(By.id("password")).click();
            wd.findElement(By.id("password")).clear();
            wd.findElement(By.id("password")).sendKeys("esergeenko71");
            }
        wd.findElement(By.id("login")).click();
        if(wd.findElement(By.id("login-submit")).isDisplayed()){
            wd.findElement(By.id("username")).click();
            wd.findElement(By.id("username")).clear();
            wd.findElement(By.id("user")).sendKeys("stritenkoqa");

            wd.findElement(By.id("login-submit")).click();
            wd.findElement(By.id("password")).click();
            wd.findElement(By.id("password")).clear();
            wd.findElement(By.id("password")).sendKeys("esergeenko71");

        }


    }


    @AfterClass
    public void tearDown(){
        wd.quit();
    }
}
