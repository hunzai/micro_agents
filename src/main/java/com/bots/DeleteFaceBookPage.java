package com.bots;

import com.IAction;
import com.IResultProcessor;
import com.IMission;

/**
 * Created by asaleem on 09.01.16.
 */
public class DeleteFaceBookPage implements IMission {
    String faceBook = "https://www.facebook.com/";
    String userName = "";
    String password = "";

    String userXpath = "//*[@id='email']";
    String passwordXpath = "//*[@id='pass']";
    String gulgulingXpath = "//*[@id='navItem_398902336906711']/a/div[2]/span";
    String gulgulingSettingXpath = "//*[@id='pages_manager_top_bar_container']/div/div[2]/a/span";
    String gulgulingPeopleAndLinksXpath = "//*[@id='u_jsonp_4_l']/div/div/div[6]/a/div/span/div/div[1]/div/span";
    String gulgulingPeopleAndLinksUserSettingXPath = "//*[@id='adminableItem_100010077066142']/div/div/div[1]/div[2]";//*[@id="u_0_m"]

    String gulgulingPeopleAndLinksUserSettingRemoveXPath = "//*[@id='u_0_k']/div/ul/li[2]";
    String gulgulingPeopleAndLinksUserSettingRemoveConfirmXPath = "//*[@id='u_1w_1']/div[3]/button";

    public void perform(IAction action, IResultProcessor processor) {
        action.openBrowser(faceBook);
        action.type(userXpath, userName);
        action.type(passwordXpath, password);
        action.submit(passwordXpath);
        action.click(gulgulingXpath);
        action.click(gulgulingSettingXpath);
        action.click(gulgulingPeopleAndLinksXpath);
        action.click(gulgulingPeopleAndLinksUserSettingXPath);
        action.click(gulgulingPeopleAndLinksUserSettingRemoveXPath);
        action.click(gulgulingPeopleAndLinksUserSettingRemoveConfirmXPath);
        action.closeBrowser();
    }
}
