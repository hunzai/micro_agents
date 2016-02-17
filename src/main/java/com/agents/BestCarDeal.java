package com.agents;

import com.IAction;
import com.IAgent;
import com.IHtmlProcessor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by asaleem on 17/02/16.
 */
public class BestCarDeal implements IAgent{

    String ebayKleinenzeigenUrl = "https://www.ebay-kleinanzeigen.de/s-autos/berlin/c216l3331";
    String carAdsId = "srchrslt-adtable";
    String paginationId = "srchrslt-pagination";
    String adItemClassName = "ad-listitem";
    String mainInfo = "aditem-main"; String kmAndYearClass = "text-module-end";
    String adSinceClass = "aditem-addon";
    String priceAndAddressElemenetClass = "aditem-details";

    public void perform(IAction action, IHtmlProcessor processor) {
        action.openBrowser(ebayKleinenzeigenUrl);
        WebElement adElement = action.findById(carAdsId);

        List<WebElement> currentPageAds = adElement.findElements(By.className(adItemClassName));

        for (WebElement element : currentPageAds){
            WebElement adItem = element.findElement(By.className("aditem"));
            WebElement priceAndAddress = adItem.findElement(By.className(priceAndAddressElemenetClass));
            WebElement sinceWhenElement = adItem.findElement(By.className(adSinceClass));

              WebElement mainInfoElement = adItem.findElement(By.className(mainInfo));
              WebElement kmAndYearElement = mainInfoElement.findElement(By.className(kmAndYearClass));

            WebElement link = mainInfoElement.findElement(By.className("text-module-begin")).findElement(By.tagName("a"));

            StringBuilder carsOfTheDay = new StringBuilder();
            carsOfTheDay.append(priceAndAddress.getText());
            carsOfTheDay.append("\n" + sinceWhenElement.getText());
            carsOfTheDay.append("\n" + kmAndYearElement.getText());
            carsOfTheDay.append("\n" + link.getText());

            processor.process(carsOfTheDay.toString());
        }

        action.closeBrowser();
    }
}
