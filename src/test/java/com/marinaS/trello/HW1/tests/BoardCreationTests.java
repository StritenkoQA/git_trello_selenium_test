package com.marinaS.trello.HW1.tests;

import com.marinaS.trello.HW1.manager.HelperBase;
import com.marinaS.trello.HW1.model.BoardData;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BoardCreationTests extends TestBase {
    WebDriver wd;
    HelperBase helperBase = new HelperBase(wd);

    @DataProvider
    public Iterator<Object> manualNames() {
        List<Object> names = new ArrayList<>();
        names.add("Manual1");
        names.add("Manual2");
        names.add("Manual3");
        return names.iterator();
    }

    @DataProvider
    public Iterator<Object> validCsvNames() throws IOException {
        List<Object> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/validBoardNames.csv")));
        String line = reader.readLine();
        while (line != null) {
            list.add(line);
            line = reader.readLine();
        }
        return list.iterator();
    }


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

    @Test(dataProvider = "manualNames")
    public void addBoardFromHomePageA(String boardName) {
        app.pause(1000);
        int before = app.getBoardHelper().getBoardsCount();
        app.getBoardHelper().clickOnCreateNewBoardLinkFromHomePage();
        app.pause(1000);
        app.getBoardHelper().typeNameNewBoard(new BoardData(boardName));
        app.pause(1000);
        app.getBoardHelper().clickOnCreateNewBoardSubmitButton();
        app.pause(8000);
        app.returnToHomePage();
        app.getSessionHelper().pause(1000);
        int after = app.getBoardHelper().getBoardsCount();
        Assert.assertEquals(after, before + 1);
    }

    @Test(dataProvider = "validCsvNames")
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
