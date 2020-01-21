package com.marinaS.trello.HW1.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestHW extends TestBase {


    @Test
    public void testLogIn() throws InterruptedException {
        app.getSessionHelper().logIn();
        app.getSessionHelper().pause(8000);
        Assert.assertTrue(app.getHeaderHelper().isAvatarPresentOnHeader());
    }


}
