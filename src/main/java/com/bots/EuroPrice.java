package com.bots;

import com.Action;
import com.Task;
import org.openqa.selenium.WebElement;

import java.util.logging.Logger;

/**
 * Created by asaleem on 08.01.16.
 */
public class EuroPrice implements Task {
    String url = "https://www.google.de";
    String searchBoxXpath = "//*[@id='lst-ib']";
    String resultsXpath = "//*[@id=\"topstuff\"]";

    private  Logger logger = Logger.getLogger("com.bots.EuroPrice");

    public void perform(Action action) {
        action.openBrowser(url);
        action.type(searchBoxXpath, "euro to us dollar");
        action.submit(searchBoxXpath);
        action.wait(resultsXpath, 3);
        WebElement webElement = action.getElement(resultsXpath);
        logger.info(webElement.getText());
        action.closeBrowser();
    }
}
