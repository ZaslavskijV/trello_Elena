package com.trello.qa.manager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class ApplicationManager {
  AppiumDriver driver;
  TeamHelper teamHelper;
  BoardHelper boardHelper;
  SessionHelper sessionHelper;
  UserHelper userHelper;

  public void init() throws MalformedURLException, InterruptedException {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("platformName", "Android");
    capabilities.setCapability("deviceName", "Nexus_6");
    capabilities.setCapability( "platformVersion", "8.0");
    capabilities.setCapability("automationName", "Appium");
    capabilities.setCapability( "appPackage", "com.trello");
    capabilities.setCapability("appActivity",".home.HomeActivity");
    capabilities.setCapability("app",
            "C:/Tools/Trello_new.apk");

    driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);


    teamHelper = new TeamHelper(driver);
    boardHelper = new BoardHelper(driver);
    sessionHelper = new SessionHelper(driver);
    userHelper = new UserHelper(driver);


    sessionHelper.login("zvs2010@gmail.com", "23666632");

  }

  public void stop() throws InterruptedException {
    Thread.sleep(10000);
  driver.quit();
  }

  public TeamHelper getTeamHelper() {
    return teamHelper;
  }

  public BoardHelper getBoardHelper() {
    return boardHelper;
  }

  public SessionHelper getSessionHelper() {
    return sessionHelper;
  }

  public UserHelper getUserHelper() {
    return userHelper;
  }
}
