package com.marinaS.trello.HW1.manager;

import com.marinaS.trello.HW1.model.BoardData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BoardHelper extends HelperBase {

    public BoardHelper(WebDriver wd) {
        super(wd);
    }

    public int getBoardsCount() {
        return wd.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size() - 1;
    }

//   public boolean isBoardPresent (String boardName){
//            return isElementPresent(By.cssSelector("[title='" + boardName + "']"));
//        }

    public void createBoard() {
        String boardName = "Test1";
        clickOnCreateNewBoardLinkFromHomePage();
        pause(5000);
        typeNameNewBoard(new BoardData(boardName));
        pause(1000);
        clickOnCreateNewBoardSubmitButton();
        pause(1000);

    }

    public void clickOnCreateNewBoardSubmitButton() {
        wd.findElement(By.cssSelector("[data-test-id='create-board-submit-button']")).click();
    }

    public void typeNameNewBoard(BoardData boardName1) {

        type(By.cssSelector("[data-test-id='create-board-title-input']"), boardName1.getBoardName());
    }

    public void clickOnTypeDescription(){
        wd.findElement(By.cssSelector("[class='list-name-input']")).click();
    }

    public void typeDescription(String description){
        type(By.cssSelector("[class='list-name-input']"), description);
    }

    public void clickOnCreateNewBoardLinkFromHomePage() {
        wd.findElement(By.xpath("//div[@class='board-tile mod-add']")).click();
    }

    public boolean isThereBoard() {
        pause(10000);
        int boards = getBoardsCount();
        return boards != 0;
    }

    public void permanentlyDeleteBoard() {
        click(By.cssSelector(".js-delete"));
        clickOnConfirmCloseBoard();
    }

    public void clickOnPlusButton() {
        click(By.cssSelector("[data-test-id='header-create-menu-button']"));
    }


    public void clickOnConfirmCloseBoard() {
        click(By.cssSelector(".js-confirm[type='submit']"));
    }

    public void clickOnCloseBoardLink() {
        click(By.cssSelector(".js-close-board"));
    }

    public void clickOnMoreLink() {
        click(By.cssSelector(".js-open-more"));
    }

    public void openFirstBoard() {
        click(By.xpath("//*[@class='icon-lg icon-member']/../../..//li[1]"));
    }

    public void deleteBoard() {
        openFirstBoard();
        pause(10000);
        clickOnMoreLink();
        clickOnCloseBoardLink();
        clickOnConfirmCloseBoard();
        permanentlyDeleteBoard();

    }
}
