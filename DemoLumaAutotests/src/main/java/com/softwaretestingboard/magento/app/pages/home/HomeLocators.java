package com.softwaretestingboard.magento.app.pages.home;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public enum HomeLocators {

    FIELD_SEARCH($(Selectors.byId("search")));

    private final SelenideElement element;
    HomeLocators(SelenideElement element) {this.element = element;}

    /**     Method for getting locators */
    public SelenideElement getElement() {return element;}

}
