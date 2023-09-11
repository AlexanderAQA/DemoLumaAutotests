package com.softwaretestingboard.magento.app.pages.abstractpage;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$;

public enum AbstractLocators {

    TAB_WHATSNEW($(Selectors.byId("ui-id-3"))),
    TAB_WOMEN($(Selectors.byId("ui-id-4"))),
    TAB_MEN($(Selectors.byId("ui-id-5"))),
    TAB_GEAR($(Selectors.byId("ui-id-6"))),
    TAB_TRAINING($(Selectors.byId("ui-id-7"))),
    FIELD_EMAIL($(Selectors.byId("email"))),
    FIELD_PASSWORD($(Selectors.byId("pass"))),
    BUTTON_SIGN_IN($(Selectors.byXpath("//*[contains(@class,'authorization-link')]"))),
    BUTTON_CREATE_AN_ACCOUNT($(Selectors.byXpath("//*[contains(@class,'authorization-link')]/following-sibling::li"))),
    TAB_SALE($(Selectors.byId("ui-id-8")));

    // path to csv file with login/password for different users
    private static final String CONF_FILE = System.getProperty("user.dir") + "/src/test/resources/files" + File.separator + "users.csv";

    private static final Map<String, User> map = new HashMap<>();

    private static final Map<String, SelenideElement> eventFieldKeys = new HashMap<>();

    static {
        eventFieldKeys.put(FIELD_EMAIL);
        eventFieldKeys.put(FIELD_PASSWORD);
    }

    private final SelenideElement element;
    AbstractLocators(SelenideElement element) {this.element = element;}

    /**     Method for getting locators */
    public SelenideElement getElement() {return element;}

}
