package com.marinaS.trello.HW1.tests;

import com.marinaS.trello.HW1.manager.HelperBase;
import com.marinaS.trello.HW1.model.BoardData;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {
    WebDriver wd;
    HelperBase helperBase = new HelperBase(wd);



    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {

        if (!app.getHeaderHelper().isAvatarPresentOnHeader()) {
            app.getSessionHelper().logIn();
        }
    }

    @Test
    public void addBoardFromHomePage() {
        app.getSessionHelper().pause(1000);
        int before = app.getBoardHelper().getBoardsCount();
        String boardName = "Test1";
        app.getBoardHelper().clickOnCreateNewBoardLinkFromHomePage();
        app.getSessionHelper().pause(1000);
        app.getBoardHelper().typeNameNewBoard(new BoardData(boardName));
        app.getSessionHelper().pause(1000);
        app.getBoardHelper().clickOnCreateNewBoardSubmitButton();
        app.getSessionHelper().pause(1000);
        app.getHeaderHelper().returnToHomePage();

        app.getSessionHelper().pause(1000);
        int after = app.getBoardHelper().getBoardsCount();
        Assert.assertEquals(after, before + 1);
    }

    @Test(dataProvider = "manualNames", dataProviderClass = DataProvider.class)
    public void addBoardFromHomePageA(String boardName) {
        app.pause(1000);
        int before = app.getBoardHelper().getBoardsCount();
        app.getBoardHelper().clickOnCreateNewBoardLinkFromHomePage();
        app.pause(1000);
        app.getBoardHelper().typeNameNewBoard(new BoardData(boardName));
        app.pause(1000);
        app.getBoardHelper().clickOnCreateNewBoardSubmitButton();
        app.pause(10000);
        app.returnToHomePage();
        app.getSessionHelper().pause(1000);
        int after = app.getBoardHelper().getBoardsCount();
        Assert.assertEquals(after, before + 1);
    }

    @Test(dataProvider = "validCsvNames", dataProviderClass = DataProvider.class)
    public void addBoardFromHomePageCSV(String boardName) {
        app.getSessionHelper().pause(1000);
        int before = app.getBoardHelper().getBoardsCount();
        app.getBoardHelper().clickOnCreateNewBoardLinkFromHomePage();
        app.getSessionHelper().pause(1000);
        app.getBoardHelper().typeNameNewBoard(new BoardData(boardName));
        app.getSessionHelper().pause(1000);
        app.getBoardHelper().clickOnCreateNewBoardSubmitButton();
        app.getSessionHelper().pause(1000);
        app.getHeaderHelper().returnToHomePage();

        app.getSessionHelper().pause(1000);
        int after = app.getBoardHelper().getBoardsCount();
        Assert.assertEquals(after, before + 1);
    }


    @AfterClass
    public void postActions() {
        int boardsCount = app.getBoardHelper().getBoardsCount();
        while (boardsCount > 4) {
            app.getBoardHelper().deleteBoard();
            boardsCount = app.getBoardHelper().getBoardsCount();
        }
    }

}
