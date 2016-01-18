package com;


/**
 * Created by asaleem on 08.01.16.
 */
public interface IMission {
    void perform(IAction action, IResultProcessor processor);
}
