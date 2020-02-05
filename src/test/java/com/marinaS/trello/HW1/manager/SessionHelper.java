package com.marinaS.trello.HW1.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.util.ArrayList;

public class SessionHelper extends HelperBase {
    HeaderHelper header = new HeaderHelper(wd);

    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public void clickLogInLink() throws InterruptedException {
        wd.findElement(By.cssSelector("[href='/login']")).click();
    }

    public void fillLogInForm() throws InterruptedException {
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

    public void confirmLogIn() {
        wd.findElement(By.id("login-submit")).click();
    }

    public void logIn() throws InterruptedException {
        clickLogInLink();
        fillLogInForm();
        confirmLogIn();
    }

    public void openUserProfileFromDropDown() {
        click(By.cssSelector("[data-test-id='header-member-menu-profile']"));
    }

//    public void goToAtlassianAccount() {
//        click(By.cssSelector("[href='https://id.atlassian.com/manage-profile']"));
//       //wd.getWindowHandles();
//       //wd.switchTo();
//        List<String> tabs = new ArrayList<String>(wd.getWindowHandles());
//        wd.switchTo().window(tabs.get(1));
//    }

    public void addAvatarImage() {
        //WebElement tmpElement = wd.findElement(By.id("image-input"));
        //String js = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";
        //JavascriptExecutor executor = (JavascriptExecutor)wd;
        //executor.executeScript(js, tmpElement);
        click(By.cssSelector("[data-test-selector='profile-avatar']"));
        if (isElementPresent(By.cssSelector("[role=menu]"))) {
            click(By.xpath("//*[@role='menu']//span[@role='menuitem'][1]"));
        }

        attach(By.id("image-input"), new File("C:\\Users\\strit\\Documents\\GitHub\\git_trello_selenium_test\\src\\test\\resources\\IMG_5004.JPG"));
        click(By.xpath("//*[contains(text(),'Upload')]"));
        pause(5000);
        wd.close();
        pause(3000);
        ArrayList<String> tabs = new ArrayList<>(wd.getWindowHandles());
        if (!tabs.isEmpty()) {
            wd.switchTo().window(tabs.get(0));
            pause(5000);
            wd.navigate().refresh();
            pause(5000);
        }

    }

    public void goToAtlassianAccount() {
        click(By.cssSelector("[href$=manage-profile]"));
        ArrayList<String> tabs = new ArrayList
                (wd.getWindowHandles());
        wd.switchTo().window(tabs.get(1));

    }

    public void addHeaderImage() {
        click(By.cssSelector("[data-test-selector='profile-header-image'"));
        attach(By.xpath("//*[@role='menu']//span[@role='menuitem'][0]"), new File("C:\\Users\\strit\\Documents\\GitHub\\git_trello_selenium_test\\src\\test\\resources\\IMG_5004.JPG"));
        pause(15000);
        wd.close();
        pause(3000);
        ArrayList<String> tabs = new ArrayList<>(wd.getWindowHandles());
        if (!tabs.isEmpty()) {
            wd.switchTo().window(tabs.get(0));
            pause(5000);
            wd.navigate().refresh();
            pause(5000);
        }
    }
}

