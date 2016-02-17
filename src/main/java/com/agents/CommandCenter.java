package com.agents;

import com.IAction;
import com.IAgent;
import com.IHtmlProcessor;
import com.impl.Action;
import com.impl.HtmlProcessor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;

/**
 * Created by asaleem on 09.01.16.
 */
public class CommandCenter extends TimerTask {

    private String phantomjsPath = "/Users/asaleem/projects/micro_agents/lib/phantomjs-2.1.1-macosx/bin/phantomjs";
    Logger logger = Logger.getLogger("CommandCenter");
    DesiredCapabilities capabilities = new DesiredCapabilities();

    public CommandCenter(String phantomjsPath){
        capabilities.setCapability("phantomjs.binary.path",  phantomjsPath);
    }

    public static void main(String[] args) throws IOException {
        String phantomjsPath = System.getenv("PHANTOMJS");
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new CommandCenter(phantomjsPath),100, 1);
    }

    public void run() {
        WebDriver driver = new PhantomJSDriver(capabilities);

        IAgent agent  = new BestCarDeal();
        IAction  action = new Action(driver);

        IHtmlProcessor processor = new HtmlProcessor();
        agent.perform(action, processor);
    }

}
