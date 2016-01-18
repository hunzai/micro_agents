package com.impl;

import com.IResultProcessor;

/**
 * Created by asaleem on 18.01.16.
 */
public class GoogleSearchResultProcessor implements IResultProcessor {
    public void process(String html) {
        System.out.print("google after search html source " + html);
    }
}
