package com.softwaretestingboard.magento.app.pages.whatsnew;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public enum WhatsnewLocators {

    TITLE_WHATS_NEW_IN_WOMENS($(Selectors.byTitle("New in women's")));

    private final SelenideElement element;
    WhatsnewLocators(SelenideElement element) {this.element = element;}

    /**     Method for getting locators */
    public SelenideElement getElement() {return element;}
}
