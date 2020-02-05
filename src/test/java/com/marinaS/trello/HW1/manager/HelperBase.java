package com.marinaS.trello.HW1.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class HelperBase {

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    WebDriver wd;

    public void pause(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }


    public  boolean isElementPresent(By locator){
        return wd.findElements(locator).size()>0;
    }

    public void attach(By locator, File file){
        wd.findElement(locator).sendKeys(file.getAbsolutePath());
        pause(10000);
    }

}

