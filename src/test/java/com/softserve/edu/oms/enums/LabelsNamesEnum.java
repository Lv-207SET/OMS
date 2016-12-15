package com.softserve.edu.oms.enums;

public enum LabelsNamesEnum {
    SHOW_10_ITEMS_LINK ("Show 10 items"),
    SEARCH_TEXT_NONE ("none"),
    SEARCH_TEXT_ER ("er"),
    BY_LAST_NAME ("lastName"),
    BY_LOGIN_NAME ("login"),
    BY_ROLE ("role");

    public final String name;

    LabelsNamesEnum (String name){
         this.name = name;
     }
}
