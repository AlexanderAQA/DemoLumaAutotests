package com.softwaretestingboard.magento.app.pages.abstractpage;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public enum AbstractLocators {

    TAB_WHATSNEW($(Selectors.byId("ui-id-3"))),
    TAB_WOMEN($(Selectors.byId("ui-id-4"))),
    TAB_MEN($(Selectors.byId("ui-id-5"))),
    TAB_GEAR($(Selectors.byId("ui-id-6"))),
    TAB_TRAINING($(Selectors.byId("ui-id-7"))),
    BUTTON_SIGN_IN($(Selectors.byXpath("//*[contains(@class,'authorization-link')]"))),
    TAB_SALE($(Selectors.byId("ui-id-8")));

    private final SelenideElement element;
    AbstractLocators(SelenideElement element) {this.element = element;}

    /**     Method for getting locators */
    public SelenideElement getElement() {return element;}

}
