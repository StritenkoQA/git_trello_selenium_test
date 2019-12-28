package com.marinaS.trello.HW1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver wd;

    @BeforeClass
    public void setUp(){
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.get("https://trello.com/");
    }

    @AfterClass
    public void tearDown(){
        wd.quit();
    }

    public void clickLogInLink() throws InterruptedException {
        wd.findElement(By.cssSelector("[href='/login']")).click();
    }

    public void fillLogInForm() throws InterruptedException {
        wd.findElement(By.id("user")).click();
        wd.findElement(By.id("user")).clear();
        wd.findElement(By.id("user")).sendKeys("stritenkoqa@gmail.com");


        pause(8000);


        wd.findElement(By.id("login")).click();
        wd.findElement(By.id("login-submit")).click();
        wd.findElement(By.id("password")).click();
        wd.findElement(By.id("password")).clear();
        wd.findElement(By.id("password")).sendKeys("esergeenko71");

    }

    public void pause(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void confirmLogIn() {
        wd.findElement(By.id("login-submit")).click();
    }

    public boolean isAvatarPresentOnHeader() {
        return isElementPresent
                (By.cssSelector("[data-test-id='header-member-menu-button']"));

    }

    public boolean isElementPresent(By locator){

        return wd.findElements(locator).size()>0;
    }

    public void logIn() throws InterruptedException {
        clickLogInLink();
        fillLogInForm();
        confirmLogIn();
    }
}
