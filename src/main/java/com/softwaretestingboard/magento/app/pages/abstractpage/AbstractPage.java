package com.softwaretestingboard.magento.app.pages.abstractpage;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class AbstractPage {

    @Step("Press space button")
    public void pressSpace() {
        try {
            new Actions(getWebDriver()).sendKeys(Keys.SPACE).build().perform();
        } catch (Exception e) {
            throw new Error("Error while plessing SPACE", e);
        }
    }

    @Step("Button click")
    public void clickButtonAbstractPage(AbstractLocators locator) { locator.getElement().click(); }

    @Step("Open What`s new page")
    public void openWhatsNewTab() { AbstractLocators.TAB_WHATSNEW.getElement().click(); }

    @Step("Open installation page")
    public void openWomenTab() { AbstractLocators.TAB_WOMEN.getElement().click(); }




}
