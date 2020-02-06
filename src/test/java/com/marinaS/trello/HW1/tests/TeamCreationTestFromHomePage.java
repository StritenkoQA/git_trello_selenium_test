package com.marinaS.trello.HW1.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamCreationTestFromHomePage extends TestBase {


    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if (!app.getHeaderHelper().isAvatarPresentOnHeader()) {
            app.pause(8000);
            app.getSessionHelper().logIn();
        }
    }

    @Test(dataProvider = "validTeams", dataProviderClass = DataProvider.class)
    public void teamCreationTestFromHomePageWithDP(String teamNamee, String teamDescr) {
        app.getHeaderHelper().pause(10000);
        app.getBoardHelper().clickOnPlusButton();
        app.pause(8000);
        app.getTeamHelper().selectCreateTeamFromDropDown();
        app.pause(10000);
        app.getTeamHelper().fillTeamCreationForm(teamNamee, teamDescr);
        app.getSessionHelper().pause(10000);
        app.getTeamHelper().submitTeamCreation();
        app.getTeamHelper().clickOnSlowLetterButton();
        app.pause(10000);
        app.getHeaderHelper().returnToHomePage();
        app.pause(8000);
    }

    @Test
    public void teamCreationTestFromHomePage() {
        app.getHeaderHelper().pause(10000);
        app.getBoardHelper().clickOnPlusButton();
        app.getSessionHelper().pause(8000);
        app.getTeamHelper().selectCreateTeamFromDropDown();
        app.getSessionHelper().pause(10000);
        app.getTeamHelper().fillTeamCreationForm("teamName", "teamDescr");
        app.getTeamHelper().submitTeamCreation();
        app.getTeamHelper().clickOnSlowLetterButton();
        app.pause(8000);
        app.getHeaderHelper().returnToHomePage();
        app.pause(8000);


    }

    @Test(dataProvider = "validTeamsCSV",dataProviderClass = DataProvider.class)
    public void teamCreationTestFromHomePageCSV(String teamNamee, String teamDescr) {
        app.getHeaderHelper().pause(10000);
        app.getBoardHelper().clickOnPlusButton();
        app.getSessionHelper().pause(8000);
        app.getTeamHelper().selectCreateTeamFromDropDown();
        app.getSessionHelper().pause(10000);
        app.getTeamHelper().fillTeamCreationForm(teamNamee, teamDescr);
        app.getTeamHelper().submitTeamCreation();
        app.getTeamHelper().clickOnSlowLetterButton();
        app.pause(8000);
        app.getHeaderHelper().returnToHomePage();
        app.pause(8000);

    }
}
