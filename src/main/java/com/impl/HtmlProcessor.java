package com.impl;

import com.IHtmlProcessor;

/**
 * Created by asaleem on 18.01.16.
 */
public class HtmlProcessor implements IHtmlProcessor {
    public void process(String html) {
        System.out.println("##########################################");
        System.out.println( html);
        System.out.println("##########################################");
    }
}
