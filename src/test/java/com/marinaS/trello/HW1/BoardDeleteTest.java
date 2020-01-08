package com.marinaS.trello.HW1;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeleteTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if (!app.isAvatarPresentOnHeader()) {
            app.logIn();
        }
        if(!app.isThereBoard()){
            app.createBoard();
        }
    }


    @Test
    public void deleteFirstBoardTest () {
        app.pause(1000);
        int before = app.getBoardsCount();
        app.openFirstBoard();
        app.pause(1000);
        app.clickOnMoreLink();
        app.clickOnCloseBoardLink();
        app.clickOnConfirmCloseBoard();
        app.permanentlyDeleteBoard();
        app.returnToHomePage();

        int after = app.getBoardsCount();
        Assert.assertEquals(after, before - 1);
    }

}
