package com.impl;

import com.IAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by asaleem on 08.01.16.
 */
public class  Action implements IAction {

    private  WebDriver webDriver = null;
    private int timeout = 2;


    public Action(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public void click(String xpath){
        wait(xpath, this.timeout);
        findXPath(xpath).click();
    }

    public void submit(String xpath){
        findXPath(xpath).submit();
    }

    public void type(String xpath, String text ){
        findXPath(xpath).sendKeys(text);
    }

    public WebElement getElement(String xpath){
        WebElement element = findXPath(xpath);
        return element;
    }

    public void openBrowser(String url){
      this.webDriver.get(url);
    }

    public void wait(String xpath, int sec){
            (new WebDriverWait(webDriver, sec)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }

    public void closeBrowser(){
        this.webDriver.close();
    }

    public WebElement findXPath(String xpath){
       return this.webDriver.findElement(By.xpath(xpath));
    }
    public WebElement findById(String id){
        return this.webDriver.findElement(By.id(id));
    }
}
