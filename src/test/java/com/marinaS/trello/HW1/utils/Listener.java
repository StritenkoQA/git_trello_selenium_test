package com.marinaS.trello.HW1.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static com.marinaS.trello.HW1.tests.TestBase.app;


public class Listener implements ITestListener {
    Logger logger = LoggerFactory.getLogger(Listener.class);

    @Override
    public void onTestSuccess(ITestResult result) {
      logger.info(result.getName()  + " Passed Successful");
    }

    @Override
    public void onTestFailure(ITestResult result) {
    logger.error(result.getName() + " Failed\n" + result.getThrowable().toString());
    app.takeScreenShot();
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }


}
