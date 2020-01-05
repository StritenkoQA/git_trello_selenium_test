package com.marinaS.trello.HW1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestHW extends TestBase {



    @Test
    public void testLogIn() throws InterruptedException {
        logIn();
        pause(1000);
        Assert.assertTrue(isAvatarPresentOnHeader());
    }


}
