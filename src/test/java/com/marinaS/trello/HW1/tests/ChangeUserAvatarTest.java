package com.marinaS.trello.HW1.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChangeUserAvatarTest extends TestBase {


        @BeforeMethod
        public void ensurePreconditions() throws InterruptedException {
        if (!app.getHeaderHelper().isAvatarPresentOnHeader()) {
            app.getSessionHelper().logIn();
        }
}

@Test
public void testChangeAvatar(){
        logger.info("avatar before");
        app.takeScreenShot();
        app.getHeaderHelper().clickOnAvatar();
        app.getSessionHelper().openUserProfileFromDropDown();
        app.getSessionHelper().goToAtlassianAccount();
        app.getSessionHelper().addAvatarImage();
        logger.info("avatar after");
        app.takeScreenShot();
    }
}
