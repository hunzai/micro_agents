package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by asaleem on 08.01.16.
 */
public class  Action {

    private  WebDriver webDriver = null;

    public Action(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public void click(String xpath){
        wait(xpath, 2);
        find(xpath).click();
    }

    public void submit(String xpath){
        find(xpath).submit();
    }

    public void type(String xpath, String text ){
        find(xpath).sendKeys(text);
    }

    public String getElement(String xpath){
        WebElement element = find(xpath);
        return element.getText();
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

    public void clickOnAlert(String xpath){
        this.webDriver.switchTo().alert();
        find(xpath).click();
    }


    private WebElement find(String xpath){
       return this.webDriver.findElement(By.xpath(xpath));
    }
}
