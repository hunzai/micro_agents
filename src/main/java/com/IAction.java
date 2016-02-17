package com;

import org.openqa.selenium.WebElement;

/**
 * Created by asaleem on 18.01.16.
 */
public interface IAction {
    void click(String xpath);
    void submit(String xpath);
    void type(String xpath, String text );
    void openBrowser(String url);
    void wait(String xpath, int sec);
    void closeBrowser();
    WebElement findXPath(String xpath);
    WebElement findById(String id);
}
