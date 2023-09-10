package com.softwaretestingboard.magento.app.pages.home;

import com.codeborne.selenide.Condition;
import com.softwaretestingboard.magento.app.pages.abstractpage.AbstractLocators;
import com.softwaretestingboard.magento.app.pages.abstractpage.AbstractPage;
import io.qameta.allure.Step;

public class HomePage extends AbstractPage {

    @Step("Button click")
    public void clickButtonHomePage(HomeLocators locator) {locator.getElement().click();}

    @Step("Checking if all tabs exists from homepage")
    public void checkIfAllTabsExists() {
        AbstractLocators.TAB_WHATSNEW.getElement().should(Condition.exist);
        AbstractLocators.TAB_WOMEN.getElement().should(Condition.exist);
        AbstractLocators.TAB_MEN.getElement().should(Condition.exist);
        AbstractLocators.TAB_GEAR.getElement().should(Condition.exist);
        AbstractLocators.TAB_TRAINING.getElement().should(Condition.exist);
        AbstractLocators.TAB_SALE.getElement().should(Condition.exist);
        AbstractLocators.BUTTON_SIGN_IN.getElement().should(Condition.exist);
    }
}
