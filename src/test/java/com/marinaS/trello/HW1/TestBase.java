package com.marinaS.trello.HW1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class TestBase {
    protected static WebDriver wd;

    @BeforeSuite
    public void setUp() {
        String browser = System.getProperty("browser", BrowserType.CHROME);
        if (browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver();
        } else if (browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver();
        } else if (browser.equals(BrowserType.EDGE)) {
            wd = new EdgeDriver();
        }
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.get("https://trello.com/");
    }

        @AfterSuite
        public void tearDown () {
            wd.quit();
        }

        public void clickLogInLink () throws InterruptedException {
            wd.findElement(By.cssSelector("[href='/login']")).click();
        }

        public void fillLogInForm () throws InterruptedException {
            wd.findElement(By.id("user")).click();
            wd.findElement(By.id("user")).clear();
            wd.findElement(By.id("user")).sendKeys("stritenkoqa@gmail.com");


            pause(1000);


            wd.findElement(By.id("login")).click();
            wd.findElement(By.id("login-submit")).click();
            wd.findElement(By.id("password")).click();
            wd.findElement(By.id("password")).clear();
            wd.findElement(By.id("password")).sendKeys("esergeenko71");

        }

        public void pause ( long millis){
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void confirmLogIn () {
            wd.findElement(By.id("login-submit")).click();
        }

        public boolean isAvatarPresentOnHeader () {
            return isElementPresent
                    (By.cssSelector("[data-test-id='header-member-menu-button']"));

        }

        public boolean isElementPresent (By locator){

            return wd.findElements(locator).size() > 0;
        }

        public void logIn () throws InterruptedException {
            clickLogInLink();
            fillLogInForm();
            confirmLogIn();
        }

        public void click (By locator){
            wd.findElement(locator).click();
        }

        public void type (By locator, String text){
            click(locator);
            wd.findElement(locator).clear();
            wd.findElement(locator).sendKeys(text);
        }

        public int getBoardsCount () {
            return wd.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size() - 1;
        }

        public boolean isBoardPresent (String boardName){
            return isElementPresent(By.cssSelector("[title='" + boardName + "']"));
        }

        public void createBoard () {
            String boardName = "Test1";
            clickOnCreateNewBoardLinkFromHomePage();
            pause(5000);
            typeNameNewBoard(boardName);
            pause(1000);
            clickOnCreateNewBoardSubmitButton();
            pause(1000);
            returnToHomePage();
        }


        public void returnToHomePage () {
            click(By.name("house"));
            click(By.name("house"));
        }

        public void clickOnCreateNewBoardSubmitButton () {
            wd.findElement(By.cssSelector("[data-test-id='create-board-submit-button']")).click();
        }

        public void typeNameNewBoard (String boardName){

            wd.findElement(By.cssSelector("[data-test-id='create-board-title-input']")).sendKeys(boardName);
        }

        public void clickOnCreateNewBoardLinkFromHomePage () {
            wd.findElement(By.xpath("//div[@class='board-tile mod-add']")).click();
        }

        public boolean isThereBoard () {
            pause(10000);
            int boards = getBoardsCount();
            return boards != 0;
        }

        public void permanentlyDeleteBoard () {
            click(By.cssSelector(".js-delete"));
            clickOnConfirmCloseBoard();
        }

        public void clickOnConfirmCloseBoard () {
            click(By.cssSelector(".js-confirm[type='submit']"));
        }

        public void clickOnCloseBoardLink () {
            click(By.cssSelector(".js-close-board"));
        }

        public void clickOnMoreLink () {
            click(By.cssSelector(".js-open-more"));
        }

        public void openFirstBoard () {
            click(By.xpath("//*[@class='icon-lg icon-member']/../../..//li[1]"));
        }

        public void deleteBoard () {
            openFirstBoard();
            pause(10000);
            clickOnMoreLink();
            clickOnCloseBoardLink();
            clickOnConfirmCloseBoard();
            permanentlyDeleteBoard();
            returnToHomePage();
        }

    }
