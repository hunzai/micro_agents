package com;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;

/**
 * Created by asaleem on 09.01.16.
 */
public class Agent {

    public static void main(String[] args) throws IOException {
        WebDriver webDriver = new FirefoxDriver();
        FaceBook manager = new FaceBook();
        Action action = new Action(webDriver);
        manager.perform(action);

    }
}
