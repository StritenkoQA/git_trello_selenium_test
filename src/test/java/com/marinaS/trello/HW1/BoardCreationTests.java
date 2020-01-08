package com.marinaS.trello.HW1;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {


    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if(!app.isAvatarPresentOnHeader()){
            app.logIn();
        }
    }

    @Test
    public void addBoardFromHomePage(){
        app.pause(1000);
        int before = app.getBoardsCount();
        String boardName = "Test1";
        app.clickOnCreateNewBoardLinkFromHomePage();
        app.pause(1000);
        app.typeNameNewBoard(boardName);
        app.pause(1000);
        app.clickOnCreateNewBoardSubmitButton();
        app.pause(1000);
        app.returnToHomePage();

        app.pause(1000);
        int after = app.getBoardsCount();
        Assert.assertEquals(after, before + 1);
    }

        @AfterClass
    public void postActions(){
        int boardsCount = app.getBoardsCount();
        while (boardsCount > 4){
            app.deleteBoard();

            boardsCount = app.getBoardsCount();
        }
        }

}
