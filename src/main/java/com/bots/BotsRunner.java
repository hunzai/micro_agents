package com.bots;

import com.Action;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;

/**
 * Created by asaleem on 09.01.16.
 */
public class BotsRunner {

    public static void main(String[] args) throws IOException {
        WebDriver webDriver = new FirefoxDriver();
        EuroPrice manager = new EuroPrice();
        Action action = new Action(webDriver);
        manager.perform(action);

    }
}
