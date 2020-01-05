package com.marinaS.trello.HW1;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
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
    public void addBoardFromHomePage(){
        pause(1000);
        int before = getBoardsCount();
        String boardName = "Test1";
        clickOnCreateNewBoardLinkFromHomePage();
        pause(1000);
        typeNameNewBoard(boardName);
        pause(1000);
        clickOnCreateNewBoardSubmitButton();
        pause(1000);
        returnToHomePage();

        pause(1000);
        int after = getBoardsCount();
        Assert.assertEquals(after, before + 1);
    }

        @AfterClass
    public void postActions(){
        int boardsCount = getBoardsCount();
        while (boardsCount > 4){
            deleteBoard();

            boardsCount = getBoardsCount();
        }
        }

}
