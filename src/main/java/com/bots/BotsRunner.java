package com.bots;

import com.IAction;
import com.IResultProcessor;
import com.impl.Action;
import com.impl.GoogleSearchResultProcessor;
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
        IAction  action = new Action(webDriver);
        IResultProcessor processor = new GoogleSearchResultProcessor();

        manager.perform(action, processor );

    }
}
