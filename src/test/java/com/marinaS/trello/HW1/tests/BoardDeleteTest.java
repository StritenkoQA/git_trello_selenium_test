package com.marinaS.trello.HW1.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeleteTest extends TestBase {


    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if (!app.getHeaderHelper().isAvatarPresentOnHeader()) {
            app.getSessionHelper().logIn();
        }
        if (!app.getBoardHelper().isThereBoard()) {
            app.getBoardHelper().createBoard();
        }
    }


    @Test
    public void deleteFirstBoardTest() {
        app.getSessionHelper().pause(1000);
        int before = app.getBoardHelper().getBoardsCount();
        app.getBoardHelper().openFirstBoard();
        app.getSessionHelper().pause(1000);
        app.getBoardHelper().clickOnMoreLink();
        app.getBoardHelper().clickOnCloseBoardLink();
        app.getBoardHelper().clickOnConfirmCloseBoard();
        app.getBoardHelper().permanentlyDeleteBoard();
        app.getHeaderHelper().returnToHomePage();

        int after = app.getBoardHelper().getBoardsCount();
        Assert.assertEquals(after, before - 1);
    }

}
