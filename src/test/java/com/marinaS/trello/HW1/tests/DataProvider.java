package com.marinaS.trello.HW1.tests;

import com.marinaS.trello.HW1.model.TeamData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProvider {

    @org.testng.annotations.DataProvider
    public Iterator<Object> manualNames() {
        List<Object> names = new ArrayList<>();
        names.add("Manual1");
        names.add("Manual2");
        names.add("Manual3");
        return names.iterator();
    }

    @org.testng.annotations.DataProvider
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

    @org.testng.annotations.DataProvider
    public Iterator<Object[]> validTeams() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"name DP","decsription DP"});
        list.add(new Object[]{"DPn1",""});
        list.add(new Object[]{"DPn2","2"});
        return list.iterator();
    }

    @org.testng.annotations.DataProvider
    public Iterator<Object[]> validTeamsCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/teamsPositiveCSV_List1.csv")));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{
                    new TeamData()
                            .withTeamName(split[0])
                            .getTeamDescr()});
        }
        return list.iterator();
    }


}

