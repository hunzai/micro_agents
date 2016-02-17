package com.agents;

import com.IAction;
import com.IAgent;
import com.IHtmlProcessor;
import com.impl.Action;
import com.impl.HtmlProcessor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by asaleem on 09.01.16.
 */
public class CommandCenter extends TimerTask {

    public static void main(String[] args) throws IOException {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new CommandCenter(), 1, 3000);
    }
    // this method performs the task
    public void run() {
        //WebDriver webDriver = new FirefoxDriver();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("phantomjs.binary.path", "/Users/asaleem/projects/micro_agents/lib/phantomjs-2.1.1-macosx/bin/phantomjs");
        WebDriver driver = new PhantomJSDriver(capabilities);

        IAgent agent  = new BestCarDeal();
        IAction  action = new Action(driver);
        IHtmlProcessor processor = new HtmlProcessor();
        agent.perform(action, processor);
    }

}
