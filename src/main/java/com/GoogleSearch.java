package com;

import java.util.logging.Logger;

/**
 * Created by asaleem on 08.01.16.
 */
public class GoogleSearch implements Task{
    String url = "https://www.google.de";
    String searchBoxXpath = "//*[@id='lst-ib']";
    String resultsXpath = "//*[@id='topstuff']";

    private  Logger logger = Logger.getLogger("com.GoogleSearch");

    public void perform(Action action) {
        action.openBrowser(url);
        action.type(searchBoxXpath, "euro to pkr");
        action.submit(searchBoxXpath);
        action.wait(resultsXpath, 3);
        String results = action.getElement(resultsXpath);
        logger.info(results);
        action.closeBrowser();
    }
}
