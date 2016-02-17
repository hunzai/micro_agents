package com.agents;

import com.IAction;
import com.IHtmlProcessor;
import com.IAgent;
import org.openqa.selenium.WebElement;

import java.util.logging.Logger;

/**
 * Created by asaleem on 08.01.16.
 */
public class EuroPrice implements IAgent {
    String url = "https://www.google.de";
    String searchBoxXpath = "//*[@id='lst-ib']";
    String resultsXpath = "//*[@id=\"topstuff\"]";

    private  Logger logger = Logger.getLogger("com.agents.EuroPrice");

    public void perform(IAction action, IHtmlProcessor processor) {
        action.openBrowser(url);
        action.type(searchBoxXpath, "euro to us dollar");
        action.submit(searchBoxXpath);
        action.wait(resultsXpath, 3);
        WebElement webElement = action.findXPath(resultsXpath);
        processor.process(webElement.getText());
        action.closeBrowser();
    }
}
