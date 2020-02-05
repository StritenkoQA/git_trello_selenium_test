package com.marinaS.trello.HW1.manager;

import com.google.common.io.Files;
import com.marinaS.trello.HW1.utils.Listener;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    BoardHelper boardHelper;
    TeamHelper teamHelper;
    SessionHelper sessionHelper;
    HeaderHelper headerHelper;

    WebDriver wd;
    Logger logger = LoggerFactory.getLogger(Listener.class);

    public void init() {
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


        boardHelper = new BoardHelper(wd);
        teamHelper = new TeamHelper(wd);
        sessionHelper = new SessionHelper(wd);
        headerHelper = new HeaderHelper(wd);

    }

    public void stop() {
        wd.quit();
    }
    public void takeScreenShot(){
        File tmp = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
        File screenShot = new File("src/test/screenshots/screen-"+System.currentTimeMillis()+".png");
        try {
            Files.copy(tmp, screenShot);
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("\nCreated screenshot: " + screenShot.getAbsolutePath());
    }


    public BoardHelper getBoardHelper() {
        return boardHelper;
    }

    public TeamHelper getTeamHelper() {
        return teamHelper;
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }

    public HeaderHelper getHeaderHelper() {
        return headerHelper;
    }

    public void pause(long millis) {
        sessionHelper.pause(millis);
    }

    public void returnToHomePage() {
        headerHelper.returnToHomePage();
    }

    public boolean isAvatarPresentOnHeader() {
        return headerHelper.isAvatarPresentOnHeader();
    }

    public int getBoardsCount() {
        return boardHelper.getBoardsCount();
    }

    public void createBoard() {
        boardHelper.createBoard();
    }

    public void getTeam() {
    }
}
