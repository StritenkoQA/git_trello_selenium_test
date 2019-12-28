package com.marinaS.trello.HW1;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {


    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if(!isAvatarPresentOnHeader()){
            logIn();
        }
    }

    @Test
    public void addBoard(){
        String boardName = "TestTest";
        wd.findElement(By.xpath("//div[@class='board-tile mod-add']")).click();
        wd.findElement(By.cssSelector("[data-test-id='create-board-title-input']")).click();
        wd.findElement(By.cssSelector("[data-test-id='create-board-title-input']")).sendKeys(boardName);
        pause(1000);
        wd.findElement(By.cssSelector("[data-test-id='create-board-submit-button']")).click();
        Assert.assertTrue(isBoardPresent(boardName));
    }

    public boolean isBoardPresent(String boardName){
        return isElementPresent(By.cssSelector("[title='" + boardName +"']"));
    }



}
