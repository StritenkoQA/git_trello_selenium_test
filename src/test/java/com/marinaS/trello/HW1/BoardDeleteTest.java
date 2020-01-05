package com.marinaS.trello.HW1;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeleteTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if (!isAvatarPresentOnHeader()) {
            logIn();
        }
        if(!isThereBoard()){
            createBoard();
        }
    }


    @Test
    public void deleteFirstBoardTest () {
        pause(1000);
        int before = getBoardsCount();
        openFirstBoard();
        pause(1000);
        clickOnMoreLink();
        clickOnCloseBoardLink();
        clickOnConfirmCloseBoard();
        permanentlyDeleteBoard();
        returnToHomePage();

        int after = getBoardsCount();
        Assert.assertEquals(after, before - 1);
    }

}
